package com.example.devopspipeline.service;

import com.example.devopspipeline.model.PipelineStage;
import com.example.devopspipeline.repository.PipelineStageRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class PipelineService {

    private final PipelineStageRepository repository;
    private final Random rand = new Random();

    // define pipeline stage order
    private final List<String> STAGES = Arrays.asList("Source", "Build", "Test", "Deploy", "Monitor");

    public PipelineService(PipelineStageRepository repository) {
        this.repository = repository;
    }

    /**
     * Triggers a pipeline run. Runs stages sequentially,
     * simulates work with sleep, uses random success/failure,
     * stores each stage record in MongoDB.
     *
     * Returns the runId (UUID) used to group stages.
     */
    public String runPipelineSimulation() {
        String runId = UUID.randomUUID().toString();
        for (String stageName : STAGES) {
            PipelineStage stage = new PipelineStage(runId, stageName);
            stage.setStatus("Running");
            stage.setStartedAt(Instant.now());
            repository.save(stage);

            // Simulate stage work (100-900 ms)
            long wait = 100 + rand.nextInt(800);
            try {
                Thread.sleep(wait);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // Simulate result: 85% success chance (make failures less frequent)
            boolean success = rand.nextInt(100) < 85;

            stage.setFinishedAt(Instant.now());
            stage.setDurationMs(stage.getFinishedAt().toEpochMilli() - stage.getStartedAt().toEpochMilli());
            stage.setLogs("Simulated logs for " + stageName + ". Waited " + wait + "ms.");

            if (success) {
                stage.setStatus("Success");
                repository.save(stage);
            } else {
                stage.setStatus("Failed");
                repository.save(stage);
                // stop pipeline on failure
                break;
            }
        }
        return runId;
    }

    public List<PipelineStage> getStagesForRun(String runId) {
        return repository.findByRunIdOrderByStartedAtAsc(runId);
    }

    public List<PipelineStage> getRecentStages() {
        return repository.findTop50ByOrderByStartedAtDesc();
    }
}

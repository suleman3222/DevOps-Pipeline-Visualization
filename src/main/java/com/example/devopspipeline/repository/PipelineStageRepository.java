package com.example.devopspipeline.repository;

import com.example.devopspipeline.model.PipelineStage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PipelineStageRepository extends MongoRepository<PipelineStage, String> {
    List<PipelineStage> findByRunIdOrderByStartedAtAsc(String runId);
    List<PipelineStage> findTop50ByOrderByStartedAtDesc();
}

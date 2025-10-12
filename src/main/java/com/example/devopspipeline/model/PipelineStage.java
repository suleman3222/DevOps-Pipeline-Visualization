package com.example.devopspipeline.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Objects;

@Document(collection = "pipeline_stages")
public class PipelineStage {
    @Id
    private String id;
    private String runId;         // grouping multiple stages in a single pipeline run
    private String name;
    private String status;        // Pending/Running/Success/Failed
    private Instant startedAt;
    private Instant finishedAt;
    private long durationMs;
    private String logs;

    public PipelineStage() {}

    public PipelineStage(String runId, String name) {
        this.runId = runId;
        this.name = name;
        this.status = "Pending";
    }

    // getters and setters

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getRunId() { return runId; }
    public void setRunId(String runId) { this.runId = runId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Instant getStartedAt() { return startedAt; }
    public void setStartedAt(Instant startedAt) { this.startedAt = startedAt; }
    public Instant getFinishedAt() { return finishedAt; }
    public void setFinishedAt(Instant finishedAt) { this.finishedAt = finishedAt; }
    public long getDurationMs() { return durationMs; }
    public void setDurationMs(long durationMs) { this.durationMs = durationMs; }
    public String getLogs() { return logs; }
    public void setLogs(String logs) { this.logs = logs; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PipelineStage that = (PipelineStage) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

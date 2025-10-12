package com.example.devopspipeline.controller;

import com.example.devopspipeline.model.PipelineStage;
import com.example.devopspipeline.service.PipelineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PipelineController {

    private final PipelineService pipelineService;

    public PipelineController(PipelineService pipelineService) {
        this.pipelineService = pipelineService;
    }

    @GetMapping("/")
    public String index(Model model, @RequestParam(value = "runId", required = false) String runId) {
        if (runId != null) {
            List<PipelineStage> runStages = pipelineService.getStagesForRun(runId);
            model.addAttribute("currentRunId", runId);
            model.addAttribute("runStages", runStages);
        } else {
            model.addAttribute("currentRunId", "");
            model.addAttribute("runStages", null);
        }
        model.addAttribute("recentStages", pipelineService.getRecentStages());
        return "index";
    }

    @PostMapping("/run")
    public String runPipeline() {
        String runId = pipelineService.runPipelineSimulation();
        // redirect to index with runId to display results
        return "redirect:/?runId=" + runId;
    }

    // simple API: get stages for a run as JSON
    @GetMapping("/api/run/{runId}")
    @ResponseBody
    public List<PipelineStage> getRunJson(@PathVariable String runId) {
        return pipelineService.getStagesForRun(runId);
    }
}

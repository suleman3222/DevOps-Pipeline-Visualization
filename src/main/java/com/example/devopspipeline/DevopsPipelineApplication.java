package com.example.devopspipeline;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.devopspipeline.model.PipelineStage;
import com.example.devopspipeline.repository.PipelineStageRepository;

@SpringBootApplication
public class DevopsPipelineApplication {
    public static void main(String[] args) {
        SpringApplication.run(DevopsPipelineApplication.class, args);
    }
    @Bean
    CommandLineRunner runner(PipelineStageRepository repository) {
        return args -> {
            PipelineStage stage = new PipelineStage();
            stage.setName("Build");
            stage.setStatus("Pending");
            repository.save(stage);

            System.out.println("Sample stage saved to MongoDB!");
        };
    }
}

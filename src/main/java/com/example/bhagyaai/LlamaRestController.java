package com.example.bhagyaai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LlamaRestController {

    private final LlamaAiService llamaAiService;

    @Autowired
    public LlamaRestController(LlamaAiService llamaAiService) {
        this.llamaAiService = llamaAiService;
    }

    @GetMapping("api/v1/ai/generate")
    public ResponseEntity<LlamaResponse> generate(
            @RequestParam(value = "promptMessage", defaultValue = "Why is the sky blue?")
            String promptMessage) {
        final LlamaResponse aiResponse = llamaAiService.generate(promptMessage);
        return ResponseEntity.status(HttpStatus.OK).body(aiResponse);
    }

}
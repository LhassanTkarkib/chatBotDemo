package com.migrationdemo.chatbotai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LlamaRestController {

    private final LlamaAiService llamaAiService;

    @Autowired
    public LlamaRestController(LlamaAiService llamaAiService) {
        this.llamaAiService = llamaAiService;
    }


    @PostMapping("api/v1/ai/generate")
    public ResponseEntity<LlamaResponse> generate(@RequestBody Llamarequest request) {
        final LlamaResponse aiResponse = llamaAiService.generateMessage(request.getMessage());
        return ResponseEntity.status(HttpStatus.OK).body(aiResponse);
    }
}


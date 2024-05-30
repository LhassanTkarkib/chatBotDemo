package com.migrationdemo.chatbotai;


import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LlamaAiServiceImpl implements LlamaAiService {


    private final OllamaChatClient chatClient;

    public LlamaAiServiceImpl(OllamaChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @Override
    public LlamaResponse generateMessage(String promptMessage) {
        final String llamaMessage = chatClient.call(promptMessage);
        return new LlamaResponse().setMessage(llamaMessage);
    }

}
package com.migrationdemo.chatbotai;


import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.stereotype.Service;

@Service
public class LlamaAiServiceImpl implements LlamaAiService {
    private final OllamaChatClient chatClient;

    public String Param = "Translate the following text to a SQL select query with no explanation and no decoration like / or /n just the sql request:";

    public LlamaAiServiceImpl(OllamaChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @Override
    public LlamaResponse generateMessage(String promptMessage) {
        final String llamaMessage = chatClient.call(Param+promptMessage);
        return new LlamaResponse().setMessage(llamaMessage);
    }
}
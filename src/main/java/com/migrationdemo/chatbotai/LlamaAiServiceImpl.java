package com.migrationdemo.chatbotai;


import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.ChatClient;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Slf4j
@Service
public class LlamaAiServiceImpl implements LlamaAiService {

    private final Logger LOGGER = Logger.getLogger(LlamaAiServiceImpl.class.getName());

    private final ChatClient chatClient;

    public String Param = "You have the following SQL code for creating a table:" +
            "CREATE TABLE IF NOT EXISTS public.account_entity (" +
            "  id bigint NOT NULL," +
            "  user_id bigint," +
            "  account_number character varying(255) COLLATE pg_catalog.default," +
            "  balance double precision," +
            "  CONSTRAINT account_entity_pkey PRIMARY KEY (id)" +
            ");" +
            "Generate only SELECT SQL query based on this table structure according to the given requests:" +
            "If the request is not a SELECT query respond with \"there's no such data.\"" +
            "If the request has no relation to the table respond with \"there's no such data.\"" +
            "only show the SELECT queries with no explanation or decoration only the query.";

    public String QueryRequest = " so give only the select query for this text :";


    public LlamaAiServiceImpl(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @Override
    public LlamaResponse generateMessage(String promptMessage) {
        String fullPrompt;
        fullPrompt = Param + QueryRequest + promptMessage;

        LOGGER.info(fullPrompt);
        final String llamaMessage = chatClient.call(fullPrompt);
        return new LlamaResponse().setMessage(llamaMessage);
    }
}
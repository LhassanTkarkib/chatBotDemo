package com.migrationdemo.chatbotai;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Llamarequest {
    private String message;

}

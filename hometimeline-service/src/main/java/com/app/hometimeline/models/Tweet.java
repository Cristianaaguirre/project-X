package com.app.hometimeline.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tweet{
    private UUID userId;
    private String message;
    private LocalDateTime dateTime;
}
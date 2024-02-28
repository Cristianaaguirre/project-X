package com.app.hometimeline.models;

import java.time.LocalDateTime;
import java.util.UUID;

public record Tweet(
     UUID userId,
     String message,
     LocalDateTime dateTime
) {}
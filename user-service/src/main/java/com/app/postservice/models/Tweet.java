package com.app.postservice.models;

import java.time.LocalDateTime;
import java.util.UUID;

public record Tweet(
     UUID userId,
     String message,
     LocalDateTime dateTime
) {
   public Tweet(UUID uuid, String message) {
      this(uuid, message, LocalDateTime.now());
   }
}

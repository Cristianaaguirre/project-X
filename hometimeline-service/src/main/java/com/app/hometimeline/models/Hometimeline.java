package com.app.hometimeline.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Document
public class Hometimeline {

   @Id
   private UUID id;
   private List<UUID> following = new ArrayList<>();
   private List<Tweet> tweets = new ArrayList<>();

}

package com.app.usertimeline.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Data
@Document
public class UserTimeline {

   @Id
   private UUID id;
   private List<Tweet> userTimeline;

}

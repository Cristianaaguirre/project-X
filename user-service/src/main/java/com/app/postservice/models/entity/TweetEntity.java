package com.app.postservice.models.entity;

import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class TweetEntity {

   private Long id;
   private String username;
   private String message;
   private Date date;

}

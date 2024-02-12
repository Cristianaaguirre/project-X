package com.app.postservice.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder
@AllArgsConstructor
@Getter @Setter
public class FollowEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private Long userId;
   private Long followedUserId;

}

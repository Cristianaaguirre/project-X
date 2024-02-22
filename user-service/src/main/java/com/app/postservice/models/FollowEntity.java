package com.app.postservice.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "follow")
public class FollowEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private Long userId;
   private Long followedUserId;

}

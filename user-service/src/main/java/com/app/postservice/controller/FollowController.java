package com.app.postservice.controller;

import com.app.postservice.models.FollowRequest;
import com.app.postservice.services.IFollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/follow")
@RequiredArgsConstructor
public class FollowController {

   private final IFollowService followService;

   @PostMapping("/follow-user")
   public ResponseEntity<?> followingUser(@RequestBody FollowRequest followRequest) {
      followService.following(followRequest);
      return null;
   }

}

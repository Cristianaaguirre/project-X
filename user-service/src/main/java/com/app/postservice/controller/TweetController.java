package com.app.postservice.controller;

import com.app.postservice.models.Tweet;
import com.app.postservice.services.ITweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tweet")
@RequiredArgsConstructor
public class TweetController {

   private final ITweetService tweetService;

   @PostMapping("/post")
   public ResponseEntity<Void> postTweet(@RequestBody Tweet tweet) {
      tweetService.postingTweet(tweet);
      return ResponseEntity.status(201).build();
   }

}

package com.app.postservice.services.impl;

import com.app.postservice.models.FollowRepository;
import com.app.postservice.models.Tweet;
import com.app.postservice.services.ITweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TweetServiceImpl implements ITweetService {

   private final StreamBridge stream;
   private final FollowRepository followRepository;

   public void postingTweet(Tweet tweet) {
      tweet.setDateTime(LocalDateTime.now());
      stream.send("post-topic", tweet);
   }

}

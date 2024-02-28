package com.app.postservice.services.impl;

import com.app.postservice.models.Tweet;
import com.app.postservice.services.ITweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TweetServiceImpl implements ITweetService {

   private final StreamBridge stream;

   public void postingTweet(Tweet tweet) {
      stream.send("post-user-topic", tweet);
      stream.send("post-home-topic", tweet);
   }

}

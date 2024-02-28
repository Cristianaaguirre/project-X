package com.app.postservice.services.impl;

import com.app.postservice.models.Follow;
import com.app.postservice.services.IFollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowServiceImpl implements IFollowService {

   private final StreamBridge stream;

   @Override
   public void following(Follow followRequest) {
      stream.send("follow-topic", followRequest);
   }

}

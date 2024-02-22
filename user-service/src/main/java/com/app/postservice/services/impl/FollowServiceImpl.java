package com.app.postservice.services.impl;

import com.app.postservice.models.FollowEntity;
import com.app.postservice.models.FollowRepository;
import com.app.postservice.models.FollowRequest;
import com.app.postservice.services.IFollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowServiceImpl implements IFollowService {

   private final FollowRepository followRepository;
   private final StreamBridge stream;

   @Override
   public void following(FollowRequest followRequest) {
      var follow = new FollowEntity();
      BeanUtils.copyProperties(followRequest, follow);

      followRepository.save(follow);

      stream.send("follow-topic", followRequest);
   }

}

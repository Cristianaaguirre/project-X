package com.app.postservice.services;

import com.app.postservice.models.repository.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowServiceImpl implements IFollowService {

   private final FollowRepository followRepository;

   @Override
   public void following(String token, Long id) {

   }

}

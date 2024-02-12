package com.app.postservice.services.impl;

import com.app.postservice.config.JwtProvider;
import com.app.postservice.models.repository.FollowRepository;
import com.app.postservice.services.IFollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowServiceImpl implements IFollowService {

   private final FollowRepository followRepository;
   private final JwtProvider jwtProvider;

   @Override
   public void following(String token, Long id) {

   }

}

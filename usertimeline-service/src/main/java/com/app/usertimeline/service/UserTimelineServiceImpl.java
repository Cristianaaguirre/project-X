package com.app.usertimeline.service;

import com.app.usertimeline.models.UserTimeline;
import com.app.usertimeline.models.UserTimelineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserTimelineServiceImpl implements IUserTimelineService{

   private final UserTimelineRepository repository;

   public UserTimeline getTimeline(UUID uuid) {
      return repository.findById(uuid)
           .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found"));
   }

}

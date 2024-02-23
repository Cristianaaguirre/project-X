package com.app.usertimeline.service;

import com.app.usertimeline.models.Tweet;
import com.app.usertimeline.models.UserTimeline;
import com.app.usertimeline.models.UserTimelineRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class UserTimelineServiceImpl implements IUserTimelineService{

   private final UserTimelineRepository repository;
   private final Logger logger = LoggerFactory.getLogger(UserTimelineServiceImpl.class);

   public UserTimeline getTimeline(UUID uuid) {
      return repository.findById(uuid)
           .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found"));
   }

   @Bean
   public Consumer<Tweet> consumer() {
      return t -> {
         var user = getTimeline(t.getUserId());
         user.getUserTimeline().add(t);
         repository.save(user);
         logger.info(String.valueOf(user));
      };
   }

   @Bean
   public Consumer<UUID> register() {
      return r -> {
         var timeline = new UserTimeline();
         timeline.setId(r);
         repository.insert(timeline);
      };
   }

}

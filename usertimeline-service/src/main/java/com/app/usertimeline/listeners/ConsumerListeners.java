package com.app.usertimeline.listeners;

import com.app.usertimeline.models.Tweet;
import com.app.usertimeline.models.UserTimeline;
import com.app.usertimeline.models.UserTimelineRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;
import java.util.function.Consumer;

@RequiredArgsConstructor
public class ConsumerListeners {

   private final UserTimelineRepository repository;
   private final Logger logger = LoggerFactory.getLogger(ConsumerListeners.class);

   @Bean
   public Consumer<Tweet> postConsumer() {
      return t -> {
//         var user = repository.findById(t.getUserId())
//              .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found"));
//         user.getUserTimeline().add(t);
//         repository.save(user);
         logger.info(String.valueOf(t));
      };
   }

   @Bean
   public Consumer<UUID> registerConsumer() {
      return t -> {
         var usertimeline = new UserTimeline();
         usertimeline.setId(t);
         repository.save(usertimeline);
         logger.info(String.valueOf(t));
      };
   }


}

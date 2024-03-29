package com.app.hometimeline.service;

import com.app.hometimeline.models.Follow;
import com.app.hometimeline.models.Hometimeline;
import com.app.hometimeline.models.HometimelineRepository;
import com.app.hometimeline.models.Tweet;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class HometimelineServiceImpl implements IHometimelineService{

   private final HometimelineRepository repository;
   private final Logger logger = LoggerFactory.getLogger(HometimelineServiceImpl.class);

   public Hometimeline getHometimeline(UUID uuid) {
      return getById(uuid);
   }

   @Bean
   public Consumer<UUID> register() {
      return uuid -> {
         logger.info(uuid.toString());
         var hometimeline = new Hometimeline();
         hometimeline.setId(uuid);
         repository.insert(hometimeline);
      };
   }

   @Bean
   public Consumer<Follow> follow(){
      return f -> {
         var hometimeline = getById(f.getUserId());
         hometimeline.getFollowing().add(f.getFollowUserId());
         repository.save(hometimeline);
      };
   }

   @Bean
   public Consumer<Tweet> post() {
      return t -> {
         var hometimelines = repository.getHometimelinesByUuid(t.getUserId());
         hometimelines
              .forEach(h -> {
                 h.getTweets().add(t);
                 repository.save(h);
              });
      };
   }

   private Hometimeline getById(UUID uuid) {
      return repository
           .findById(uuid)
           .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
   }

}

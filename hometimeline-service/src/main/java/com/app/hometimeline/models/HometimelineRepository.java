package com.app.hometimeline.models;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HometimelineRepository extends MongoRepository<Hometimeline, UUID> {

   @Query("{'following': {'$in': [?0]}}")
   List<Hometimeline> getHometimelinesByUuid(UUID uuid);

}

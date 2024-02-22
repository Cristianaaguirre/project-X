package com.app.usertimeline.models;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserTimelineRepository extends MongoRepository<UserTimeline, UUID> {
}

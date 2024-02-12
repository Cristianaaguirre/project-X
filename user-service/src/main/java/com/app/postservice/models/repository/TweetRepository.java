package com.app.postservice.models.repository;

import com.app.postservice.models.entity.TweetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends JpaRepository<TweetEntity, Long> {
}

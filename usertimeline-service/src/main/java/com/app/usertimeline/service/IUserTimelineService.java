package com.app.usertimeline.service;

import com.app.usertimeline.models.UserTimeline;

import java.util.UUID;

public interface IUserTimelineService {
   UserTimeline getTimeline(UUID uuid);
}

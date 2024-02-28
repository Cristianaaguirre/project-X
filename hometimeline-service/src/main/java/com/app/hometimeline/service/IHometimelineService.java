package com.app.hometimeline.service;

import com.app.hometimeline.models.Hometimeline;

import java.util.UUID;

public interface IHometimelineService {
   Hometimeline getHometimeline(UUID uuid);
}

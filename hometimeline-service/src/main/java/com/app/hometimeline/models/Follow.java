package com.app.hometimeline.models;

import java.util.UUID;

public record Follow(
     UUID userId,
     UUID followUserId
) {}

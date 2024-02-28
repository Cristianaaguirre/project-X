package com.app.postservice.models;

import java.util.UUID;

public record Follow(
     UUID userId,
     UUID followUserId
) {}

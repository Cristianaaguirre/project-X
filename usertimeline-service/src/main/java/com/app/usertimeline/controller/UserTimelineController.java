package com.app.usertimeline.controller;

import com.app.usertimeline.service.IUserTimelineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/usertimeline")
@RequiredArgsConstructor
public class UserTimelineController {

   private final IUserTimelineService service;

   @GetMapping("/{id}")
   public ResponseEntity<?> getUserTimeline(@PathVariable UUID id) {
      return ResponseEntity.ok(service.getTimeline(id));
   }


}

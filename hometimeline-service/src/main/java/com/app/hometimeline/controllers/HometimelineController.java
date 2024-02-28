package com.app.hometimeline.controllers;

import com.app.hometimeline.service.IHometimelineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/hometimeline")
@RequiredArgsConstructor
public class HometimelineController {

   private final IHometimelineService service;

   @GetMapping("{id}")
   public ResponseEntity<?> getHometimeline(@PathVariable String id) {
      return ResponseEntity.ok(service.getHometimeline(UUID.fromString(id)));
   }
}

package com.app.userservice.service;

import com.app.userservice.jwt.Jwt;
import com.app.userservice.controller.dto.AuthRequest;
import com.app.userservice.controller.dto.RegisterDTO;
import com.app.userservice.models.UserMapper;
import com.app.userservice.models.UserRepository;
import com.app.userservice.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

   private final UserRepository repository;
   private final PasswordEncoder encoder;
   private final JwtProvider provider;

   @Override
   public void registerUser(RegisterDTO register) {

      if (repository.existsByEmail(register.getEmail()))
         throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The email is already registered");

      var user = UserMapper.dtoToEntity(register);
      var password = encoder.encode(register.getPassword());
      user.setPassword(password);

      repository.save(user);
   }

   public Jwt loginUser(AuthRequest authRequest) {
      var user = Optional
           .of(repository.findByEmail(authRequest.getEmail()))
           .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Incorrect password or email"));

      if (encoder.matches(authRequest.getPassword(), user.getPassword()))
         return provider.generateToken(user);
      else
         throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Incorrect password or email");
   }

   public Jwt validate(String token) {
      provider.validate(token);

      var email = provider.extractEmail(token);
      var user = repository.findByEmail(email);

      return provider.generateToken(user);
   }


}

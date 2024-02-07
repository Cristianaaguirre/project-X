package com.app.userservice.common.security.service;

import com.app.userservice.models.entity.UserEntity;
import com.app.userservice.models.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class LoadUserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var entity = Optional
                .of(userRepository.findUserByEmail(username))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "User not found"));

        var authority = List.of(new SimpleGrantedAuthority(entity.getRole().name()));

        return new User(entity.getUsername(), entity.getPassword(), authority);
    }


}

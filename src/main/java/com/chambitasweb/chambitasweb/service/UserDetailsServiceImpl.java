package com.chambitasweb.chambitasweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chambitasweb.chambitasweb.models.User;
import com.chambitasweb.chambitasweb.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  UserRepository userRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
    User user = userRepository.findByNombre(nombre)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + nombre));

    return UserDetailsImplService.build(user);
  }

}
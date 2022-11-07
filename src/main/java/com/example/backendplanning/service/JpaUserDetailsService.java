package com.example.backendplanning.service;

import com.example.backendplanning.model.SecurityUser;
import com.example.backendplanning.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public JpaUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       return userRepository
               .findByUsername(username)
               .map(SecurityUser::new)
               .orElseThrow(() -> new UsernameNotFoundException("Username not found: " + username));
    }
}

package com.expManageSys.ems.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Replace with your actual logic to fetch user from database
        if ("testuser".equals(username)) {
            return User.builder()
                    .username(username)
                    .password(new BCryptPasswordEncoder().encode("password"))
                    .roles("USER")
                    .build();
        }
        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}

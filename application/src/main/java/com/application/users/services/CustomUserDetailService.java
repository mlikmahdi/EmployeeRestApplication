package com.application.users.services;

import com.application.users.CustomUserDetails;
import com.application.users.entity.User;
import com.application.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public CustomUserDetailService() {

    }

    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("L'utilisateur n'a pas été trouvé.");
        }

        return new CustomUserDetails(user);
    }
}

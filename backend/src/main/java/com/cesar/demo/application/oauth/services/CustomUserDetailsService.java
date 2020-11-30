package com.cesar.demo.application.oauth.services;

import com.cesar.demo.application.user.entity.User;
import com.cesar.demo.application.oauth.UserPrincipal;
import com.cesar.demo.application.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        logger.debug("LOAD USER BY USERNAME");
        User user = userRepository.findByEmail(email);
        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        logger.debug("LOAD USER BY ID");
        Optional<User> user = userRepository.findById(id);
        return UserPrincipal.create(user.get());
    }
}

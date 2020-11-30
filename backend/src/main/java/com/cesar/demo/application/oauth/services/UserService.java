package com.cesar.demo.application.oauth.services;

import com.cesar.demo.application.user.entity.User;
import com.cesar.demo.application.oauth.GoogleInfo;
import com.cesar.demo.application.oauth.UserInfo;
import com.cesar.demo.application.oauth.UserPrincipal;
import com.cesar.demo.application.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class UserService extends DefaultOAuth2UserService {
    @Autowired
    UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        logger.debug("LOAD USER ACCESSED");
        OAuth2User oAuth2User = super.loadUser(userRequest);
        User user = null;
        try{
            UserInfo info = new GoogleInfo(oAuth2User.getAttributes());
            if(info.getEmail().isEmpty()) {
                throw new Exception("Email not found from OAuth2 provider");
            }
            user = userRepository.findByEmail(info.getEmail());
            if(user.getId() == 0){
                saveUser(info);
            }
        }catch (Exception ex){

        }

        return UserPrincipal.create(user, oAuth2User.getAttributes());
    }

    private User saveUser(UserInfo info){
        User user = new User();
        user.setName(info.getName());
        user.setEmail(info.getEmail());

        userRepository.save(user);

        return user;
    }
}

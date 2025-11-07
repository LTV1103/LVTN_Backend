package com.learning.lvtn_backend.auth;

import com.learning.lvtn_backend.auth.JWT.jwtUtil;
import com.learning.lvtn_backend.entity.User;
import com.learning.lvtn_backend.reponsitory.UsersReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private UsersReponsitory usersReponsitory;

    @Autowired
    private jwtUtil jwtUtil;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        String googleId = oAuth2User.getAttribute("sub");
        String email = oAuth2User.getAttribute("email");
        String fullName = oAuth2User.getAttribute("name");
        Optional<User> findUserByEmail = usersReponsitory.findByEmail(email);
        if (findUserByEmail.isEmpty()) {
            User user = new User();
            user.setEmail(email);
            user.setFullname(fullName);
            user.setCreatedAt(LocalDateTime.now());
            user.setRole("user");
            user.setProvider("google");
            user.setGoogleId(googleId);
        } else {
            User user = findUserByEmail.get();
            String accessToken = jwtUtil.generateToken(user.getUsername());
            String refreshToken = jwtUtil.generateRefreshToken(user.getUsername());
            user.setRefreshToken(refreshToken);
            usersReponsitory.save(user);
            System.out.println(accessToken);
            System.out.println(refreshToken);
        }return oAuth2User;
    }
}


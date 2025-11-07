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


    public CustomOAuth2UserService(UsersReponsitory usersReponsitory) {
        this.usersReponsitory = usersReponsitory;
    }
    public OAuth2User loadUser(OAuth2UserRequest userRequest) {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        String id_gg  = oAuth2User.getAttribute("sub");
        String email = oAuth2User.getAttribute("email");
        String name = oAuth2User.getAttribute("name");
        Optional<User> existingUser = usersReponsitory.findByEmail(email);
        if(existingUser.isEmpty()) {
            User user = new User();
            user.setEmail(email);
            user.setFullname(name);
            user.setCreatedAt(LocalDateTime.now());
            user.setRole("USER");
            user.setProvider("google");
            String refeshToken = jwtUtil.generateRefreshToken(user.getUsername());
            user.setRefreshToken(refeshToken);
            user.setGoogleId(id_gg);
            usersReponsitory.save(user);
        }
        return oAuth2User;
    }

}

package com.learning.lvtn_backend.auth;

import com.learning.lvtn_backend.auth.JWT.jwtUtil;
import com.learning.lvtn_backend.entity.User;
import com.learning.lvtn_backend.reponsitory.UsersReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthService {
    @Autowired
    private UsersReponsitory usersReponsitory;
    @Autowired
    private jwtUtil jwtUtil;


    public Map<String, Object> login(String username, String password) {
        User user = usersReponsitory.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Người dùng không tồn tại"));
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Sai mật khẩu");
        }
        String accessToken = jwtUtil.generateToken(user.getUsername());
        String refreshToken = jwtUtil.generateRefreshToken(user.getUsername());
        user.setRefreshToken(refreshToken);
        usersReponsitory.save(user);
        return Map.of(

                "accessToken", accessToken,
                "user" , user.getUsername(),
                "role" , user.getRole(),
                "refreshToken", refreshToken
        );
    }

    public void logout(String token) {
        String username = jwtUtil.getUsernameFromToken(token);
        User user = usersReponsitory.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng"));
        user.setRefreshToken(null);
        usersReponsitory.save(user);
    }






}


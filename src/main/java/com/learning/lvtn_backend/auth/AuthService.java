package com.learning.lvtn_backend.auth;

import com.learning.lvtn_backend.auth.JWT.jwtUtil;
import com.learning.lvtn_backend.entity.User;
import com.learning.lvtn_backend.reponsitory.UsersReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

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
                "id", user.getUserId(),
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
    public Map<String, Object> loginWithGoogle(String credential) {

        RestTemplate restTemplate = new RestTemplate();

        // VERIFY ID TOKEN
        String url = "https://oauth2.googleapis.com/tokeninfo?id_token=" + credential;
        Map<String, Object> googleUser = restTemplate.getForObject(url, Map.class);
        // user info
        String email = (String) googleUser.get("email");
        String fullName = (String) googleUser.get("name");
        // Check user tồn tại
        Optional<User> existing = usersReponsitory.findByEmail(email);
        User user;

        if (existing.isEmpty()) {
            user = new User();
            user.setEmail(email);
            user.setFullname(fullName);
            user.setProvider("google");
            user.setCreatedAt(LocalDateTime.now());
            user.setRole("user");

            // Đặt username = email
            user.setUsername(email);

            // Vì Google login → không cần password
            user.setPassword("GOOGLE_USER");

            // Generate refresh token
            String refreshToken = jwtUtil.generateRefreshToken(email);
            user.setRefreshToken(refreshToken);

            usersReponsitory.save(user);
        } else {
            user = existing.get();
            String refreshToken = jwtUtil.generateRefreshToken(email);
            user.setRefreshToken(refreshToken);
            usersReponsitory.save(user);
        }

        // Access token
        String accessToken = jwtUtil.generateToken(email);
        return Map.of(
                "message", "login_success",
                "accessToken", accessToken,
                "user", user
        );
    }
}









package com.learning.be_english_course.Auth;

import com.learning.be_english_course.Auth.JWT.jwtUtil;
import com.learning.be_english_course.Entity.User;
import com.learning.be_english_course.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private jwtUtil jwtUtil;

    // LOGIN
    public Map<String, Object> login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Người dùng không tồn tại"));
        System.out.println(user);
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Sai mật khẩu");

        }

        String accessToken = jwtUtil.generateToken(email);          // dùng email
        String refreshToken = jwtUtil.generateRefreshToken(email);  // dùng email

        user.setRefreshToken(refreshToken);
        userRepository.save(user);

        return Map.of(
                "refreshToken", refreshToken,
                "accessToken", accessToken,
                "id", user.getUserId(),
                "email", user.getEmail(),
                "role", user.getRole()
        );
    }

    // LOGOUT
    public void logout(String token) {
        jwtUtil.validateToken(token);
        String email = jwtUtil.getEmailFromToken(token); // token vẫn decode ra email
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng"));
        user.setRefreshToken(null);
        userRepository.save(user);
    }



    // LOGIN WITH GOOGLE
    public Map<String, Object> loginWithGoogle(String credential) {
        RestTemplate restTemplate = new RestTemplate();

        // VERIFY ID TOKEN
        String url = "https://oauth2.googleapis.com/tokeninfo?id_token=" + credential;
        Map<String, Object> googleUser = restTemplate.getForObject(url, Map.class);

        String email = (String) googleUser.get("email");
        String fullName = (String) googleUser.get("name");

        User user = userRepository.findByEmail(email).orElse(null);
        if (user == null) {
            user = new User();
            user.setEmail(email);
            user.setFullName(fullName);
            user.setProvider("google");
            user.setBirthday(" ");
            user.setCreatedAt(LocalDateTime.now());
            user.setRole("user");
            user.setPassword("GOOGLE_USER");
        }
        String refreshToken = jwtUtil.generateRefreshToken(email);
        user.setRefreshToken(refreshToken);
        if (user.getRole() == null) {
            user.setRole("user");
        }

        userRepository.save(user);

        String accessToken = jwtUtil.generateToken(email);

        return Map.of(
                "message", "login_success",
                "accessToken", accessToken,
                "user", user
        );
    }

}

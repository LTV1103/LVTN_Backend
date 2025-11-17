package com.learning.lvtn_backend.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173") // optional nếu đã global
public class AuthController {

    @PostMapping("/google")
    public ResponseEntity<?> googleLogin(@RequestBody Map<String, String> body) {
        String accessToken = body.get("access_token");

        // Gọi Google API lấy thông tin user
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=" + accessToken;

        Map<String, Object> googleUser = restTemplate.getForObject(url, Map.class);

        return ResponseEntity.ok(Map.of(
                "user", googleUser
        ));
    }
}

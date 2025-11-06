package com.learning.lvtn_backend.Auth;

import com.learning.lvtn_backend.Auth.JWT.jwtUtil;
import com.learning.lvtn_backend.entity.Users;
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


    public Map<String , Object> login(String username , String password){
        Users users = usersReponsitory.findByUsername(username).orElseThrow(() -> new RuntimeException("Người dùng không tồn tại"));
        System.out.print(password);
        System.out.println(users.getClass().getName());

        if(!users.getPassword().equals(password)){
            throw new RuntimeException("Sai mật khẩu");
        }
        String token = jwtUtil.generateToken(users.getUsername());
        return Map.of("users" , users ,"token", token);

    }



}


package com.learning.lvtn_backend.service;

import com.learning.lvtn_backend.dto.reponse.dtoReponseUser.dtoUpdateUsers;
import com.learning.lvtn_backend.dto.request.dtoUsers.dtoCreateUsers;
import com.learning.lvtn_backend.entity.Users;
import com.learning.lvtn_backend.reponsitory.UsersReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsersService {
    @Autowired
    private UsersReponsitory usersReponsitory;

    public List<Users> getAllUser() {
       return usersReponsitory.findAll();
    }
    public Users getUserById(int id) {
        return usersReponsitory.findById(id).orElseThrow(() -> new RuntimeException("User Not Found With ID = "+ id));
    }
    public Users createUsers(dtoCreateUsers request) {
        Users user = new Users();
        user.setName(request.getName());
        if(usersReponsitory.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username Already Exists");
        }
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setProvider(request.getProvider());
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());
        user.setGoogleId(request.getGoogleId());
        user.setRefreshToken(request.getRefreshToken());
        user.setCreatedAt(request.getCreatedAt());

        return usersReponsitory.save(user);

    }
    public Users updateUser(int id,dtoUpdateUsers request) {
        Users users  = getUserById(id);
        users.setName(request.getName());
        users.setPassword(request.getPassword());
        users.setEmail(request.getEmail());
        return usersReponsitory.save(users);
    }
    public void deleteUser(int id) {
        usersReponsitory.deleteById(id);
    }



}

package com.learning.lvtn_backend.service;

import com.learning.lvtn_backend.dto.request.dtoUsers.dtoUpdateUsers;
import com.learning.lvtn_backend.dto.request.dtoUsers.dtoCreateUsers;
import com.learning.lvtn_backend.dto.response.dtoGetUser;
import com.learning.lvtn_backend.entity.Users;
import com.learning.lvtn_backend.mapper.MapperEntity;
import com.learning.lvtn_backend.reponsitory.UsersReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class UsersService {
    @Autowired
    private UsersReponsitory usersReponsitory;
    @Autowired
    private MapperEntity userMapping;

    public List<dtoGetUser> getAllUser() {
        List<Users> usersList = usersReponsitory.findAll();
        return userMapping.dtoToGetUserList(usersList);
    }
    public dtoGetUser getUserById(int id) {
        Users findUsersbyID = usersReponsitory.findById(id).orElseThrow(() -> new RuntimeException("User Not Found With ID = "+ id));
        return userMapping.dtoToGetUser(findUsersbyID);
    }
    public Users createUsers(dtoCreateUsers request) {
        if (usersReponsitory.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        Users user = userMapping.userToUser(request);
        user.setRole("User");
        user.setProvider("Local");
        user.setCreatedAt(LocalDateTime.now());
        return usersReponsitory.save(user);

    }
    public dtoGetUser updateUser(int id, dtoUpdateUsers request) {
        Users userEntity = usersReponsitory.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found With ID = " + id));
        userMapping.userUpdate(request, userEntity);
        Users updatedUser = usersReponsitory.save(userEntity);
        return userMapping.dtoToGetUser(updatedUser);
    }


    public void deleteUser(int id) {
        usersReponsitory.deleteById(id);
    }
}

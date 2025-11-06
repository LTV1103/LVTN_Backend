package com.learning.lvtn_backend.service;

import com.learning.lvtn_backend.Auth.JWT.jwtUtil;
import com.learning.lvtn_backend.dto.request.dtoUsers.dtoUpdateUsers;
import com.learning.lvtn_backend.dto.request.dtoUsers.dtoCreateUsers;
import com.learning.lvtn_backend.dto.response.dtoGetUser;
import com.learning.lvtn_backend.entity.Users;
import com.learning.lvtn_backend.mapper.MapperEntity;
import com.learning.lvtn_backend.reponsitory.UsersReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class UsersService {
    @Autowired
    private UsersReponsitory usersReponsitory;
    @Autowired
    private MapperEntity userMapping;
    @Autowired
    private jwtUtil jwtUtil;

    public List<dtoGetUser> getAllUser() {
        List<Users> usersList = usersReponsitory.findAll();
        return userMapping.dtoToGetUserList(usersList);
    }
    public dtoGetUser getUserById(int id) {
        Users findUsersbyID = usersReponsitory.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng với ID = "+ id));
        return userMapping.dtoToGetUser(findUsersbyID);
    }
    public Users createUsers(dtoCreateUsers request) {
        if (usersReponsitory.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username đã tồn tại");
        }
        Users user = userMapping.userToUser(request);
        user.setRole("User");
        user.setProvider("Local");
        String refeshToken = jwtUtil.generateRefreshToken(user.getUsername());
        user.setRefreshToken(refeshToken);
        user.setCreatedAt(LocalDateTime.now());
        return usersReponsitory.save(user);

    }
    public dtoGetUser updateUser(int id, dtoUpdateUsers request) {
        Users userEntity = usersReponsitory.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng với ID = " + id));
        userMapping.userUpdate(userEntity ,request);
        Users updatedUser = usersReponsitory.save(userEntity);
        return userMapping.dtoToGetUser(updatedUser);
    }


    public void deleteUser(int id) {
        if (!usersReponsitory.existsById(id)) {
            throw new RuntimeException("Không tìm thấy người dùng với ID = " + id);
        }
        usersReponsitory.deleteById(id);
    }
}

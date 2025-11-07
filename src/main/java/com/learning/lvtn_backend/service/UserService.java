package com.learning.lvtn_backend.service;

import com.learning.lvtn_backend.auth.JWT.jwtUtil;
import com.learning.lvtn_backend.dto.request.dtoUser.dtoUpdateUsers;
import com.learning.lvtn_backend.dto.request.dtoUser.dtoCreateUsers;
import com.learning.lvtn_backend.dto.response.dtoUser.dtoGetUser;
import com.learning.lvtn_backend.entity.User;
import com.learning.lvtn_backend.mapper.MapperEntity;
import com.learning.lvtn_backend.reponsitory.UsersReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class UserService {
    @Autowired
    private UsersReponsitory usersReponsitory;
    @Autowired
    private MapperEntity userMapping;
    @Autowired
    private jwtUtil jwtUtil;

    public List<dtoGetUser> getAllUser() {
        List<User> userList = usersReponsitory.findAll();
        return userMapping.listUserTolistDtoUser(userList);
    }
    public dtoGetUser getUserById(int id) {
        User findUsersbyID = usersReponsitory.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng với ID = "+ id));
        return userMapping.userToDtoUser(findUsersbyID);
    }
    public User createUsers(dtoCreateUsers request) {
        if (usersReponsitory.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username đã tồn tại");
        }
        User user = userMapping.dtoCreateUserToUser(request);
        user.setRole("User");
        user.setProvider("Local");
        String refeshToken = jwtUtil.generateRefreshToken(user.getUsername());
        user.setRefreshToken(refeshToken);
        user.setCreatedAt(LocalDateTime.now());
        return usersReponsitory.save(user);

    }
    public dtoGetUser updateUser(int id, dtoUpdateUsers request) {
        User userEntity = usersReponsitory.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng với ID = " + id));
        userMapping.userUpdate(userEntity ,request);
        User updatedUser = usersReponsitory.save(userEntity);
        return userMapping.userToDtoUser(updatedUser);
    }


    public void deleteUser(int id) {
        if (!usersReponsitory.existsById(id)) {
            throw new RuntimeException("Không tìm thấy người dùng với ID = " + id);
        }
        usersReponsitory.deleteById(id);
    }
}

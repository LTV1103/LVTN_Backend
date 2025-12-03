package com.learning.be_english_course.Service;

import com.learning.be_english_course.DTO.request.user.dtoCreateUser;
import com.learning.be_english_course.DTO.request.user.dtoUpdateUser;
import com.learning.be_english_course.DTO.respone.user.dtoOneUser;
import com.learning.be_english_course.Entity.User;
import com.learning.be_english_course.Mapper.EntityMapping;
import com.learning.be_english_course.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EntityMapping entityMapping;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public dtoOneUser findByIdUser(long userid) {
         User user = userRepository.findById(userid)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng với ID = " + userid));
         return entityMapping.DTOgetOneUser(user);
    }

    public User createUser(dtoCreateUser request) {
        if(userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email đã tồn tại");
        }
        User user = entityMapping.DTOtoCreateUser(request);
        user.setEmail(request.getEmail());
        user.setFullName(request.getFullName());
        user.setPassword(request.getPassword());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setRole("user");
        user.setProvider("local");
        user.setCreatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }
    public User updateUser(long id, dtoUpdateUser request) {
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("Không tìm thấy người dùng với ID = " + id));
        entityMapping.DTOtoUpdateUser(user,request);
        return userRepository.save(user);
    }
    public void deleteUser(long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy người dùng với ID = " + id);
        }
        userRepository.deleteById(id);
    }
}

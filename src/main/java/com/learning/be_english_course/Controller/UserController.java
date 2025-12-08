package com.learning.be_english_course.Controller;

import com.learning.be_english_course.Auth.AuthService;
import com.learning.be_english_course.DTO.request.user.dtoCreateUser;
import com.learning.be_english_course.DTO.request.user.dtoUpdateUser;
import com.learning.be_english_course.DTO.respone.user.dtoGetUser;
import com.learning.be_english_course.DTO.respone.user.dtoOneUser;
import com.learning.be_english_course.Entity.User;
import com.learning.be_english_course.Exception.apiRespone.ApiResponse;
import com.learning.be_english_course.Exception.apiRespone.BaseController;
import com.learning.be_english_course.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")

public class UserController extends BaseController {
    @Autowired
    private UserService userservice;
    @Autowired
    private AuthService authService;
    //    @GetMapping
    //    public List<User> getAllUser() {
    //        return userservice.findAll();}
    @GetMapping
    public ResponseEntity<ApiResponse<List<dtoGetUser>>> getAllUsers() {
        List<dtoGetUser> users = userservice.findAll();
        return success("Lấy danh sách người dùng thành công!", users);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<dtoOneUser>> getUserByID(@PathVariable long id) {
        dtoOneUser user = userservice.findByIdUser(id);
        return success("Lấy thông tin người dùng thành công!", user);
    }
    @PostMapping()
    public ResponseEntity<ApiResponse<User>> crateUser(@RequestBody @Valid dtoCreateUser request) {
        User created = userservice.createUser(request);
        return created("Tạo người dùng mới thành công!", created);
    }
    @PostMapping("/auth/login")
    public ResponseEntity<ApiResponse<Map<String, Object>>> login(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");


        try {
            Map<String, Object> user = authService.login(email, password);
            return success("Đăng nhập thành công", user);
        } catch (RuntimeException e) {
            return error(HttpStatus.UNAUTHORIZED, e.getMessage(),null);
        }
    }
    @PostMapping("/auth/logout")
    public ResponseEntity<ApiResponse<String>> logout(@RequestHeader("Authorization") String authHeader) {
        try {
            String token = authHeader.replace("Bearer ", "");
            authService.logout(token);
            return success("Đăng xuất thành công", null);
        } catch (RuntimeException e) {
            return error(HttpStatus.BAD_REQUEST, e.getMessage(), null);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> updateUser(@PathVariable long id, @RequestBody @Valid dtoUpdateUser request) {
        User update = userservice.updateUser(id, request);
        return success("Cập nhật người dùng thành công!" , update);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable long id) {
        userservice.deleteUser(id);
        return success("Xóa người dùng thành công!", "Deleted user with ID = " + id);
    }
}

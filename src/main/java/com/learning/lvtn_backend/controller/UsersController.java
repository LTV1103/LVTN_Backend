package com.learning.lvtn_backend.controller;

import com.learning.lvtn_backend.Auth.AuthService;
import com.learning.lvtn_backend.exception.base.BaseController;
import com.learning.lvtn_backend.dto.request.dtoUsers.dtoUpdateUsers;
import com.learning.lvtn_backend.dto.request.dtoUsers.dtoCreateUsers;
import com.learning.lvtn_backend.dto.response.dtoGetUser;
import com.learning.lvtn_backend.entity.Users;
import com.learning.lvtn_backend.exception.base.ApiResponse;
import com.learning.lvtn_backend.service.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UsersController extends BaseController {

    @Autowired
    private UsersService usersService;
    @Autowired
    private AuthService authService;


    //GET
    @GetMapping
    public ResponseEntity<ApiResponse<List<dtoGetUser>>> getUsers() {
        List<dtoGetUser> users = usersService.getAllUser();
        System.out.println(users);
        return success("Lấy danh sách người dùng thành công!", users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<dtoGetUser>> getUserById(@PathVariable int id) {
        dtoGetUser user = usersService.getUserById(id);
        return success("Lấy thông tin người dùng thành công!", user);
    }


    //POST
    @PostMapping
    public ResponseEntity<ApiResponse<Users>> createUser(@RequestBody @Valid dtoCreateUsers request) {
        Users created = usersService.createUsers(request);
        return created("Tạo người dùng mới thành công!", created);
    }
    @PostMapping("/auth/login")
    public ResponseEntity<ApiResponse<Map<String, Object>>> login(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");

        try {
            Map<String, Object> user = authService.login(username, password);
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


    //PUT
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<dtoGetUser>> updateUser(@PathVariable int id, @RequestBody dtoUpdateUsers request) {
        dtoGetUser updatedUser = usersService.updateUser(id, request);
        return success("Cập nhật người dùng thành công!", updatedUser);
    }


    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable int id) {
        usersService.deleteUser(id);
        return success("Xóa người dùng thành công!", "Deleted user with ID = " + id);
    }
}

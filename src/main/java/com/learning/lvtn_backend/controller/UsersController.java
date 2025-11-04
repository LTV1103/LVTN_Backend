package com.learning.lvtn_backend.controller;

import com.learning.lvtn_backend.controller.base.BaseController;
import com.learning.lvtn_backend.dto.request.dtoUsers.dtoUpdateUsers;
import com.learning.lvtn_backend.dto.request.dtoUsers.dtoCreateUsers;
import com.learning.lvtn_backend.dto.response.dtoGetUser;
import com.learning.lvtn_backend.entity.Users;
import com.learning.lvtn_backend.controller.base.ApiResponse;
import com.learning.lvtn_backend.service.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UsersController extends BaseController {

    @Autowired
    private UsersService usersService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<dtoGetUser>>> getUsers() {
        List<dtoGetUser> users = usersService.getAllUser();
        return success("Lấy danh sách người dùng thành công!", users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<dtoGetUser>> getUserById(@PathVariable int id) {
        dtoGetUser user = usersService.getUserById(id);
        return success("Lấy thông tin người dùng thành công!", user);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Users>> createUser(@RequestBody @Valid dtoCreateUsers request) {
        Users created = usersService.createUsers(request);
        return created("Tạo người dùng mới thành công!", created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<dtoGetUser>> updateUser(@PathVariable int id, @RequestBody dtoUpdateUsers request) {
        dtoGetUser updatedUser = usersService.updateUser(id, request);
        return success("Cập nhật người dùng thành công!", updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable int id) {
        usersService.deleteUser(id);
        return success("Xóa người dùng thành công!", "Deleted user with ID = " + id);
    }
}

package com.learning.lvtn_backend.controller;

import com.learning.lvtn_backend.dto.request.dtoUsers.dtoUpdateUsers;
import com.learning.lvtn_backend.dto.request.dtoUsers.dtoCreateUsers;
import com.learning.lvtn_backend.dto.response.dtoUsers.dtoGetUser;
import com.learning.lvtn_backend.entity.Users;
import com.learning.lvtn_backend.service.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;


    @GetMapping
    List<dtoGetUser> getUsers() {
        return usersService.getAllUser();
    }

    @GetMapping("/{id}")
    public dtoGetUser getUserById(@PathVariable int id) {
        return usersService.getUserById(id);
    }

    @PostMapping
    public Users createUser(@RequestBody @Valid dtoCreateUsers request) {
        return usersService.createUsers(request);
    }

    @PutMapping("/{id}")
    public dtoGetUser updateUser(@PathVariable int id, @RequestBody dtoUpdateUsers request) {
        return usersService.updateUser(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        usersService.deleteUser(id);
        return "Deleted user with ID = " + id;
    }
}

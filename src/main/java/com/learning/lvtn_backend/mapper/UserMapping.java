package com.learning.lvtn_backend.mapper;

import com.learning.lvtn_backend.dto.request.dtoUsers.dtoCreateUsers;
import com.learning.lvtn_backend.dto.request.dtoUsers.dtoUpdateUsers;
import com.learning.lvtn_backend.dto.response.dtoUsers.dtoGetUser;
import com.learning.lvtn_backend.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapping {
    Users userToUser(dtoCreateUsers request);
    dtoGetUser dtoToGetUser(Users users);
    List<dtoGetUser> dtoToGetUserList(List<Users> users);
    void  userUpdate(@MappingTarget dtoUpdateUsers request , Users user);

}

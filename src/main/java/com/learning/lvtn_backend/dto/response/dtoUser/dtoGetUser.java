package com.learning.lvtn_backend.dto.response.dtoUser;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoGetUser {
    String fullname;
    String username;
    String password;
    String email;
    String provider;
    String createdAt;
}

package com.learning.lvtn_backend.dto.request.dtoUser;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoCreateUsers {
     String fullname;
    @Size(min = 6, message =  "password must be least 8 characters!")
     String password;
     String username;
     String role;
     String provider;
     String createdAt;
}


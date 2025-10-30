package com.learning.lvtn_backend.dto.request.dtoUsers;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoUpdateUsers {
     String fullname;
     String email;
     String password;
}

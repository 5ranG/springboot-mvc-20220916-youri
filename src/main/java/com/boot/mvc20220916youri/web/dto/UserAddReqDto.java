package com.boot.mvc20220916youri.web.dto;

import com.boot.mvc20220916youri.domain.User;
import lombok.Data;

@Data
public class UserAddReqDto {
    private String userId;
    private String userPassword;
    private String userName;
    private String userEmail;

    public User toEntity(){
        return User.builder()
                .user_id(userId)
                .user_password(userPassword)
                .user_name(userName)
                .user_email(userEmail)
                .build();
    }
}

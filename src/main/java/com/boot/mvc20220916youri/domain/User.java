package com.boot.mvc20220916youri.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
    private int user_code;
    private String user_id;
    private String user_password;
    private String user_name;
    private String user_email;
}

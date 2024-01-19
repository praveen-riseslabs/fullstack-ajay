package com.springjwt.dto;

import lombok.Data;

@Data
public class ResponseTokenDTO {
    private String name;
    private String username;
    private String email;
    private String phone;
    private String gender;
}

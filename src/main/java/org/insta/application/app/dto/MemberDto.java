package org.insta.application.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MemberDto {

    private Integer id;             //java =>  camelCase, sql => snakeCase
    private String name;
    private String age;
    private String address;   // ADDR
    private String phoneNumber; // PHONE_NUMBER
}

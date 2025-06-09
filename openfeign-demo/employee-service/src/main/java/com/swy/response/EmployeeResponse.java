package com.swy.response;


import lombok.Data;

/**
 * @author: SMY
 * @time: 2025/6/9  23:56
 * @description:
 */

@Data
public class EmployeeResponse {

    private int id;

    private String name;

    private String email;

    private String age;

    private AddressResponse address;

}

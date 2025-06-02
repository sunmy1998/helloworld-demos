package com.swy;


import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author: SMY
 * @time: 2025/6/2  23:21
 * @description: Customer实体类
 */

@Data
public class Customer {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    public Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}

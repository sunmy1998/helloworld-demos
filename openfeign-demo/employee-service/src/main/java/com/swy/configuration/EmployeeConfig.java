package com.swy.configuration;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: SMY
 * @time: 2025/6/10  00:05
 * @description:
 */

@Configuration
public class EmployeeConfig {

    @Bean
    public ModelMapper ModelMapperBean(){
        return new ModelMapper();
    }

}

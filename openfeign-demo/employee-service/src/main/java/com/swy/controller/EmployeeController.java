package com.swy.controller;


import com.swy.response.EmployeeResponse;
import com.swy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: SMY
 * @time: 2025/6/10  00:09
 * @description:
 */

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee/{id}")
    private ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable("id") int id)
    {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

}

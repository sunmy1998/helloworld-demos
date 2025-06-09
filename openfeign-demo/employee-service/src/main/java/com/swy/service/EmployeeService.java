package com.swy.service;


import com.swy.entity.Employee;
import com.swy.feignclient.AddressClient;
import com.swy.response.AddressResponse;
import com.swy.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author: SMY
 * @time: 2025/6/10  00:01
 * @description:
 */

@Service
public class EmployeeService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AddressClient addressClient;

    public EmployeeResponse getEmployeeById(int id){
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName("张三");
        employee.setEmail("<EMAIL>");
        employee.setAge("18");

        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);

        // Using FeignClient
        ResponseEntity<AddressResponse> addressResponse = addressClient.getAddressByEmployeeId(id);
        employeeResponse.setAddress(addressResponse.getBody());

        return employeeResponse;
    }

}

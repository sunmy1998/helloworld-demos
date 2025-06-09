package com.swy.controller;


import com.swy.response.AddressResponse;
import com.swy.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: SMY
 * @time: 2025/6/10  00:18
 * @description:
 */

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/address/{id}")
    public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("id") int id){
        AddressResponse addressResponse = addressService.getAddressByEmployeeId(id);
        return ResponseEntity.ok(addressResponse);
    }

}

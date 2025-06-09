package com.swy.service;


import com.swy.entity.Address;
import com.swy.response.AddressResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: SMY
 * @time: 2025/6/10  00:16
 * @description:
 */

@Service
public class AddressService {

    @Autowired
    private ModelMapper modelMapper;

    public AddressResponse getAddressByEmployeeId(int id) {
        Address address = new Address();
        address.setId(id);
        address.setCity("上海");
        address.setState("上海");

        AddressResponse addressResponse = modelMapper.map(address, AddressResponse.class);
        return addressResponse;
    }

}

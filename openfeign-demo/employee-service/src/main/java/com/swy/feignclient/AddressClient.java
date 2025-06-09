package com.swy.feignclient;


import com.swy.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: SMY
 * @time: 2025/6/9  23:56
 * @description:
 */

@FeignClient(name = "address-service", url = "http://localhost:8081", path = "/address-service")
public interface AddressClient {

    @GetMapping("/address/{id}")
    public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("id") int id);

}

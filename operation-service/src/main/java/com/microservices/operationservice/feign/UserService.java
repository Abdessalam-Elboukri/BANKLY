package com.microservices.operationservice.feign;


import com.microservices.operationservice.services.dto.UserDto;
import com.microservices.operationservice.services.dto.WalletDto;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//@Service
@FeignClient(name = "gateway-service", url = "http://localhost:8081/api/v1")
public interface UserService {
    @GetMapping("/getall")
    List<UserDto> getAll();

    @GetMapping("/findby_cin/{cin}")
    UserDto findByCin(@PathVariable String cin);

}

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
@FeignClient(name = "user-service")
public interface UserService {
    @GetMapping("/users/getall")
    List<UserDto> getAll();

    @GetMapping("/users/findby_cin/{cin}")
    UserDto findByCin(@PathVariable String cin);

}

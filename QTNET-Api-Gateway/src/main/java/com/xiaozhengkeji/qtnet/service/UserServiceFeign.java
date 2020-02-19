package com.xiaozhengkeji.qtnet.service;

import com.xiaozhengkeji.qtnet.bean.ResponseBean;
import com.xiaozhengkeji.qtnet.service.fallback.UserServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user-provider" ,fallback = UserServiceFallback.class)
public interface UserServiceFeign {

    @PostMapping(value = "/info")
    ResponseBean info(@RequestParam("username") String username);

    @PostMapping(value = "/login")
    ResponseBean login(@RequestParam("username") String username,
                       @RequestParam("password") String password);

    @PostMapping(value = "/register")
    ResponseBean register(@RequestParam("username") String username,
                          @RequestParam("password") String password);

    @PostMapping("/register/getUser")
    ResponseBean registerGetUser(@RequestParam("username") String username);
}

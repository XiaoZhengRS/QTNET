package com.xiaozhengkeji.qtnet.api.user;

import com.xiaozhengkeji.qtnet.bean.ResponseBean;
import com.xiaozhengkeji.qtnet.service.UserServiceFeign;
import com.xiaozhengkeji.qtnet.utils.JWTUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@ApiOperation("用户API")
@RequestMapping("/v1/user")
@SuppressWarnings("ALL")
public class UserApi {
    @Autowired
    private UserServiceFeign userService;

    @PostMapping("/info")
    @ApiOperation("需要在请求协议头添加Authorization: Token")
    @RequiresAuthentication
    public ResponseBean info(@RequestParam("token") String token,
                             HttpServletRequest request) {
        String username = JWTUtil.getUsername(token);
        return userService.info(username);
    }


    @PostMapping("/login")
    @ApiOperation("登陆")
    public ResponseBean login(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              HttpServletRequest request) {
        return userService.login(username, password);
    }


    @PostMapping("/register")
    @ApiOperation("注册")
    public ResponseBean register(@RequestParam("username") String username,
                                 @RequestParam("password") String password) {
        return userService.register(username, password);
    }


    @PostMapping("/register/getUser")
    @ApiOperation("判断用户是否存在")
    public ResponseBean registerGetUser(@RequestParam("username") String username) {
        return userService.registerGetUser(username);
    }

}

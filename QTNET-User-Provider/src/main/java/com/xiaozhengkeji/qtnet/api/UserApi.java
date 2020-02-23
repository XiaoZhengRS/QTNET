package com.xiaozhengkeji.qtnet.api;

import com.alibaba.fastjson.JSONArray;
import com.xiaozhengkeji.qtnet.bean.LoginBean;
import com.xiaozhengkeji.qtnet.bean.ResponseBean;
import com.xiaozhengkeji.qtnet.entitys.UserPoJo;
import com.xiaozhengkeji.qtnet.service.UserService;
import com.xiaozhengkeji.qtnet.utils.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
public class UserApi {
    @Autowired
    private UserService userService;

    @PostMapping("/info")
    public ResponseBean info(@RequestParam("username") String username) {
        return new ResponseBean(200, "OK!", userService.getUserInFo(username));
    }

    @PostMapping("/login")
    public ResponseBean login(@RequestParam("username") String username,
                              @RequestParam("password") String password) {

        UserPoJo userPoJo = userService.getUserInFo(username);
        if (userPoJo == null) {
            return new ResponseBean(401, "登陆失败!", "用户名不存在!");
        }
        if (userPoJo.getPassword().equalsIgnoreCase(password)) {
            LoginBean loginBean = new LoginBean();
            loginBean.setToken(JWTUtil.sign(username, password));
            loginBean.setUUID(userPoJo.getUuid());
            loginBean.setId(String.valueOf(userPoJo.getRid()));
            return new ResponseBean(200, "登陆成功!", JSONArray.toJSON(loginBean));
        }
        return new ResponseBean(401, "登陆失败!", "用户密码错误!");
    }

    @PostMapping("/register")
    public ResponseBean register(@RequestParam("username") String username,
                                 @RequestParam("password") String password) {
        UserPoJo userPoJo = new UserPoJo();
        userPoJo.setRid(1);
        userPoJo.setUsername(username);
        userPoJo.setPassword(password);
        userPoJo.setUuid(UUID.randomUUID().toString());
        if (userService.regUser(userPoJo)){
            return new ResponseBean(200, "处理完成!", "注册成功!");
        }else {
            return new ResponseBean(412, "注册失败!", "注册失败!");
        }
    }

    @PostMapping("/register/getUser")
    public ResponseBean registerGetUser(@RequestParam("username") String username) {
        UserPoJo userPoJo = userService.getUserInFo(username);
        if (userPoJo != null) {
            return new ResponseBean(200, "用户名存在", true);
        }
        return new ResponseBean(200, "用户名不存在", false);
    }
}

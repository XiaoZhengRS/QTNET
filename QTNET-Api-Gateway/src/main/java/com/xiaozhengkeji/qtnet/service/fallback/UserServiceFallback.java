package com.xiaozhengkeji.qtnet.service.fallback;

import com.xiaozhengkeji.qtnet.bean.ResponseBean;
import com.xiaozhengkeji.qtnet.service.UserServiceFeign;
import org.springframework.stereotype.Component;

@Component
public class UserServiceFallback implements UserServiceFeign {
    @Override
    public ResponseBean info(String username) {
        return null;
    }

    @Override
    public ResponseBean login(String username, String password) {
        return null;
    }

    @Override
    public ResponseBean register(String username, String password) {
        return null;
    }

    @Override
    public ResponseBean registerGetUser(String username) {
        return null;
    }
}

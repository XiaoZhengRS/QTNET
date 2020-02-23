package com.xiaozhengkeji.qtnet.service.fallback;

import com.xiaozhengkeji.qtnet.bean.ResponseBean;
import com.xiaozhengkeji.qtnet.service.UserServiceFeign;
import org.springframework.stereotype.Component;

@Component
public class UserServiceFallback implements UserServiceFeign {
    private ResponseBean responseBean = new ResponseBean().setCode(404).setMsg("服务无法访问1").setData("指定服务集群下线!");

    @Override
    public ResponseBean info(String usehrname) {
        return responseBean;
    }

    @Override
    public ResponseBean login(String username, String password) {
        return responseBean;
    }

    @Override
    public ResponseBean register(String username, String password) {
        return responseBean;
    }

    @Override
    public ResponseBean registerGetUser(String username) {
        return responseBean;
    }
}

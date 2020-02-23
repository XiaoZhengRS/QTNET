package com.xiaozhengkeji.qtnet.service.fallback;

import com.xiaozhengkeji.qtnet.bean.ResponseBean;
import com.xiaozhengkeji.qtnet.service.RedisServiceFeign;
import org.springframework.stereotype.Component;

@Component
public class RedisServiceFallback implements RedisServiceFeign {
    private ResponseBean responseBean = new ResponseBean().setCode(404).setMsg("服务无法访问").setData("指定服务集群下线!");

    @Override
    public ResponseBean set(String key, Object value) {
        return responseBean;
    }

    @Override
    public ResponseBean set(String key, Object value, Long expireTime) {
        return responseBean;
    }

    @Override
    public void remove(String key) {

    }

    @Override
    public ResponseBean exists(String key) {
        return responseBean;
    }

    @Override
    public ResponseBean get(String key) {
        return responseBean;
    }

    @Override
    public void hmSet(String key, Object hashKey, Object value) {

    }

    @Override
    public ResponseBean hmGet(String key, Object hashKey) {
        return responseBean;
    }

    @Override
    public void lPush(String k, Object v) {

    }

    @Override
    public ResponseBean lRange(String k, long l, long l1) {
        return responseBean;
    }

    @Override
    public void add(String key, Object value) {

    }

    @Override
    public void setMembers(String key) {

    }

    @Override
    public void zAdd(String key, Object value, double scoure) {

    }

    @Override
    public ResponseBean rangeByScore(String key, double scoure, double scoure1) {
        return responseBean;
    }
}

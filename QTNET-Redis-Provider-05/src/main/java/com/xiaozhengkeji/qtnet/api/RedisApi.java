package com.xiaozhengkeji.qtnet.api;

import com.xiaozhengkeji.qtnet.bean.ResponseBean;
import com.xiaozhengkeji.qtnet.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RedisApi {
    @Autowired
    private RedisService redisService;

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    @PostMapping("/set")
    public ResponseBean set(@RequestParam("key") String key,
                            @RequestParam("value") Object value) {
        return new ResponseBean(200, "OK!", redisService.set(key, value));
    }

    /**
     * 写入缓存设置时效时间
     *
     * @param key
     * @param value
     * @return
     */
    @PostMapping("/set/time")
    public ResponseBean set(@RequestParam("key") String key,
                            @RequestParam("value") Object value,
                            @RequestParam("expireTime") Long expireTime) {
        return new ResponseBean(200, "OK!", redisService.set(key, value, expireTime));
    }

    /**
     * 删除对应的value
     *
     * @param key
     */
    @PostMapping("/remove")
    public void remove(@RequestParam("key") String key) {
        redisService.remove(key);
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    @PostMapping("/exists")
    public ResponseBean exists(@RequestParam("key") String key) {
        return new ResponseBean(200, "OK!", redisService.exists(key));
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    @PostMapping("/get")
    public ResponseBean get(@RequestParam("key") String key) {
        return new ResponseBean(200, "OK!", redisService.get(key));
    }

    /**
     * 哈希 添加
     *
     * @param key
     * @param hashKey
     * @param value
     */
    @PostMapping("hmSet")
    public void hmSet(@RequestParam("key") String key,
                      @RequestParam("hashKey") Object hashKey,
                      @RequestParam("value") Object value) {
        redisService.hmSet(key, hashKey, value);
    }

    /**
     * 哈希获取数据
     *
     * @param key
     * @param hashKey
     * @return
     */
    @PostMapping("hmGet")
    public ResponseBean hmGet(@RequestParam("key") String key,
                              @RequestParam("hashKey") Object hashKey) {
        return new ResponseBean(200, "OK!", redisService.hmGet(key, hashKey));

    }

    /**
     * 列表添加
     *
     * @param k
     * @param v
     */
    @PostMapping("lPush")
    public void lPush(@RequestParam("k") String k,
                      @RequestParam("v") Object v) {
        redisService.lPush(k, v);

    }

    /**
     * 列表获取
     *
     * @param k
     * @param l
     * @param l1
     * @return
     */
    @PostMapping("lRange")
    public ResponseBean lRange(@RequestParam("k") String k,
                               @RequestParam("l") long l,
                               @RequestParam("l1") long l1) {
        return new ResponseBean(200, "OK!", redisService.lRange(k, l, l1));
    }

    /**
     * 集合添加
     *
     * @param key
     * @param value
     */
    @PostMapping("add")
    public void add(@RequestParam("key") String key,
                    @RequestParam("value") Object value) {
        redisService.add(key, value);

    }

    /**
     * 集合获取
     *
     * @param key
     * @return
     */
    @PostMapping("setMembers")
    public void setMembers(@RequestParam("key") String key) {
        redisService.setMembers(key);
    }

    /**
     * 有序集合添加
     *
     * @param key
     * @param value
     * @param scoure
     */
    @PostMapping("zAdd")
    public void zAdd(@RequestParam("key") String key,
                     @RequestParam("value") Object value,
                     @RequestParam("scoure") double scoure) {
        redisService.zAdd(key, value, scoure);
    }

    /**
     * 有序集合获取
     *
     * @param key
     * @param scoure
     * @param scoure1
     * @return
     */
    @PostMapping("rangeByScore")
    public ResponseBean rangeByScore(@RequestParam("key") String key,
                                     @RequestParam("scoure") double scoure,
                                     @RequestParam("scoure1") double scoure1) {
        return new ResponseBean(200, "OK!", redisService.rangeByScore(key, scoure, scoure1));
    }

}

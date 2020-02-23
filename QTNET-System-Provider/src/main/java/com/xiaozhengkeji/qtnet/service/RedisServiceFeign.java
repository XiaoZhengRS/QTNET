package com.xiaozhengkeji.qtnet.service;

import com.xiaozhengkeji.qtnet.bean.ResponseBean;
import com.xiaozhengkeji.qtnet.service.fallback.RedisServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "redis05-provider", fallback = RedisServiceFallback.class)
public interface RedisServiceFeign {
    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    @PostMapping("/set")
    ResponseBean set(@RequestParam("key") String key,
                     @RequestParam("value") Object value);


    /**
     * 写入缓存设置时效时间
     *
     * @param key
     * @param value
     * @return
     */
    @PostMapping("/set/time")
    ResponseBean set(@RequestParam("key") String key,
                     @RequestParam("value") Object value,
                     @RequestParam("expireTime") Long expireTime);

    /**
     * 删除对应的value
     *
     * @param key
     */
    @PostMapping("/remove")
    void remove(@RequestParam("key") String key);

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    @PostMapping("/exists")
    ResponseBean exists(@RequestParam("key") String key);

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    @PostMapping("/get")
    ResponseBean get(@RequestParam("key") String key);

    /**
     * 哈希 添加
     *
     * @param key
     * @param hashKey
     * @param value
     */
    @PostMapping("hmSet")
    void hmSet(@RequestParam("key") String key,
               @RequestParam("hashKey") Object hashKey,
               @RequestParam("value") Object value);

    /**
     * 哈希获取数据
     *
     * @param key
     * @param hashKey
     * @return
     */
    @PostMapping("hmGet")
    ResponseBean hmGet(@RequestParam("key") String key,
                       @RequestParam("hashKey") Object hashKey);

    /**
     * 列表添加
     *
     * @param k
     * @param v
     */
    @PostMapping("lPush")
    void lPush(@RequestParam("k") String k,
               @RequestParam("v") Object v);

    /**
     * 列表获取
     *
     * @param k
     * @param l
     * @param l1
     * @return
     */
    @PostMapping("lRange")
    ResponseBean lRange(@RequestParam("k") String k,
                        @RequestParam("l") long l,
                        @RequestParam("l1") long l1);

    /**
     * 集合添加
     *
     * @param key
     * @param value
     */
    @PostMapping("add")
    void add(@RequestParam("key") String key,
             @RequestParam("value") Object value);

    /**
     * 集合获取
     *
     * @param key
     * @return
     */
    @PostMapping("setMembers")
    void setMembers(@RequestParam("key") String key);

    /**
     * 有序集合添加
     *
     * @param key
     * @param value
     * @param scoure
     */
    @PostMapping("zAdd")
    void zAdd(@RequestParam("key") String key,
              @RequestParam("value") Object value,
              @RequestParam("scoure") double scoure);

    /**
     * 有序集合获取
     *
     * @param key
     * @param scoure
     * @param scoure1
     * @return
     */
    @PostMapping("rangeByScore")
    ResponseBean rangeByScore(@RequestParam("key") String key,
                              @RequestParam("scoure") double scoure,
                              @RequestParam("scoure1") double scoure1);
}

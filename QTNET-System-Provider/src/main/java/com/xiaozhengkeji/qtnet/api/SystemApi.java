package com.xiaozhengkeji.qtnet.api;

import com.xiaozhengkeji.qtnet.service.RedisServiceFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SystemApi {
    @Autowired
    private RedisServiceFeign serviceFeign;

}

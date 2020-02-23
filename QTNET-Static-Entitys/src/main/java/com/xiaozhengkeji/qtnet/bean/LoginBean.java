package com.xiaozhengkeji.qtnet.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class LoginBean {
    private String token;
    private String UUID;
    private String id;
}

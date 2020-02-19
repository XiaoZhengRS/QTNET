package com.xiaozhengkeji.qtnet.entitys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@TableName("permission")
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class PermissionPoJo implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer pid;
    private String permission;
    private Integer rid;
}

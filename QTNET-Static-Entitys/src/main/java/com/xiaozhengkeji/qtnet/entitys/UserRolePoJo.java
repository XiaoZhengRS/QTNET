package com.xiaozhengkeji.qtnet.entitys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@TableName("userrole")
@Data
@NoArgsConstructor
@Accessors( chain = true )
public class UserRolePoJo implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer urid;
    private Integer uid;
    private Integer rid;
}

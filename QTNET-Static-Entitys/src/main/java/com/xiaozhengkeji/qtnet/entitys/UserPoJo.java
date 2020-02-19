package com.xiaozhengkeji.qtnet.entitys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("user")
public class UserPoJo implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private Integer rid;
    private String uuid;
    /**
     * 角色
     */
    @TableField(exist = false)
    private RolePoJo role;
    /**
     * 权限列表
     */
    @TableField(exist = false)
    private List<PermissionPoJo> permissions;


}

package com.xiaozhengkeji.qtnet.entitys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@TableName("rolepermission")
@Data
@NoArgsConstructor
@Accessors( chain = true )
public class RolepermissionPoJo implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer rpid;
    private Integer rid;
    private Integer pid;
}

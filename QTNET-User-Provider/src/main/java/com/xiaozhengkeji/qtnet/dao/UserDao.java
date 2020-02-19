package com.xiaozhengkeji.qtnet.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;


import com.xiaozhengkeji.qtnet.entitys.UserPoJo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<UserPoJo> {
}

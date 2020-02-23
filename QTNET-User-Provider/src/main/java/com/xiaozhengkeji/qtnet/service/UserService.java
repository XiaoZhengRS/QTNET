package com.xiaozhengkeji.qtnet.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaozhengkeji.qtnet.dao.PermissionDao;
import com.xiaozhengkeji.qtnet.dao.RoleDao;
import com.xiaozhengkeji.qtnet.dao.RolepermissionDao;
import com.xiaozhengkeji.qtnet.dao.UserDao;
import com.xiaozhengkeji.qtnet.entitys.PermissionPoJo;
import com.xiaozhengkeji.qtnet.entitys.RolePoJo;
import com.xiaozhengkeji.qtnet.entitys.UserPoJo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;

@SuppressWarnings("ALL")
@Slf4j
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private PermissionDao permissionDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private RolepermissionDao rolepermissionDao;

    /**
     * 用户注册
     */
    public Boolean regUser(UserPoJo userPoJo) {
        try {
            if (userDao.insert(userPoJo) < 1) {
                return false;
            }else {
                return true;
            }
        }catch (Exception e){
            return false;
        }
    }

    /**
     * 用户信息
     */
    public UserPoJo getUserInFo(String username) {
        QueryWrapper<UserPoJo> queryWrapperUser = new QueryWrapper<UserPoJo>();
        queryWrapperUser.eq("username", username);
        UserPoJo userPoJo = userDao.selectOne(queryWrapperUser);
        if(userPoJo == null){
            return null;
        }
        QueryWrapper<RolePoJo> queryWrapperRole = new QueryWrapper<RolePoJo>();
        queryWrapperRole.eq("rid", userPoJo.getRid());
        userPoJo.setRole(roleDao.selectOne(queryWrapperRole));
        QueryWrapper<PermissionPoJo> queryWrapperpermission = new QueryWrapper<PermissionPoJo>();
        queryWrapperpermission.eq("rid", userPoJo.getRid());
        userPoJo.setPermissions(permissionDao.selectList(queryWrapperpermission));
        return userPoJo;
    }

    /**
     * 用户信息修改
     */
    public UserPoJo setUserInFo(String username, UserPoJo userPoJo) {
        return null;
    }
}

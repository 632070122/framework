package com.hengshui.dao;

import com.hengshui.domain.Role;

import java.util.List;

public interface RoleDao {

    //查询所有角色
    List<Role> findAll();

    //查询所有角色并且查询出所赋予的用户
    List<Role> findRoleAndUser();
}

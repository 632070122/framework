package com.hengshui.dao;

import com.hengshui.domain.IdentityCard;

import java.util.List;

public interface IdentityCardDao {

    //查询所有身份证号
    List<IdentityCardDao> findAll();

    //根据userId查询身份证号
    IdentityCard findByUserId(Integer userId);

    //根据身份证号码查询用户信息（1对一）
    IdentityCard findByIdentityCard(String userIdentityCard);


}

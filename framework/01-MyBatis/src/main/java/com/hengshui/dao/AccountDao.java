package com.hengshui.dao;

import com.hengshui.domain.Account;

import java.util.List;

public interface AccountDao {

    //根据账户账号查询用户的信息(一对一)
    Account findAccountUser(Integer cardNumber);

    //根据User的ID查询所有account(一对多)
    List<Account> findById(Integer userId);
}

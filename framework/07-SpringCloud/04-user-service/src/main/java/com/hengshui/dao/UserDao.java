package com.hengshui.dao;

import com.hengshui.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public interface UserDao {

    User findById(Integer userId);
}

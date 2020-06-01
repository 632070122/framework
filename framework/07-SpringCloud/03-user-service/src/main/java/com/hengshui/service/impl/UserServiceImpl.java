package com.hengshui.service.impl;
import com.hengshui.dao.UserDao;
import com.hengshui.domain.User;
import com.hengshui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findById(Integer userId) {
        return userDao.findById(userId);
    }
}

package com.hengshui.service;

import com.hengshui.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserService {

    List<User> findAll();

    void saveUser(User user);
}

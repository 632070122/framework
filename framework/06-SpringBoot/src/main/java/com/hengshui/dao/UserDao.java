package com.hengshui.dao;
import com.hengshui.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository("userDao")
@Mapper
public interface UserDao{

    List<User> findAll();
}

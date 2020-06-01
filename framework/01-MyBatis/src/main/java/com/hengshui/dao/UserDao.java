package com.hengshui.dao;
import com.hengshui.domain.User;
import com.hengshui.domain.pojo.QueryVo;

import java.util.List;

public interface UserDao {

    //查询所有用户
    List<User> findAll();

    //保存用户
    void saveUser1(User user);

    //保存用户并得到ID
    void saveUser2(User user);

    //更新用户
    void updateUser(User user);

    //删除用户
    void deleteUser(Integer userId);

    //根据id查询一个
    User findOne(Integer userId);

    //模糊查询方式1
    List<User> findByName1(String userName);

    //模糊查询方式2
    List<User> findByName2(String userName);

    //查询总用户数
    int findTotal();

    //根据传入的条件，实体类进行查询
    List<User> findUserByQueryVo(QueryVo vo);

    //超级模糊查询1
    List<User> findUserByCondition1(User user);

    //超级模糊查询2
    List<User> findUserByCondition2(User user);

    //根据QueryVo中提供的ID集合查询
    List<User> findUserInIds(QueryVo vo);

    //根据姓名查询身份证号（1对一）
    List<User> findNameAll(String identityCard);

    //查询所有用户并得到用户所拥有的账户（一对多）
    List<User> findUserAccount();

    //查询所有用户并得到用户所有的角色(多对多)
    List<User> findUserAndRole();

    //查询所有用户和用户的账户,账户为延迟加载
    List<User> findUserDelayAccount();

    //查询所有用户和用户的身份证号,身份证号延迟加载
    List<User> findUserDelayIdentityCard();


}

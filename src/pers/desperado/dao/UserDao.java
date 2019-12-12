package pers.desperado.dao;

import pers.desperado.domain.User;

public interface UserDao {
    /**
     * 查询用户信息
     * @param username
     * @return
     */
    User findByUsername(String username);
    User findByUsername(String username,String password,String identity);
    /**
     * 添加用户信息
     * @param user
     */
    void  save(User user);
}

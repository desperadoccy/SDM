package pers.desperado.service.impl;

import pers.desperado.dao.UserDao;
import pers.desperado.dao.impl.UserDaoImpl;
import pers.desperado.domain.User;
import pers.desperado.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    /**
     * 注册用户
     * @param user
     * @return
     */
    @Override
    public boolean regist(User user) {
        User u = userDao.findByUsername(user.getUsername());
        if (u != null){
            return  false;
        }
        userDao.save(user);
        return true;
    }

    /**
     * 登录方法
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return userDao.findByUsername(user.getUsername(),user.getPassword(),user.getIdentity());
    }


}

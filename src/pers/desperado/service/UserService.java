package pers.desperado.service;

import pers.desperado.domain.User;

public interface UserService {
    boolean regist(User user);
    User login(User user);
}

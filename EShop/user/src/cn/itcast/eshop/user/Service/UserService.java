package cn.itcast.eshop.user.Service;

import cn.itcast.eshop.user.entity.User;

public interface UserService {

    User  login(User user) throws Exception;
}

package cn.itcast.eshop.user.Service.impl;

import cn.itcast.eshop.user.Service.UserService;
import cn.itcast.eshop.user.dao.Impl.UserDAOImpl;
import cn.itcast.eshop.user.dao.UserDAO;
import cn.itcast.eshop.user.entity.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    /**
     * 用户登录，根据用户名和密码获取对象
     * 1.调用 UserDAo 用户列表数据
     *      List<User> getEntityList() throws Exception;
     * 2.通过用户列表，逐个与给定的用户对象的用户名和密码进行匹配
     * 3.匹配成功返回用户对象，失败返回 null
     *
     * @param user 封装了用户名和密码的实体对象
     * @return  返回 User 对象 ， 或用户名/密码错误时返回 null
     * @throws Exception
     */
    public User login(User user ) throws Exception {
        //1.调用 UserDAo 用户列表数据
         userDAO = new UserDAOImpl();
         List<User> userList =  ((UserDAOImpl)userDAO).getEntityList();

         //2.通过用户列表，逐个与给定的用户对象的用户名和密码进行匹配
        if(userList != null) {
            for (User u : userList) {
//                /*****************/
//                System.out.println("1--" + u.getUsername() + "2--" + u.getPassword());
                if (u.getUsername().equals(user.getUsername()) &&
                        u.getPassword().equals(user.getPassword())) {
                    return u;  //3.匹配成功返回用户对象，失败返回 null
                }
            }
        }
        return null;
    }
}

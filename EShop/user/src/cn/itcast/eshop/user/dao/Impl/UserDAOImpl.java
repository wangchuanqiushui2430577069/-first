package cn.itcast.eshop.user.dao.Impl;

import cn.itcast.eshop.common.dao.Impl.BaseDAOImpl;
import cn.itcast.eshop.common.dao.Impl.TXTDataAccess;
import cn.itcast.eshop.user.dao.UserDAO;
import cn.itcast.eshop.user.entity.User;
import java.util.List;

public class UserDAOImpl extends BaseDAOImpl implements UserDAO {

    /**
     * 调用 IDataAccess 获取数据并返回
     * 1.创建 IDataAccess 子类 TXTDataAccess();
     *      IDataAccess dataAccess = new TXTDataAccess();
     * 2.调用该对象的方法获取所有用户的数据并返回
     *      List<User> userList = dataAccess.getList( User.class )
     * @return  返回用户对象列表
     * @throws Exception
     */
    @Override
    public List<User> getEntityList() throws Exception {

        //2.调用该对象的方法获取所有用户的数据并返回
        return ((TXTDataAccess)dataAccess).getList(User.class);
    }
}

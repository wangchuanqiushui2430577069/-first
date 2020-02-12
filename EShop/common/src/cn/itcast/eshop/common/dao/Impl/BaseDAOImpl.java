package cn.itcast.eshop.common.dao.Impl;

import cn.itcast.eshop.common.dao.BaseDAO;
import cn.itcast.eshop.common.dao.IDataAccess;

public class BaseDAOImpl implements BaseDAO {
    //1.创建 IDataAccess 子类 TXTDataAccess();
     protected IDataAccess dataAccess = new TXTDataAccess();

}

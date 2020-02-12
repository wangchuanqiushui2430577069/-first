package cn.itcast.eshop.common.dao.Impl;

import cn.itcast.eshop.common.dao.IDataAccess;
import cn.itcast.eshop.common.util.FileUtil;
import cn.itcast.eshop.common.util.JSONUtil;

import java.util.List;

public class TXTDataAccess implements IDataAccess {

    /**
     * 获取数据列表
     *
     * 1.根据实体类的字节码文件对象获取类名
     * 2.根据类名获取用户数据文件名
     * 3.合成数据文件路径
     * 4.使用文件操作工具类读取文件中的字符串数据
     * 5.将字符串数据转换成 List<User> 对象并返回
     * @param clazz
     * @param <T>
     * @return
     * @throws Exception
     */

    @Override
    public <T> List<T> getList(Class<T> clazz) throws Exception {
        //1.根据实体类的字节码文件对象获取类名
        String userName = clazz.getSimpleName().toLowerCase(); //将获得大写的 User 类名转成小写类名 user
        //2.根据类名获取用户数据文件名
        String dataFileName = "db_" + userName + ".txt";  //db_user.txt
        //3.合成数据文件路径
        String dataFilePath = "db/" + dataFileName;  //db/db_user.txt
        //4.使用文件操作工具类读取文件中的字符串数据
        String dataJSON = FileUtil.readByBuffered(dataFilePath);
//        /***************************/
//        System.out.println("dataJSON = " + dataJSON);
        //5.将字符串数据转换成 List<User> 对象并返回
        return JSONUtil.JSONArrayToList(dataJSON, clazz);
    }
}

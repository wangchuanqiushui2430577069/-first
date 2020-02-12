package cn.itcast.eshop.common.util;

import cn.itcast.eshop.common.entity.Entity;
import com.alibaba.fastjson.JSON;  //导入在lib中的jar包

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import cn.itcast.eshop.user.entity.User;


/**
 * JSON
 *  对象 { }
 *  数组 [ ]
 */


/**
 * JSONUtil工具类
 * 处理JSON 相关的所有内容
 */
public class JSONUtil {
    

    public static void main(String[] args) throws Exception {
        Entity entity = new Entity();
        entity.setId("100");
        entity.setCreateTime("18:06");
        String s = entityToJSON(entity); //打印结果为对象： {"createTime":"18:06","id":"100","idDel":"1"}
        System.out.println(s);

        System.out.println("--------------------------------------");
        List<Entity> entityList = new ArrayList<>();
        entityList.add(entity);
        String jsonlist = entityListToJSON(entityList);
        System.out.println(jsonlist); //打印结果为数组：[{"createTime":"18:06","id":"100","idDel":"1"}]

        System.out.println("--------------------------------------");
//        String json2 = "{\"createTime\":\"21:45\",\"id\":\"100\",\"idDel\":\"1\"}";
//        Object object = JSONToEntity(json2, Entity.class);
//        Entity e = (Entity)object;
//        System.out.println(e.getCreateTime());

        String json2 = "{\"createTime\":\"21:56\",\"id\":\"100\",\"idDel\":\"1\"}";
        Entity e  = JSONToEntity(json2, Entity.class);
        System.out.println(e.getCreateTime());

        System.out.println("--------------------------------------");
        String json3= "[{\"createTime\":\"22:06\",\"id\":\"120\",\"idDel\":\"1\"}," +
                "{\"createTime\":\"22:31\",\"id\":\"110\",\"idDel\":\"1\"}"+"]";
        List<Entity> entity3  = JSONArrayToList(json3, Entity.class);
        System.out.println(entity3.get(0).getCreateTime());
        System.out.println(entity3.get(1).getCreateTime());

        /**
         * 测试部分
         */
        System.out.println("-----------------------------------------");
        StringBuilder sb = new StringBuilder();
        File file = new File("C:\\计算机组成\\Test.txt");
        if (file.exists()) {
            System.out.println("进入文件！");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str = br.readLine();  //执行读取
            while (str != null) {
                sb.append(str);
                str = br.readLine();
            }
            br.close();
        }

        String dataJSON = sb.toString();
        User testJSON = JSONToEntity(dataJSON, User.class);
        System.out.println("testJSON: username=" + testJSON.getUsername() +
                "  password = " + testJSON.getPassword());

    }
    /**
     * 把对象转换成JSON格式的字符串
     *
     * @param entity 指定对象
     * @return  返回JSON格式的字如串
     */
    public static String entityToJSON(Object entity) {

        return JSON.toJSONString(entity);
    }

    /**
     * 把对象列表转换成JSON格式的字符串
     *
     * @param entityList 指定对象列表
     * @return  返回JSON格式的字符串
     */
    public static String entityListToJSON(List<?> entityList) {

        return entityToJSON(entityList);
    }

    /**
     * 把JSON字符串转换成指定类型的对象
     *
     * ? 泛型的通配符，代表未知的任意类型，
     * @param json 要转换的数值
     * @param clazz 指定的类型
     * @return 返回 Object 对象
     */
//    public static Object JSONToEntity(String json, Class<?> clazz) {
//        Object object = JSON.parseObject(json, clazz);
//        return object;
//    }
     /**
     * 改进方法，泛型定义
     */
     public static <T> T JSONToEntity(String json, Class<T> clazz) {

         return JSON.parseObject(json, clazz);
   }

    /**
     * 将JSON数组转换成指定类型的对象
     *
     * @param json 数据
     * @param clazz 指定类型的Class对象
     * @param <T> 指定的类型
     * @return 对象列表
     */
    public static <T> List <T>  JSONArrayToList(String json, Class<T> clazz){

        return JSON.parseArray(json, clazz);
    }
}

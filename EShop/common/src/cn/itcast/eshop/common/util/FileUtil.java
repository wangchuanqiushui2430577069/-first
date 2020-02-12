package cn.itcast.eshop.common.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class FileUtil {

    /**
     * 将字符串缓冲流对象读取文件内容并转成字符串返回
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    public static String readByBuffered(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        //使用 ClassLoader 加载资源，路径从 src 下开始：db/db_user.txt
        filePath = "D:/刘永迪的代码/IDEA代码/EShop/out/production/common/" + filePath;
        // 下面这个方法无法返回路径中的中文 ？？？
        // FileUtil.class.getClassLoader().getResource(filePath).getFile();

        File file = new File(filePath);
        if (file.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str = br.readLine();  //执行读取
            while (str != null) {
                sb.append(str);
                str = br.readLine();
            }
            br.close();
            return sb.toString();
        }
        return null;
    }



    /**
     * 将字符串数据写入指定文件，写入时会清空原文件内容
     *
     *
     * @param data
     * @param destFilePath
     */
    public static void writeByBuffered(String data, String destFilePath) throws IOException {

        File destFile = new File(destFilePath);
        if (!destFile.exists()) {

        }

    }

}

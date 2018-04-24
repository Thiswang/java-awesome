/**
 * Copyright (C), 2011-2018, 微贷网.
 */
package file_write;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * @author wangzhe 2018/4/24.
 */
public class WriteFileBase {
    public static void main(String[] args) {
        WriteFile("/Users/wangzhe/Downloads/test.txt");
    }

    /**
     *
     */
    public static void WriteFile(String filePath){

        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file,true);
            bw = new BufferedWriter(fw);

            for (long i = 0; i < 100000000; i++) {
                bw.write("第3次测试数据测试数据测试数据 line:" + i + "\r\n");
                if (i % 1000000 == 0) {
                    bw.write("这个数据有意思了！ line:" + i + "\r\n");
                }
            }
            fw.close();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (bw != null) {
                try {

                    bw.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


    }
}

/**
 * Copyright (C), 2011-2018, 微贷网.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

/**
 * @author wangzhe 2018/4/24.
 */
public class Test {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        readFileByLines("/Users/wangzhe/Downloads/test.txt");
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
    }

    public static void readFileByLines(String fileName) {

        Stack<String> strings = new Stack<>();

        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                if (tempString.contains("有意思了")) {
                    strings.push(tempString);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }

        System.out.println("总数："+ strings.size());
        while (!strings.empty()){
            System.out.println(strings.pop());
        }

    }
}

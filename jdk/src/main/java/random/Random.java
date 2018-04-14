/**
 * Copyright (C), 2011-2018, 微贷网.
 */
package random;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzhe 2018/3/9.
 */
public class Random {
    public static void main(String[] args) {
       /* int Min = 0;
        int Max = 6;

        for (int i = 0; i < 100; i++) {
            int result = Min + (int)(Math.random() * ((Max - Min) + 1));
            System.out.println(result);
        }*/

        List<String> list = new ArrayList<>();
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");

        for (int i = 0; i < 100; i++) {
            int result = (int)(Math.random() * (list.size()));
            System.out.println(list.get(result));
        }
        //ThreadLocal
    }


}

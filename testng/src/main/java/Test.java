/**
 * Copyright (C), 2011-2018, 微贷网.
 */

import java.util.ArrayList;

/**
 * @author wangzhe 2018/4/23.
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.test2();
    }

    public void test1() {
        ArrayList<Long> list = new ArrayList<>();

        long start = System.currentTimeMillis();

        for (int i = 0; i < 500000; i++) {
            list.add(15195913506L + i);
        }

        System.out.println(System.currentTimeMillis() - start);
        System.out.println(list.size());

    }

    public void test2()
    {
        ArrayList<String> list = new ArrayList<>();
        long start = System.currentTimeMillis();
        for(int i = 0; i<500000; i++){
            list.add("151959"+i);
        }
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(list.size());

    }

}

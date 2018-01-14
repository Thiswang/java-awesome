/**
 * Copyright (C), 2011-2018, 微贷网.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzhe 2018/1/5.
 */
public class FinalTest {

    public static void main(String[] args) {
        final List<String> list = new ArrayList<>();

        list.add("1");
        list.add("2");

        for (String s :list)
        {
            System.out.println(s);
        }
    }
}

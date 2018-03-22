/**
 * Copyright (C), 2011-2018, 微贷网.
 */

import java.util.Date;

/**
 * @author wangzhe 2018/2/9.
 */
public class Test {


    public static void main(String[] args) throws ClassNotFoundException,RuntimeException{
        String s ="Thu Mar 15 2018 08:00:00 GMT 0800 (CST)";
        Date d = new Date(s);

        System.out.println(d.getMonth());
    }


}

/**
 * Copyright (C), 2011-2018, 微贷网.
 */
package concurrent.collection;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wangzhe 2018/2/8.
 */
public class HashMapTest {
    public static void main(String[] args) {


        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("1","1");
        concurrentHashMap.get("1");



    }
}

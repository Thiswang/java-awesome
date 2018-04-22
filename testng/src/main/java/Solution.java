/**
 * Copyright (C), 2011-2018, 微贷网.
 */

import jnr.ffi.Struct;
import org.python.modules._hashlib;

import java.util.*;

/**
 * @author wangzhe 2018/4/18.
 */
public class Solution {
    public static void main(String[] args) {


        /*String[] str = {"1","2","3","3"};
        Set set = new HashSet();
        for(String s :str){
            set.add(s);
        }
        System.out.println(set.toString());*/


        /*List<String> list = new LinkedList<>();
        for(int i = 0;i<=100 ;i++)
        {
            list.add(i+"");
        }

        int n = 80;
        String result = list.get(list.size()-n);
        System.out.println(result);*/


        /*String[] str = {"1", "2", "3", "3", "4", "4", "4"};
        HashMap<String, Integer> data = new HashMap<>();

        for (String s : str) {
            if (data.containsKey(s)) {
                Integer num = data.get(s);
                data.replace(s, ++num);

            } else {
                data.put(s, 1);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(data.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        System.out.println(list);*/



        ArrayList<String> basicWords = new ArrayList<>();
        basicWords.add("杭州");
        basicWords.add("西湖");
        basicWords.add("西湖博物馆");
        basicWords.add("博物馆");

        Collections.sort(basicWords, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        String s = "我在杭州西湖边的西湖博物馆里面";

        boolean b = true;
        while (b){
            for(String s1:basicWords)
            {
                if(s.contains(s1))
                {
                    int index = s.indexOf(s1);

                }else {

                }
            }
        }


    }

}

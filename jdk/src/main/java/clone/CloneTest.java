/**
 * Copyright (C), 2011-2018, 微贷网.
 */
package clone;

import java.util.HashMap;

/**
 * @author wangzhe 2018/2/9.
 */

public class CloneTest implements Cloneable{
    private int var1;
    private String var2;
    private HashMap var3;
    private CloneTest1 var4;

    public int getVar1() {
        return var1;
    }

    public void setVar1(int var1) {
        this.var1 = var1;
    }

    public String getVar2() {
        return var2;
    }

    public void setVar2(String var2) {
        this.var2 = var2;
    }

    public HashMap getVar3() {
        return var3;
    }

    public void setVar3(HashMap var3) {
        this.var3 = var3;
    }

    public CloneTest1 getVar4() {
        return var4;
    }

    public void setVar4(CloneTest1 var4) {
        this.var4 = var4;
    }

    public static void main(String[] args) throws CloneNotSupportedException {

        CloneTest test1 = new CloneTest();
        test1.setVar1(1);
        test1.setVar2("1111");
        HashMap<String,String> map1 = new HashMap<>();
        map1.put("data","11111");
        test1.setVar3(map1);


        CloneTest test2 = (CloneTest) test1.clone();

        test1.setVar1(2);
        test1.setVar2("2222");
        test1.getVar3().put("data","22222");

        System.out.println(test1.getVar1());
        System.out.println(test1.getVar2());
        System.out.println(test1.getVar3().get("data"));



        System.out.println(test2.getVar1());
        System.out.println(test2.getVar2());
        System.out.println(test2.getVar3().get("data"));


    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

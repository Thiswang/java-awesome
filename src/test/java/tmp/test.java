/**
 * Copyright (C), 2011-2018, 微贷网.
 */
package tmp;

/**
 * @author wangzhe 2018/2/14.
 */
public class test {

    public static void main(String[] args) {
        Shape[] shapes = new Shape[4];

        shapes[0] = new Circle(1);
        shapes[1] = new Circle(2);
        shapes[2] = new Square(1);
        shapes[3] = new Square(2);
        maxArea(shapes);

    }

    public static void maxArea(Shape[] shapes) {
        double Max = shapes[0].area();
        int Index = 0;
        for (int i = 0; i < shapes.length; i++) {
            if (Max < shapes[i].area()) {
                Max = shapes[i].area();
                Index = i;
            }

        }
        System.out.println("最大值：" + Max);
    }
}

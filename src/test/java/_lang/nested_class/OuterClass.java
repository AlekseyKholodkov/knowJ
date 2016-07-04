package _lang.nested_class;

import org.testng.annotations.Test;

public class OuterClass {
    private int x = 0;
    private int y = 3;
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    static class StaticNestedClass {
        private static int x = 2;
        public static int getX() {
            return x;
        }
        public int get2X() {
            return 2 * x;
        }
    }

    class InnerClass {
        private int x = 1;
        public int getX() {
            return this.x;
        }
        public int getOuterClassY() {
            return y; // Y is not override in Inner Class
        }
        public int getOuterClassX() {
            return OuterClass.this.x; // X is override in Inner Class
        }
    }

    @Test
    public void nestedClassTest() {
        System.out.println("\n-------------StaticNestedClass---------------");
        System.out.println("OuterClass.StaticNestedClass.getX() = " + OuterClass.StaticNestedClass.getX());
        System.out.println("new OuterClass.StaticNestedClass().get2X() = " + new OuterClass.StaticNestedClass().get2X());

        System.out.println("\n-------------OuterClass----------------------");
        OuterClass outerClass = new OuterClass();
        System.out.println("outerClass.getX() = " + outerClass.getX());
        System.out.println("outerClass.getY() = " + outerClass.getY());

        System.out.println("\n-------------InnerClass----------------------");
        OuterClass.InnerClass innerClass = outerClass.new InnerClass(); // non static Inner Class can not exist without INSTANCE of Outer Class
        System.out.println("innerClass.getX() = " + innerClass.getX());
        System.out.println("innerClass.getOuterClassY() = " + innerClass.getOuterClassY());
        System.out.println("innerClass.getOuterClassX() = " + innerClass.getOuterClassX());
    }

}
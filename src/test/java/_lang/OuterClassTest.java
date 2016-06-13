package _lang;

import org.testng.annotations.Test;

public class OuterClassTest {
    @Test
    public void nestedClassTest() {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        System.out.println("innerClass.getX() = " + innerClass.getX());

        System.out.println("OuterClass.StaticNestedClass.getX() = " + OuterClass.StaticNestedClass.getX());
    }

}
package _util;

import java.util.Formatter;

public class Formatting {
    public static void main(String... args){
        Integer I1 = 0;
        Integer I2 = -1;
        Integer I3 = 1;
        Formatter f = new Formatter();
        f.format("%1$b ", I1.toString())
                .format("%1$b ", I2.toString())
                .format("%1$b ", I3.toString());
        System.out.println(f.toString()); // true true true
    }
}

package _util._formatter;

import java.util.Formatter;
import java.util.Locale;

public class Formatting {
    public void stringFormat() {
        Formatter formatter = new Formatter();
        formatter.format("%1$s %2$s %3$s", "a", "b", "c");
        System.out.print(formatter.toString());
    }

    public static void main(String... args){
        new Formatting().stringFormat();
        /*
        Integer I1 = 0;
        Integer I2 = -1;
        Integer I3 = 1;
        Formatter f = new Formatter();
        f.format("%1$b ", I1.toString())
                .format("%1$b ", I2.toString())
                .format("%1$b ", I3.toString())
                .format("%1$s", 0, 1);
        System.out.println(f.toString()); // true true true
        */
    }
}

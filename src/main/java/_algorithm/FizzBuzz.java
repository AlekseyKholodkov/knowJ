package _algorithm;

public class FizzBuzz {
    public static String viaArray(String inputString) {
        String[] arrayStrings = inputString.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= arrayStrings.length; i++) {
            if (i % 3 == 0 && i % 5 == 0) arrayStrings[i-1] = "FizzBuzz";
            else if (i % 3 == 0) arrayStrings[i-1] = "Fizz";
            else if (i % 5 == 0) arrayStrings[i-1] = "Buzz";
            builder.append(arrayStrings[i-1]).append(" ");
        }
        return builder.delete(builder.length()-1, builder.length()).toString();
    }
}

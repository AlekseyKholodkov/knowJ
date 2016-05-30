package _algorithm;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FizzBuzzTest {
    String inputString = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32";
    String outputString = "1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17 Fizz 19 Buzz Fizz 22 23 Fizz Buzz 26 Fizz 28 29 FizzBuzz 31 32";
    @Test
    public void fizzBuzzTest() {
        Assert.assertEquals(FizzBuzz.viaArray(inputString), outputString);
    }
}
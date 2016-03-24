import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {

    @Test
    public void generateEmailTest() {
        Calculator calculator = new Calculator();
        String email = calculator.generateEmail();

        Assert.assertNotNull(email);
        Assert.assertEquals(email, "feedback@yoursite.com");
    }
}


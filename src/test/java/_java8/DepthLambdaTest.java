package _java8;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DepthLambdaTest {
    public interface Chain {
        Chain deep();
    }

    @Test
    public void depthTest() {
        Chain chain = () -> () -> () -> () -> () -> () -> () -> () -> () -> () -> null;

        int depth = 0;
        while (chain != null) {
            depth++;
            chain = chain.deep();
        }
        Assert.assertEquals(depth, 10);
    }
}

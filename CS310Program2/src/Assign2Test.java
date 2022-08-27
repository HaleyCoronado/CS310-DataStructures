//import static org.junit.Assert.*;
//import org.junit.Test;

public class Assign2Test {

    public static void main(String[] args){
        Assign2Test a = new Assign2Test();
        a.TestCase1();
    }

    //@Test
    public void TestCase1() {
        Assign2.PromotedCarModelStack stack = new Assign2.PromotedCarModelStack();
        stack.push("m3", 35000);
        testHighestLowestPeek("m3", 35000, "m3", 35000, "m3", 35000, stack);

        stack.push("ms", 64000);
        testHighestLowestPeek("ms", 64000, "m3", 35000, "ms", 64000, stack);

        stack.push("my", 38000);
        testHighestLowestPeek("ms", 64000, "m3", 35000, "my", 38000, stack);

        Assign2.PromotedModel popped = stack.pop();
        assertTrue(popped.getModel().equalsIgnoreCase("my"));
        assertTrue(popped.getPromotedPrice() == 38000);

        testHighestLowestPeek("ms", 64000, "m3", 35000, "ms", 64000, stack);
    }

    public void testHighestLowestPeek(String highestPricedModel, int highestPrice,
                                      String lowestPricedModel, int lowestPrice,
                                      String peekModel, int peekModelPrice,
                                      Assign2.PromotedCarModelStack stack) {
        assertTrue(stack.getHighestPricedPromotedModel().getModel().equalsIgnoreCase(highestPricedModel));
        assertTrue(stack.getHighestPricedPromotedModel().getPromotedPrice() == highestPrice);
        assertTrue(stack.getLowestPricedPromotedModel().getModel().equalsIgnoreCase(lowestPricedModel));
        assertTrue(stack.getLowestPricedPromotedModel().getPromotedPrice() == lowestPrice);

        assertTrue(stack.peek().getModel().equalsIgnoreCase(peekModel));
        assertTrue(stack.peek().getPromotedPrice() == peekModelPrice);
    }

    private void assertTrue(boolean condition){
        if(!condition)
            throw new RuntimeException("FAILED");
    }
}

public class Main {
    public static void main(String[] ags){
        Assign2.PromotedCarModelStack stack = new Assign2.PromotedCarModelStack();

        stack.push("m3", 35000);
        System.out.println(stack.pop().getModel());
        System.out.println("highest price " + stack.getHighestPricedPromotedModel().getModel());
        /*
        System.out.println("push m3");
        stack.push("m3", 35000);
        String highest = stack.getHighestPricedPromotedModel().getModel();
        System.out.println("highest price " + highest);
        System.out.println("lowest price " + stack.getLowestPricedPromotedModel().getModel());

        System.out.println("push ms");
        stack.push("ms", 64000);
        System.out.println("highest price " + stack.getHighestPricedPromotedModel().getModel());
        System.out.println("lowest price " + stack.getLowestPricedPromotedModel().getModel());

        System.out.println("push my");
        stack.push("my", 32000);
        System.out.println("highest price " + stack.getHighestPricedPromotedModel().getModel());
        System.out.println("lowest price " + stack.getLowestPricedPromotedModel().getModel());

        System.out.println("pop " + stack.pop().getModel());
        System.out.println("highest price " + stack.getHighestPricedPromotedModel().getModel());
        System.out.println("lowest price " + stack.getLowestPricedPromotedModel().getModel());

        System.out.println("pop " + stack.pop().getModel());
        System.out.println("highest price " + stack.getHighestPricedPromotedModel().getModel());
        System.out.println("lowest price " + stack.getLowestPricedPromotedModel().getModel());

        System.out.println("pop " + stack.pop().getModel());
        System.out.println("highest price " + stack.getHighestPricedPromotedModel().getModel());
        System.out.println("lowest price " + stack.getLowestPricedPromotedModel().getModel());
         */
    }
}

public class Main extends Assign1{

    public static void main(String[] args) {
        System.out.println("STARTING");

        String[] carInventory = {"mx","my","mz","mx","mx","my","mz","mz","mx","my","mz"};
        String[] promotionOrder = {"mx","my","mz"};

        Assign1 test = new Assign1();
        test.sortCarInventory(carInventory, promotionOrder);
        for(String car : carInventory){
            System.out.println(car);
        }

        System.out.println("FINISHED");
    }
}

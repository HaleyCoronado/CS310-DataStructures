import java.util.ArrayList;
import java.util.LinkedList;

class Main {

    public static void main(String[] args) {
        int eid = 100;

        Assign3.Employee head = new Assign3.Employee(eid++);
        addDescendants(head, eid, 3, 0);

        System.out.println(head.employeeID);
        for(Assign3.Employee e : head.directReports){
            System.out.print(e.employeeID + "                                                                                                         ");
        }
        System.out.println();
        for(Assign3.Employee e : head.directReports){
            for(Assign3.Employee e2 : e.directReports){
                System.out.print(e2.employeeID + "-------------------------------- ");
            }
        }
        System.out.println();
        for(Assign3.Employee e : head.directReports){
            for(Assign3.Employee e2 : e.directReports){
                for(Assign3.Employee e3 : e2.directReports) {
                    System.out.print(e3.employeeID + "-------- ");
                }
            }
        }
        System.out.println();
        for(Assign3.Employee e : head.directReports){
            for(Assign3.Employee e2 : e.directReports){
                for(Assign3.Employee e3 : e2.directReports) {
                    for(Assign3.Employee e4 : e3.directReports) {
                        System.out.print(e4.employeeID + " ");
                    }
                }
            }
        }
        System.out.println();


        test(head, 108, 145, 100);
        test(head, 108, 107, 102);
        test(head, 136, 137, 132);
        test(head, 105, 106, 102);
        test(head, 102, 105, 102);
        test(head, 108, 117, 105);
        test(head, 111, 112, 108);
        test(head, 111, 300, 111);
        test(head, 111, 144, 100);
        test(head, 111, 221, 100);

        System.out.println("done");
    }

    public static void test(Assign3.Employee head, int e1, int e2, int expected){
        testEx(head, e1, e2, expected);
        testEx(head, e2, e1, expected);
    }

    public static void testEx(Assign3.Employee head, int e1, int e2, int expected){
        Assign3.Employee e = Assign3.findClosestSharedManager(head, e1, e2);
        System.out.println("Shared manager(" + expected + ") = " + e.employeeID);
        assertTrue(e.employeeID == expected);
    }

    public static void assertTrue(boolean condition){
        if(!condition)
            throw new RuntimeException("TEST FAILED");
    }
    public static void log(String msg){
        System.out.println(msg);
    }

    public static int addDescendants(Assign3.Employee e, int eid, int level, int currentLevel){

        for(int i = 0; i < 3; i++){
            eid++;

            e.addDirectReport(eid);
        }

        if(currentLevel < level) {
            for (Assign3.Employee dr : e.getDirectReports()) {
                eid = addDescendants(dr, eid, level, currentLevel+1);
            }
        }
        return eid;
    }

    public static void test1(){
        /*
         * Construct the following organization chart for testing
         *                1
         *           /    \    \
         *           2    3    4
         *          / \  / \   \
         *          5 6  7 8   9
         *         /   \       \
         *         10  11      12

         */
        Assign3.Employee head = new Assign3.Employee(1, new int[] {2, 3, 4});
        Assign3.Employee e2 = head.getDirectReports().get(0);
        e2.addDirectReports(new int[] {5, 6});
        Assign3.Employee e3 = head.getDirectReports().get(1);
        e3.addDirectReports(new int[] {7, 8});
        Assign3.Employee e4 = head.getDirectReports().get(2);
        e4.addDirectReport(9);

        Assign3.Employee e5 = e2.getDirectReports().get(0);
        e5.addDirectReport(10);
        Assign3.Employee e6 = e2.getDirectReports().get(1);
        e6.addDirectReport(11);
        Assign3.Employee e9 = e4.getDirectReports().get(0);
        e9.addDirectReport(12);

        Assign3.Employee e = Assign3.findClosestSharedManager(head, 2, 3);
        System.out.println("Shared manager(1) = " + e.employeeID);

        e = Assign3.findClosestSharedManager(head, 2, 1);
        System.out.println("Shared manager(1) = " + e.employeeID);

        e = Assign3.findClosestSharedManager(head, 9, 12);
        System.out.println("Shared manager(9) = " + e.employeeID);

        e = Assign3.findClosestSharedManager(head, 8, 7);
        System.out.println("Shared manager(3) = " + e.employeeID);

        e = Assign3.findClosestSharedManager(head, 10, 6);
        System.out.println("Shared manager(2) = " + e.employeeID);

        e = Assign3.findClosestSharedManager(head, 8, 12);
        System.out.println("Shared manager(1) = " + e.employeeID);

        System.out.println("----------------");

/*
        e = Assign3.findClosestSharedManagerPartB(head, 2, 3);
        System.out.println("Shared manager(1) = " + e.employeeID);

        e = Assign3.findClosestSharedManagerPartB(head, 2, 1);
        System.out.println("Shared manager(1) = " + e.employeeID);

        e = Assign3.findClosestSharedManagerPartB(head, 9, 12);
        System.out.println("Shared manager(9) = " + e.employeeID);

        e = Assign3.findClosestSharedManagerPartB(head, 8, 12);
        System.out.println("Shared manager(1) = " + e.employeeID);

        e = Assign3.findClosestSharedManagerPartB(
                Assign3.findEmployee(head, 6),
                Assign3.findEmployee(head, 12)
        );
        System.out.println("Shared manager(1) = " + e.employeeID);


        e = Assign3.findClosestSharedManagerPartB(
                Assign3.findEmployee(head, 5),
                Assign3.findEmployee(head, 11)
        );
        System.out.println("Shared manager(2) = " + e.employeeID);
        */

    }


}

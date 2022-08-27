/*

public class Main {

    public static void main(String[] args) {
	    Assign3Test a = new Assign3Test();
	    a.buildOrgChart();

	    Assign3.Employee head = new Assign3.Employee(1, new int[] {2, 3, 4});
		head.directReports.get(0).addDirectReports(new int[]{5, 6});

		System.out.println("head: " + a.head.getEmployeeID());
	    boolean bool = Assign3.isEmployeePresentInOrg(a.head, 6);
	    System.out.println(bool);

	    int level = Assign3.findEmployeeLevel(a.e2, 12, 0);
	    System.out.println("level: " + level);

		Assign3.Employee e = Assign3.findClosestSharedManager(a.head, 4, 10);
		if(e == null){
			System.out.println("Closest Manager: null");
		} else {
			System.out.println("Closest Manager: " + e.getEmployeeID());
		}
		Assign3.Employee e2 = Assign3.findClosestSharedManager(a.head, 1, 8);
		if(e == null){
			System.out.println("Closest Manager: null");
		} else {
			System.out.println("Closest Manager: " + e2.getEmployeeID());
		}

		int numManBetwn = Assign3.findNumOfManagersBetween(a.head, 12, 18);
		System.out.println("Managers between: " + numManBetwn);

		a.TestCase1();
    }
}

 */
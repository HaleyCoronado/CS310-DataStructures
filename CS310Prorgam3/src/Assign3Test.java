
public class Assign3Test {
	Assign3.Employee head = null;
	Assign3.Employee e2 = null;
	
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
	public void buildOrgChart() {
		head = new Assign3.Employee(1, new int[] {2, 3, 4});
		/*
		System.out.println("ID: " + head.getEmployeeID());
		for (Assign3.Employee n : head.getDirectReports()){
			System.out.print(n.getEmployeeID() + " ");
		}
		System.out.println();
		 */

		e2 = head.getDirectReports().get(0);
		e2.addDirectReports(new int[] {5, 6});
		/*
		System.out.println("ID: " + e2.getEmployeeID());
		for (Assign3.Employee n : e2.getDirectReports()){
			System.out.print(n.getEmployeeID() + " ");
		}
		System.out.println();
		 */

		Assign3.Employee e3 = head.getDirectReports().get(1);
		e3.addDirectReports(new int[] {7, 8});
		/*
		System.out.println("ID: " + e3.getEmployeeID());
		for (Assign3.Employee n : e3.getDirectReports()){
			System.out.print(n.getEmployeeID() + " ");
		}
		System.out.println();
		 */

		Assign3.Employee e4 = head.getDirectReports().get(2);
		e4.addDirectReport(9);
		/*
		System.out.println("ID: " + e4.getEmployeeID());
		for (Assign3.Employee n : e4.getDirectReports()){
			System.out.print(n.getEmployeeID() + " ");
		}
		System.out.println();
		 */
		
		Assign3.Employee e5 = e2.getDirectReports().get(0);
		e5.addDirectReport(10);
		/*
		System.out.println("ID: " + e5.getEmployeeID());
		for (Assign3.Employee n : e5.getDirectReports()){
			System.out.print(n.getEmployeeID() + " ");
		}
		System.out.println();
		 */


		Assign3.Employee e6 = e2.getDirectReports().get(1);
		e6.addDirectReport(11);
		/*
		System.out.println("ID: " + e6.getEmployeeID());
		for (Assign3.Employee n :e6.getDirectReports()){
			System.out.print(n.getEmployeeID() + " ");
		}
		System.out.println();
		 */

		Assign3.Employee e9 = e4.getDirectReports().get(0);
		e9.addDirectReport(12);
		/*
		System.out.println("ID: " + e9.getEmployeeID());
		for (Assign3.Employee n : e9.getDirectReports()){
			System.out.print(n.getEmployeeID() + " ");
		}
		System.out.println();
		 */
	}
	
	//@Test
	public void TestCase1() {
		//build an org chart for testing
		buildOrgChart();
		
		//Test - searching an employee ID
		//Positive case:
		assertTrue(Assign3.isEmployeePresentInOrg(head, 11));
		//Negative case:
		assertTrue(!Assign3.isEmployeePresentInOrg(head, 15));
		
		//Test - finding the level of an employee
		//Positve case:
		assertTrue(Assign3.findEmployeeLevel(head, 8, 0) == 2);
		//Negative case:
		assertTrue(Assign3.findEmployeeLevel(head, 15, 0) == Integer.MIN_VALUE);
				
		//Test - finding closest shared manager
		//Positive cases:
		Assign3.Employee m_e2_e6 = Assign3.findClosestSharedManager(head, 2, 6);
		assertTrue(m_e2_e6.getEmployeeID() == 2);
		Assign3.Employee m_e10_e11 = Assign3.findClosestSharedManager(head, 10, 11);
		assertTrue(m_e10_e11.getEmployeeID() == 2);
		Assign3.Employee m_e10_e12 = Assign3.findClosestSharedManager(head, 10, 12);
		assertTrue(m_e10_e12.getEmployeeID() == 1);
		//Negative cases:
		Assign3.Employee m_e10_e15 = Assign3.findClosestSharedManager(head, 10, 15);
		assertTrue(m_e10_e15.getEmployeeID() == 10);
		Assign3.Employee m_e17_e11 = Assign3.findClosestSharedManager(head, 17, 11);
		assertTrue(m_e17_e11.getEmployeeID() == 11);
		Assign3.Employee m_e15_e16 = Assign3.findClosestSharedManager(head, 15, 16);
		assertTrue(m_e15_e16 == null);
		
		//Test - finding the number of managers between two employees.
		//Positive cases:
		assertTrue(Assign3.findNumOfManagersBetween(head, 2, 6) == 0);
		assertTrue(Assign3.findNumOfManagersBetween(head, 10, 8) == 4);
		//Negative cases:
		assertTrue(Assign3.findNumOfManagersBetween(head, 10, 15) == Integer.MIN_VALUE);

		System.out.println("PASSED ALL TESTS");
		
	}

	private void assertTrue(boolean condition){
		if(!condition)
			throw new RuntimeException("FAILED");
	}
}

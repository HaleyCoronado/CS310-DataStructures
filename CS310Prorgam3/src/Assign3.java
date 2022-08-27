/**
 * I the undersigned promise that the attached assignment is my own work. While I was
 * free to discuss ideas with others, the work contained is my owm. I recognize that
 * should this not be the case, I will be subject to penalties as outlined in the course
 * syllabus.
 * Haley Coronado 824874564
 */

/**
 * Program #3
 * CS310
 * June 23rd, 2021
 * @author Haley Coronado
 * @redId 824874564
 */

import java.util.*;

class Assign3 {
	//An employee class to store an organization chart (tree) node
	static class Employee {
		int employeeID;
		public ArrayList<Employee> directReports = null;

		//Constructor for instantiating an employee instance with an employee id.
		//Assume employee ID argument is unique among all employee IDs.
		Employee(int id) {
			this.employeeID = id;
			this.directReports = new ArrayList<Employee>();
		}

		//Constructor for instantiating an employee instance with an employee id
		//and all direct reports to this employee.
		Employee(int id, int[] dReports) {
			this.employeeID = id;
			if(dReports != null && dReports.length > 0) {
				this.directReports = new ArrayList<Employee>(dReports.length);
				for (int d : dReports) {
					this.directReports.add(new Employee(d));
				}
			} else {
				this.directReports = new ArrayList<Employee>();
			}

		}

		//Add a direct report to the employee
		//Assume employee ID argument is unique among all employee IDs.
		public void addDirectReport(int e_id) {
			if(directReports != null) {
				directReports.add(new Employee(e_id));
			}
		}

		//Add a group of direct reports to the employee
		public void addDirectReports(int[] ids) {
			if(ids != null) {
				for (int i : ids) {
					this.directReports.add(new Employee(i));
				}
			}
		}

		public int getEmployeeID() {
			return employeeID;
		}

		public ArrayList<Employee> getDirectReports() {
			return directReports;
		}
	}

	/**
	* Check if an employee is present in an organization chart.
	*
	* @param  head the head / root Employee of the organization chart
	* @param  e_id the employee id being searched
	* @return      true or false
	* @see
	*/
	public static boolean isEmployeePresentInOrg(Employee head, int e_id) {
		// Write your recursive implementation here

		// Important: Your implementation needs to use the recursive approach
		// as required in the assignment 3 prompt to avoid penalties.

		// base case 1: empty organization chart
		//check if head is null
		if (head.equals(null)){ return false; }

		// base case 2: if the employee is found, return true
		//check if head is employee
		if (head.getEmployeeID() == e_id){ return true; }

		// search employee from each child of the head
		for (Employee e : head.getDirectReports()){
			if (e.getEmployeeID() == e_id){
				return true;
			}
			if(e.getDirectReports().isEmpty()){ continue; } else {
				if(isEmployeePresentInOrg(e, e_id)){
					return true;
				} else {
					continue;
				}
			}
		}

		// return true if the employee is found in one of the child subtree
		return false;
	}

	/**
	* Find the level of an employee in an organization chart / tree.
	*
	* <p>
	* The head / root of the org chart has a level of 0, children of the head have
	* a level of head plus 1, and so on and so forth...
	*
	* <p>
	* Assumption: e_id is unique among all employee IDs
	*
	* @param  head      the head / root Employee of the organization chart
	* @param  e_id      the employee id being searched
	* @param  headLevel the level of the head employee of the organization
	* @return 			level of the employee in the org chart
	* 					returns Integer.MIN_VALUE if e_id is not present
	* @see
	*/
	public static int findEmployeeLevel(Employee head, int e_id, int headLevel) {
		// Write your recursive implementation here.

		// Important: Your implementation needs to use recursive the approach
		// as required in the assignment 3 prompt to avoid penalties.

		// base case 1: the employee is found, returns the employee level
		if (head.getEmployeeID() == e_id){ return headLevel; }

		// base case 2: empty organization chart
		if (head.getDirectReports().isEmpty()){ return Integer.MIN_VALUE; }

		// search employee from each child from the head
		headLevel++;
		for (Employee e : head.getDirectReports()){
			if (e.getEmployeeID() == e_id){
				return headLevel;
			}
			if (isEmployeePresentInOrg(e, e_id)){
				return findEmployeeLevel(e, e_id, headLevel);
			}
			//int x = findEmployeeLevel(e, e_id, headLevel);
			//if (x != Integer.MIN_VALUE){
			//	return x;
			}
			return Integer.MIN_VALUE;
		}

	/**
	* Find the closest shared manager of two employees e1 and e2.
	*
	* <p>
	* There are two possible organizational relationships between two employees in the org chart:
	* case 1: e1 or e2 is a manager of the other employee;
	* case 2: e1 or e2 is not a manager of the other employee, they have at least one shared manager
	*
	* Employee 1 is a manager of employee 2 if employee 1 is an ancestor of employee 2 in the organization chart
	*
	* <p>
	* Assumption: e1_id and e2_id are unique among all employee IDs
	*
	* @param  head  the head / root Employee of the organization chart
	//* @param  e1_id id of employee 1 being searched
	//* @param  e2_id id of employee 2 being searched
	* @return 		closest shared manager in the org chart between employee e1 and employee e2
	*               if e1 is present and e2 is not, returns e1
	*               if e2 is present and e1 is not, returns e2
	*               if neither e1 or e2 is present, returns null
	* @see
	*/
	public static Employee findClosestSharedManager(Employee head, int e1_id, int e2_id) {
		// Write your recursive implementation here

		// Important: Your implementation needs to use the recursive approach
		// as required in the assignment 3 prompt to avoid penalties.

		// base case 1: empty organization chart
		if(head == null){ return head; }

		// base case 2: either e1_id or e2_id is the same as the head / root
		if (head.getEmployeeID() == e1_id || head.getEmployeeID() == e2_id){ return head; }

		// Traverse through each direct report of the head to find where e1 is and where e2 is
		// recursively check if e1_id or e2_id exists in one of the child trees from the head / root

		// check that both employees are managed by head
		if(isEmployeePresentInOrg(head, e1_id) && isEmployeePresentInOrg(head, e2_id)){
			Employee closestSharedManager = head;
			for (Employee e : head.getDirectReports()){
				if(isEmployeePresentInOrg(e, e1_id) && isEmployeePresentInOrg(e, e2_id)){
					closestSharedManager = findClosestSharedManager(e, e1_id, e2_id);
					if (closestSharedManager == null){
						return e;
					}
				}
			}
			return closestSharedManager;
		}

		// head does not manage both employees
		// determine which is not present
		if(isEmployeePresentInOrg(head, e1_id)){
			return findEmployee(head, e1_id);
		}
		if(isEmployeePresentInOrg(head, e2_id)){
			return findEmployee(head, e2_id);
		}

		// return null
		return null;
	}

	private static Employee findEmployee(Employee head, int eID){
		if(head.getEmployeeID() == eID){
			return head;
		}
		for(Employee e : head.getDirectReports()){
			if(isEmployeePresentInOrg(e, eID)){
				if(e.getEmployeeID() == eID){
					return e;
				} else {
					return findEmployee(e, eID);
				}
			}
		}
		return null;
	}

	/**
	* Calculate the number of managers between employee e1 and employee e2.
	*
	* <p>
	* The number of managers between employee e1 and employee e2 can be calculated by:
	* 	number of edges between employee 1 and closest shared manager +
	* 	number of edges between employee 2 and closest shared manager - 1
	*
	* <p>
	* Assumption: e1_id and e2_id are unique among all employee IDs
	*
	* @param  head  the head / root Employee of the organization chart
	* @param  e1_id id of employee 1 being searched
	* @param  e2_id id of employee 2 being searched
	* @return 		number of managers between employee e1 and employee e2
	*               returns Integer.MIN_VALUE if either e1 or e2 is not present in the chart
	* @see
	*/
	public static int findNumOfManagersBetween(Employee head, int e1_id, int e2_id) {
		// Write your implementation here. You do NOT need to use recursive approach here.

		// Use the above functions wherever you need to implement this function.

		// Continue only if both employee nodes e1_id and e2_id are in the org chart tree
		// otherwise, return Integer.MIN_VALUE;
		if (!isEmployeePresentInOrg(head, e1_id) || !isEmployeePresentInOrg(head, e2_id)){
			return Integer.MIN_VALUE;
		}

		int managersBetweenE1;
		int managersBetweenE2;
		int total;
		// find closest shared manager
		Employee closestSharedManager = findClosestSharedManager(head, e1_id, e2_id);
		// check if closest shared manager is e1 or e2
		if (closestSharedManager.getEmployeeID() == e1_id){
			return findEmployeeLevel(closestSharedManager, e2_id, 0) - 1;
		}
		if (closestSharedManager.getEmployeeID() == e2_id){
			return findEmployeeLevel(closestSharedManager, e1_id, 0) - 1;
		} else {
			// find e1 level and e2 level with closest manager as head
			int e1Level = findEmployeeLevel(closestSharedManager, e1_id, 0);
			int e2Level = findEmployeeLevel(closestSharedManager, e2_id, 0);
			// The number of managers between employee e1 and employee e2 can be calculated by:
			// number of edges between e1_id and closest shared manager +
			// number of edges between e2_id and closest shared manager - 1
			total = e1Level + e2Level - 1;
		}

		// return total
		return total;
	}




}
/**
 * I the undersigned promise that the attached assignment is my own work. While I was
 * free to discuss ideas with others, the work contained is my owm. I recognize that
 * should this not be the case, I will be subject to penalties as outlined in the course
 * syllabus.
 * Haley Coronado 824874564
 */

/**
 * Program #4
 * CS310
 * June 29th, 2021
 * @author Haley Coronado
 * @redId 824874564
 */

import java.util.*;

// You must NOT use any global variables 

class Assign4 {
	
	// A city class to store a city vertex / node in the city graph
	// You must NOT change this class
	
	static class CityNode {
		String city;
		List<String> directRoutedCities;
		List<String> reachableCities;
		
		public CityNode(String city) {
			this.city = city;
			directRoutedCities = new ArrayList<String>();
			reachableCities = new ArrayList<String>();
		}
	}
	
	
	/**
	* <p>
	* Part A 
	* ---------------------------------------------------------------------------------------
	* For each city in a city list, find the list of reachable cities starting from the city 
	* following the FSD routes, and sort the cities in the descending order based on the 
	* number of their reachable cities.	
	* 
	* Required specifications - 
	*
	* Given a list of cities, and a list of one-way routes from one city to another 
	* that have been tested for the FSD:
    *
	* 1) Create a graph with each node in the graph as an instance of the CityNode class,
	*    the graph can use any Java collection by your choice.
    *
	* 2) Populate the direct routes information to each CityNode's directRoutedCities collection.
    *
	* 3) For each city node in the graph, use Depth First Search algorithm to find all reachable 
	*    cities starting from the city following the FSD routes and store those reachable cities to 
	*    the CityNode's reachableCities collection. 
    *
    *    IMPORTANT: The reachable cities must include the starting city itself.  
    *	
    *    Note: The FSD route to reach a city can be direct from the starting city but does NOT 
	*          have to direct. The FSD can drive from the starting city and stop at several cities 
	*          before reaching the destination city, all cities including the starting city and 
	*          the destination city along the path would be counted as reachable cities from 
	*          the city where the FSD starts.
    *
	* 4) Sort the cities in the descending order based on the number of their reachable cities,
	*    so that after sorting, starting from the first city in the sorted order, the FSD can 
	*    reach the greatest number of destination cities following the given one-way routes. 
	*
	* 5) You must use a RECURSIVE algorithm to implement the Depth First Search part to find
	*    all reachable cities from a starting city given the FSD routes, using an iterative 
	*    approach would result in a 30% penalty to your assignment 4 autograding grade.	
	*
	* 6) You may add necessary helper functions as needed. Follow the comments for hints.
	* 
	* Assumptions - 
	* 1) Each city is represented by a unique two-letter code like "SD", "LA", 
	*    "SF", "SJ", "NY", etc.
    * 2) Each one-way FSD route is represented by a pair of city codes; for example, 
	*    route {"SD", "LA"} means FSD can drive one-way from San Diego (SD) to 
	*    Los Angeles (LA). 
	*
	* <p>
	* Part B
	* ---------------------------------------------------------------------------------------
	* Show the upper bound of the time complexity of this function would be O(c^2 + c * r) 
	* where:
	* c is the number of cities
	* r is the number of direct routes between cities
	* 
	* ---------------------------------------------------------------------------------------
	* @param  cities  a list of cities with each city identified by a two letter code
	* @param  fsd_routes  pairs of one-way FSD routes with each one-way FSD route represented
	*                 by a pair of city codes; for example, route {"SD", "LA"} means FSD 
	*                 can drive one-way from San Diego (SD) to Los Angeles (LA).
    *
	*                 NOTE: examples of routes are { {"SD", "LA"},
    *                                                {"LA", "SJ"},
    *                                                {"SJ", "SF"}
    *                                              }   
    *                       refer to Assign4Test.java for more examples.	
	*
	* @return 		  A list of CityNode in the descending order based on the number of their 
	*                 reachable cities following the FSD routes
	
	* @see         
	*/
	
	public static List<CityNode> citiesToDeployFSDSortedByNumOf_Its_ReachableCities(
		List<String> cities, 
		List<List<String>> fsd_routes) {
		
		// Write your implementation here.
		
		// Follow the steps in the specification above to implement. 
		
		// You may want to implement each step in the above specification in 
		// a separate function.
		
		// Think which data structure would give you the best search ability
		// by using a key. You would like to use a Java collection to store
		// the graph of city nodes, so that given a city code,
		// you can find the corresponding CityNode object instantaneously.

		// create graph
		HashMap<String, CityNode> nodes = createGraph(cities, fsd_routes);

		// fill reachableCities for each city
		for(String city : nodes.keySet()){
			// add node to reachableCities
			CityNode node = nodes.get(city);
			node.reachableCities.add(city);
			// add node to visited cities
			Set<String> visited = new HashSet<>();
			visited.add(city);
			// create a set to keep track of reachable cities
			Set<String> reachable = processCityNode(nodes, city, new HashSet<String>(), visited);
			// add cities in reachable to reachableCities
			for(String s : reachable){
				// check for duplicates
				if(!node.reachableCities.contains(s))
					node.reachableCities.add(s);
			}
		}

		// sort nodes
		ArrayList<CityNode> sortedCities = sort(nodes);

		// You may want to use a separate function to implement the 
		// recursive Depth-First-Search algorithm for finding all reachable cities
		// starting from a city using its direct routes to other cities, and their
		// connected cities, and so on and so forth until all cities along
		// reachable paths are traversed.
		
		// A suggested separate recursive function for the DFS part could be:
		// void depthFirstSearchReachableCities(
		//      cityGraph, // a collection of a Java collection type  
		//      String startingCity, 
		//      List<String> reachableCities, // list of cities to add reachable cities along the recursive call  
		//      Set<String> visitedCities); // list of cities to track if a city is already visited along DFS search

		return sortedCities;
	}

	private static Set<String> processCityNode(Map<String, CityNode> map, String current, Set<String> cities, Set<String> visited){
		CityNode city = map.get(current);
		for(String direct : city.directRoutedCities){
			cities.add(direct);
			if(!visited.contains(direct)) {
				visited.add(direct);
				cities.addAll(processCityNode(map, direct, cities, visited));
			}
		}
		return cities;
	}

	private static ArrayList<CityNode> sort(HashMap<String, CityNode> map){
		ArrayList<CityNode> list = new ArrayList<>();
		for(String city : map.keySet()){
			CityNode node = map.get(city);
			int r = node.reachableCities.size();
			if(list.size() == 0){
				list.add(node);
			}
			else {
				int index = 0;
				boolean added = false;
				for (CityNode n : list) {
					if (node.reachableCities.size() > n.reachableCities.size()) {
						list.add(index, node);
						added = true;
						break;
					}
					index++;
				}
				if(!added){
					list.add(node);
				}
			}
		}
		return list;
	}

	public static HashMap<String, CityNode> createGraph(List<String> cities, List<List<String>> fsd_routes) {
		HashMap<String, CityNode> nodes = new HashMap<>();
		for (String cityName : cities) {
			nodes.put(cityName, new CityNode(cityName));
		}

		for (List<String> route : fsd_routes) {
			String start = route.get(0);
			String dest = route.get(1);

			CityNode node = nodes.get(start);
			if (!node.directRoutedCities.contains(dest)) {
				node.directRoutedCities.add(dest);
			}
		}
		return nodes;
	}

}
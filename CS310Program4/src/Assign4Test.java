import java.util.*;

//import static org.junit.Assert.*;
//import org.junit.Test;

public class Assign4Test {
	
	public void myTest() {
		List<String> cities = new ArrayList<>(Arrays.asList("LAX", "SFO", "OAK", "SJO",
				"JFK", "SEA", "SAN"));
		List<List<String>> routes = new ArrayList<>();
		routes.add(new ArrayList<String>(Arrays.asList("SFO", "OAK")));
		routes.add(new ArrayList<String>(Arrays.asList("SFO", "SJO")));
		routes.add(new ArrayList<String>(Arrays.asList("OAK", "SEA")));
		routes.add(new ArrayList<String>(Arrays.asList("SJO", "LAX")));
		routes.add(new ArrayList<String>(Arrays.asList("SEA", "JFK")));
		routes.add(new ArrayList<String>(Arrays.asList("LAX", "SAN")));

		List<Assign4.CityNode> sortedCities =
				Assign4.citiesToDeployFSDSortedByNumOf_Its_ReachableCities(cities, routes);
	}

	//@Test
	public void TestCase1() {
		List<String> CITIES_1 = new ArrayList<String>(Arrays.asList(
				"SD", "LA", "SK", "IV", "JL", "SF", 
				"DL", "HT", "OD", "NH", "BV", "SJ", "BU"));
		List<List<String>> routes = new ArrayList<List<String>>();
		
		/*
		 *    SD ---> DL <--------|         
		 *    ^                   |
		 *    |                   |
		 *    OD <--- JL <--------|--|
		 *                        |  |
		 *    BV <---             |  |
		 *    --->  LA ---> BU    |  |
		 *          ^             |  |
		 *          |             |  |
		 *  SJ ---> SK ---> IV ---|  |
		 *                           |
		 *  <---------------         |
		 *  SF ---> HT ---> NH ------|
		 * */
		routes.add(new ArrayList<String>(Arrays.asList("JL", "OD")));
		routes.add(new ArrayList<String>(Arrays.asList("OD", "SD")));
		routes.add(new ArrayList<String>(Arrays.asList("SD", "DL")));
		routes.add(new ArrayList<String>(Arrays.asList("BV", "LA")));
		routes.add(new ArrayList<String>(Arrays.asList("LA", "BV")));
		routes.add(new ArrayList<String>(Arrays.asList("LA", "BU")));
		routes.add(new ArrayList<String>(Arrays.asList("SK", "IV")));
		routes.add(new ArrayList<String>(Arrays.asList("SK", "LA")));
		routes.add(new ArrayList<String>(Arrays.asList("SJ", "SK")));
		
		routes.add(new ArrayList<String>(Arrays.asList("IV", "DL")));
		
		routes.add(new ArrayList<String>(Arrays.asList("SF", "HT")));
		routes.add(new ArrayList<String>(Arrays.asList("HT", "NH")));
		routes.add(new ArrayList<String>(Arrays.asList("NH", "SF")));
		routes.add(new ArrayList<String>(Arrays.asList("NH", "JL")));
		
		List<Assign4.CityNode> cities = 
				Assign4.citiesToDeployFSDSortedByNumOf_Its_ReachableCities(CITIES_1, routes);
		
		//cities returned from the above call are sorted according to 
		//the descending order of the size of its reachableCities
		
		//FSD starting from City "HT" can reach 7 cities including itself, 
		//they are [HT, NH, SF, JL, OD, SD, DL]
		assertTrue(cities.get(0).reachableCities.size() == 7); 
		
		//FSD starting from City "SF" can reach 7 cities including itself, 
		//they are [SF, HT, NH, JL, OD, SD, DL]
		assertTrue(cities.get(1).reachableCities.size() == 7); 
		
		//FSD starting from City "SJ" can reach 7 cities including itself, 
		//they are [SJ, SK, IV, DL, LA, BV, BU]
		assertTrue(cities.get(2).reachableCities.size() == 7);
		
		//FSD starting from City "NH" can reach 7 cities including itself, 
		//they are [NH, SF, HT, JL, OD, SD, DL]
		assertTrue(cities.get(3).reachableCities.size() == 7);
		
		//FSD starting from City "SK" can reach 6 cities including itself, 
		//they are [SK, IV, DL, LA, BV, BU]
		assertTrue(cities.get(4).reachableCities.size() == 6);
		
		//FSD starting from City "JL" can reach 4 cities including itself, 
		//they are [JL, OD, SD, DL]
		assertTrue(cities.get(5).reachableCities.size() == 4);
		
		//FSD starting from City "BV" can reach 3 cities including itself, 
		//they are [BV, LA, BU]
		assertTrue(cities.get(6).reachableCities.size() == 3);
		
		//FSD starting from City "LA" can reach 3 cities including itself, 
		//they are [LA, BV, BU]
		assertTrue(cities.get(7).reachableCities.size() == 3);
		
		//FSD starting from City "DL" can reach 1 cities including itself, 
		//they are [DL]
		assertTrue(cities.get(11).reachableCities.size() == 1);
				
	}
	private void assertTrue(boolean condition){
		if(!condition)
			throw new RuntimeException("FAILED");
	}
}

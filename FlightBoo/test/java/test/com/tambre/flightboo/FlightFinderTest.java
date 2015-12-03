package test.com.tambre.flightboo;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import com.tambre.flightboo.Airport;
import com.tambre.flightboo.FlightFinder;
import com.tambre.flightboo.FlightNetwork;
import com.tambre.flightboo.Route;

public class FlightFinderTest {
	
	FlightNetwork flightNetwork;

	@Before
	public void setUp() throws Exception {
		flightNetwork = FlightNetwork.getInstance();
		flightNetwork.prepareNetwork(new File("resources/input.txt"));
	}

	@Test
	public void testSearchShortestRouteHA()
	{
		try {
			FlightFinder ff = new FlightFinder(new Airport("h"), new Airport("a"));
			LinkedList<Route> shortest = ff.searchShortestRoute();
			System.out.println("[testSearchShortestRouteHA]: shortest: " + shortest);
			assertNotNull(shortest);
			assertEquals(2, shortest.size());
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
			fail("Exception Occurred: " + e.getMessage());
		}
	}
	
	@Test
	public void testSearchShortestRouteHE()
	{
		try {
			FlightFinder ff = new FlightFinder(new Airport("h"), new Airport("e"));
			LinkedList<Route> shortest = ff.searchShortestRoute();
			System.out.println("[testSearchShortestRouteHE]: shortest: " + shortest);
			assertNotNull(shortest);
			assertEquals(3, shortest.size());
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
			fail("Exception Occurred: " + e.getMessage());
		}
	}

	@Test
	public void testSearchShortestRouteHF()
	{
		try {
			FlightFinder ff = new FlightFinder(new Airport("h"), new Airport("f"));
			LinkedList<Route> shortest = ff.searchShortestRoute();
			System.out.println("[testSearchShortestRouteHF]: shortest: " + shortest);
			assertNotNull(shortest);
			assertEquals(3, shortest.size());
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
			fail("Exception Occurred: " + e.getMessage());
		}
	}
	
	@Test
	public void testSearchShortestRouteHH()
	{
		try {
			FlightFinder ff = new FlightFinder(new Airport("h"), new Airport("h"));
			LinkedList<Route> shortest = ff.searchShortestRoute();
			System.out.println("[testSearchShortestRouteHH]: shortest: " + shortest);
			assertNull(shortest);
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
			fail("Exception Occurred: " + e.getMessage());
		}
	}
	

	@Test
	public void testSearchFlightsHE() {
		
		try 
		{
			FlightFinder ff = new FlightFinder(new Airport("h"), new Airport("e"));
			ArrayList<LinkedList<Route>> options = ff.searchFlights();
			
			assertNotNull(options);
			assertEquals(2, options.size());
			
			for (LinkedList<Route> linkedList : options) {
				System.out.println("[testSearchFlightsHE]: route: " + linkedList);
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace(System.out);
			fail("Exception Occurred: " + e.getMessage());
		}
	}

	@Test
	public void testSearchFlightsHA() {
		
		try 
		{
			FlightFinder ff = new FlightFinder(new Airport("h"), new Airport("a"));
			ArrayList<LinkedList<Route>> options = ff.searchFlights();
			
			assertNotNull(options);
			assertEquals(1, options.size());
			
			for (LinkedList<Route> linkedList : options) {
				System.out.println("[testSearchFlightsHA]: route: " + linkedList);
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace(System.out);
			fail("Exception Occurred: " + e.getMessage());
		}
	}

	@Test
	public void testSearchFlightsHH() {
		
		try 
		{
			FlightFinder ff = new FlightFinder(new Airport("h"), new Airport("h"));
			ArrayList<LinkedList<Route>> options = ff.searchFlights();
			
			assertNotNull(options);
			assertEquals(0, options.size());
			
			for (LinkedList<Route> linkedList : options) {
				System.out.println("[testSearchFlightsHH]: route: " + linkedList);
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace(System.out);
			fail("Exception Occurred: " + e.getMessage());
		}
	}

	@Test
	public void testSearchFlightsHG() {
		
		try 
		{
			FlightFinder ff = new FlightFinder(new Airport("h"), new Airport("g"));
			ArrayList<LinkedList<Route>> options = ff.searchFlights();
			
			assertNotNull(options);
			assertEquals(0, options.size());
			
			for (LinkedList<Route> linkedList : options) {
				System.out.println(linkedList);
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace(System.out);
			fail("Exception Occurred: " + e.getMessage());
		}
	}

	@Test
	public void testSearchFlightsBE() {
		
		try 
		{
			FlightFinder ff = new FlightFinder(new Airport("b"), new Airport("e"));
			ArrayList<LinkedList<Route>> options = ff.searchFlights();
			
			assertNotNull(options);
			assertEquals(2, options.size());
			
			for (LinkedList<Route> linkedList : options) {
				System.out.println("[testSearchFlightsBE]: route: " + linkedList);
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace(System.out);
			fail("Exception Occurred: " + e.getMessage());
		}
	}

	@Test
	public void testSearchFlightsEB() {
		
		try 
		{
			FlightFinder ff = new FlightFinder(new Airport("e"), new Airport("b"));
			ArrayList<LinkedList<Route>> options = ff.searchFlights();
			
			assertNotNull(options);
			assertEquals(1, options.size());
			
			for (LinkedList<Route> linkedList : options) {
				System.out.println("[testSearchFlightsEB]: route: " + linkedList);
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace(System.out);
			fail("Exception Occurred: " + e.getMessage());
		}
	}

	@Test
	public void testSearchFlightsED() {
		
		try 
		{
			FlightFinder ff = new FlightFinder(new Airport("e"), new Airport("d"));
			ArrayList<LinkedList<Route>> options = ff.searchFlights();
			for (LinkedList<Route> linkedList : options) {
				System.out.println("[testSearchFlightsED]: route: " + linkedList);
			}
			
			
			assertNotNull(options);
			assertEquals(1, options.size());
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace(System.out);
			fail("Exception Occurred: " + e.getMessage());
		}
	}
	
	
	@Test
	public void testSearchFlightsBF() {
		
		try 
		{
			FlightFinder ff = new FlightFinder(new Airport("b"), new Airport("f"));
			ArrayList<LinkedList<Route>> options = ff.searchFlights();
			
			assertNotNull(options);
			assertEquals(1, options.size());
			
			for (LinkedList<Route> linkedList : options) {
				System.out.println("[testSearchFlightsBF]: route: " + linkedList);
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace(System.out);
			fail("Exception Occurred: " + e.getMessage());
		}
	}
	
}

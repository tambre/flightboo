package com.tambre.flightboo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

/**
 * Singleton to create and store Network of Flights
 * 
 * @author tambre
 */
public class FlightNetwork {
	
	private static FlightNetwork flightNetwork;
	
	private HashMap<Airport, LinkedHashSet<Route>> graph;
	
	private FlightNetwork()
	{
		graph = new HashMap<Airport, LinkedHashSet<Route>>();
	}
	
	public static synchronized FlightNetwork getInstance()
	{
		if (flightNetwork == null)
		{
			flightNetwork = new FlightNetwork();
		}
		return flightNetwork;
	}
	
	/**
	 * 
	 * @param input expects input such as FlightName,From,To,hour,min
	 * @throws Exception
	 */
	public synchronized void prepareNetwork(File input) throws Exception
	{
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(input);
			br = new BufferedReader(fr);
			String line; 
			
			while ((line = br.readLine())!= null)
			{
				StringTokenizer st = new StringTokenizer(line, ",");
				String name = st.nextToken();
				Airport from = new Airport(st.nextToken());
				Airport to = new Airport(st.nextToken());
				int hour = Integer.parseInt(st.nextToken());
				int min = Integer.parseInt(st.nextToken());

				Route r = new Route(from, to);
				FlightConnection fc = new FlightConnection(name, hour, min);
				r.addConnection(fc);
				addRoute(r);
			}
		} 
		finally 
		{
			if (br!= null) br.close();
		}
	}

	private synchronized void addRoute(Route route)
	{
		/**
		 * Check if the origin is already added
		 */
		if (!graph.containsKey(route.getOrigin()))
		{
			LinkedHashSet<Route> conns = new LinkedHashSet<Route>();
			graph.put(route.getOrigin(), conns);
		}
		
		/**
		 * Check if the destination is already added
		 */
		if (!graph.containsKey(route.getDestination()))
		{
			LinkedHashSet<Route> conns = new LinkedHashSet<Route>();
			graph.put(route.getDestination(), conns);
		}
		
		/**
		 * check if the route is already there
		 */
		LinkedHashSet<Route> rSet = graph.get(route.getOrigin());
		
		if (rSet.contains(route))
		{
			for (Iterator<Route> iterator = rSet.iterator(); iterator.hasNext();) {
				Route r = (Route) iterator.next();
				r.addConnections(route.getConnections());
			}
		}
		else
		{
			graph.get(route.getOrigin()).add(route);
		}
	}
	
	public LinkedHashSet<Route> getConnections(Airport from)
	{
		if (graph.isEmpty())
		{
			throw new IllegalStateException("Flight Network is not initialized");
		}
		return graph.get(from);
	}
	
}
 
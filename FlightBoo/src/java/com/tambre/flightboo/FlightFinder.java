package com.tambre.flightboo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/**
 * Class to traverse from one destination to another destination
 * 
 * @author tambre
 *
 */
public class FlightFinder {
	
	private Airport origin;
	private Airport destination;
	private LinkedList<Route> path; 
	ArrayList<LinkedList<Route>> flightOptions;
	
	public FlightFinder(Airport origin, Airport destination) throws Exception
	{
		this.origin = origin;
		this.destination = destination;
		this.path = new LinkedList<Route>(); 
		this.flightOptions = new ArrayList<LinkedList<Route>>();
	}
	
	public Airport getOrigin() {
		return origin;
	}

	public void setOrigin(Airport origin) {
		this.origin = origin;
	}

	public Airport getDestination() {
		return destination;
	}

	public void setDestination(Airport destination) {
		this.destination = destination;
	}

	private void initializeSearch()
	{
		this.path = new LinkedList<Route>();
		this.flightOptions = new ArrayList<LinkedList<Route>>();
	}
	
	public ArrayList<LinkedList<Route>> searchFlights()
	{
		HashSet<Airport> visitedNodes = new HashSet<Airport>();
		initializeSearch();
		getFlights(this.origin, this.destination, visitedNodes);
		return this.flightOptions;
	}
	
	/**
	 * Assumption is shortest route = least number of hops
	 * 
	 * @return
	 */
	public LinkedList<Route> searchShortestRoute()
	{
		HashSet<Airport> visitedNodes = new HashSet<Airport>();
		LinkedList<Route> shortest = null;
		initializeSearch();
		getFlights(this.origin, this.destination, visitedNodes);

		if (!flightOptions.isEmpty())
		{
			shortest = flightOptions.get(0);
			for (int i = 0; i < flightOptions.size(); i++) 
			{
				LinkedList<Route> option = flightOptions.get(i);
				if (shortest.size() > option.size())
				{
					shortest = option;
				}
			}
		}
		return shortest;
	}
	
	private void getFlights(Airport from, Airport to, HashSet<Airport> visitedNodes)
	{
		if (visitedNodes.contains(from))
		{
			/**
			 * Looks like we have gone in a circle... Step out and dont visit again...
			 *
			 */
			return;
		}
		visitedNodes.add(from);
		
		/**
		 * Get connections from origin node in the network
		 */
		LinkedHashSet<Route> originConns = FlightNetwork.getInstance().getConnections(from);
		
		/**
		 * No connections from origin. No point progressing
		 */
		if (originConns == null || originConns.isEmpty())
		{
			return;
		}
			
		/**
		 * 
		 */
		for (Iterator<Route> iterator = originConns.iterator(); iterator.hasNext();) {

			Route route = (Route) iterator.next();
			path.add(route);
			if (route.getDestination().equals(to))
			{
				/**
				 * Destination reached...
				 */
				@SuppressWarnings("unchecked")
				LinkedList<Route> p = (LinkedList<Route>)path.clone();
				flightOptions.add(p);
			}
			else
			{
				/**
				 * reCURSE of the black pearl
				 */
				getFlights(route.getDestination(), to, visitedNodes);
			}
			
			if (!path.isEmpty())
			{
				while (true)
				{
					if (!path.isEmpty() && path.removeLast().equals(route))
					{
						break;
					}
				}
			}
		}
	}
	


}

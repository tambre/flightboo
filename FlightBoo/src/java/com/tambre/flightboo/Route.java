package com.tambre.flightboo;

import java.io.Serializable;
import java.util.HashSet;

/**
 * Route is a link between 2 airports. Route can have one or more connections
 *  
 * BOM -> DEL 08:00 AI101
 * @author tambre
 *
 */
public class Route implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4569138435356837232L;
	private Airport destination;
	private Airport origin;
	
	private HashSet<FlightConnection> connections;
	
	
	public Route(Airport from, Airport to) {
		this.destination = to;
		this.origin = from;
		connections = new HashSet<FlightConnection>();
	}
	
	public Airport getDestination() {
		return destination;
	}
	public void setDestination(Airport to) {
		this.destination = to;
	}
	public Airport getOrigin() {
		return origin;
	}
	public void setOrigin(Airport from) {
		this.origin = from;
	}

	public HashSet<FlightConnection> getConnections() {
		return connections;
	}

	public void setConnections(HashSet<FlightConnection> connections) {
		this.connections = connections;
	}
	
	public void addConnection (FlightConnection fc)
	{
		this.connections.add(fc);
	}
	
	public void addConnections(HashSet<FlightConnection> connections)
	{
		this.connections.addAll(connections);
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Route))
			return false;
		Route other = (Route) obj;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		return true;
	}

	public String toString()
	{
		return this.origin + " -> " + this.destination + connections;
	}

}

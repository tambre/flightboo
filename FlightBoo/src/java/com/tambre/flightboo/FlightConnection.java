package com.tambre.flightboo;

/**
 * Holds the details of connection on a given route.
 * 
 *  e.g. AI001 (08:20) where 08:20 is the hour & minute the flight takes from origin.
 * It can be extended to add more properties to the connection. e.g. Operator
 * 
 * @author tambre
 *
 */
public class FlightConnection {
	
	String flightNumber;
	int hour;
	int min;

	public FlightConnection(String flightNumber, int hour, int min) {
		
		this.flightNumber = flightNumber;
		this.hour = hour;
		this.min = min;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}
	
	public String toString()
	{
		return flightNumber + "(" + hour + ":" + min + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((flightNumber == null) ? 0 : flightNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightConnection other = (FlightConnection) obj;
		if (flightNumber == null) {
			if (other.flightNumber != null)
				return false;
		} else if (!flightNumber.equals(other.flightNumber))
			return false;
		return true;
	}
	
	

}

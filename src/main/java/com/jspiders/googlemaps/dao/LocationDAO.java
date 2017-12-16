package com.jspiders.googlemaps.dao;

import java.util.Random;

public class LocationDAO {

	/**
	 * @Assume that we're getting the data from DB
	 * 
	 * @param location
	 * @return
	 */
	public LocationDataDTO getlocationData(String location) {
		LocationDataDTO data = new LocationDataDTO();
		data.setLocation(location);
		data.setLongitude(new Random().nextDouble());
		data.setLatitude(new Random().nextDouble());
		data.setFullAddress(location + ", Some_city, Some_country");
		return data;
	}
}

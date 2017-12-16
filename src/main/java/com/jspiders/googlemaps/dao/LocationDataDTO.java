package com.jspiders.googlemaps.dao;


public class LocationDataDTO {
	
	private String location;
	
	private double longitude;
	
	private double latitude;

	private String fullAddress;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	@Override
	public String toString() {
		return "LocationDataDTO [location=" + location + ", longitude=" + longitude + ", latitude=" + latitude
				+ ", fullAddress=" + fullAddress + "]";
	}
}

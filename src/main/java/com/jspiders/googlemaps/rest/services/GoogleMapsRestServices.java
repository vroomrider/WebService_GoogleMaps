package com.jspiders.googlemaps.rest.services;

import javax.annotation.Generated;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.jspiders.googlemaps.dao.LocationDAO;
import com.jspiders.googlemaps.dao.LocationDataDTO;

/**
 * @RootResourceClass
 * @author hacker
 *
 */
@Path("/geocode")
public class GoogleMapsRestServices {

	/**
	 * @ResourceMethodDesignator
	 * @param location
	 * @return
	 */
	@GET
	@Path("/xml")
	@Produces(MediaType.APPLICATION_XML)
	public LocationDataDTO getlocationDataInXml(@QueryParam("address") String location) {
		LocationDAO dao = new LocationDAO();
		return dao.getlocationData(location);
	}

	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public LocationDataDTO getlocationDataInJSON(@QueryParam("address") @DefaultValue("ZZZ") String location) {
		LocationDAO dao = new LocationDAO();
		return dao.getlocationData(location);
	}

	@GET
	@Path("/text")
	@Produces(MediaType.TEXT_PLAIN)
	public String getlocationDataInTEXT(@QueryParam("address") String location) {
		LocationDAO dao = new LocationDAO();
		return dao.getlocationData(location).toString();
	}

	// @POST
	// @Path("/json")
	// @Produces(MediaType.APPLICATION_JSON)
	// public LocationDataDTO getlocationDataInJSON(@FormParam("address") String
	// location,
	// @HeaderParam("myName") String name) {
	// System.err.println("header name: " + name);
	// LocationDAO dao = new LocationDAO();
	// return dao.getlocationData(location);
	// }
}

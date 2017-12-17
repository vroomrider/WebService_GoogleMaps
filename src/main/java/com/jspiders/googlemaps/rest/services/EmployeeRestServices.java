package com.jspiders.googlemaps.rest.services;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.jspiders.googlemaps.dao.Employee;
import com.jspiders.googlemaps.dao.EmployeeDAO;

@Path("/employee")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeRestServices {

	/**
	 * @Everytime the constructor gets executed... It is a costly Operation hence
	 *            better to use a PARAMETERISED constructor!
	 */
	// public EmployeeRestServices() {
	// System.err.println(" Inside EmployeeRestService ");
	// }
	public EmployeeRestServices(int i) {
		System.err.println(" Inside EmployeeRestService ");
	}

	/**
	 * 1. Using @BeanParam
	 * 
	 * @param employee
	 * @return
	 */
	@PUT
	@Path("/createbean")
	@Produces(MediaType.APPLICATION_JSON)
	public HashSet<Employee> createEmployeeUsingBeanParam(@BeanParam Employee employee) {
		EmployeeDAO dao = new EmployeeDAO();
		return dao.createEmployeeUsingBeanParam(employee);
	}

	/**
	 * 2. Using @BeanParam And Returning the Employee Object
	 * 
	 * @param employee
	 * @return
	 */
	@PUT
	@Path("/createbeanproduces")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public HashSet<Employee> createEmployeeUsingBeanParamAndReturnObject(@BeanParam Employee employee) {
		EmployeeDAO dao = new EmployeeDAO();
		return dao.createEmployeeUsingBeanParamAndProducesObject(employee);
	}

	/**
	 * 3. Using @BeanParam And Returning the Employee Object and @Consumes and
	 * use @XmlRootElement on top of Employee class Otherwise it will not work
	 * 
	 * @param employee
	 * @return
	 */
	@PUT
	@Path("/createusingjson")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	public HashSet<Employee> createEmployeeUsingJSON(Employee employee) {
		EmployeeDAO dao = new EmployeeDAO();
		return dao.createEmployeeUsingBeanParamAndProducesObject(employee);
	}

	@GET
	@Path("/createcookie")
	public Response createCookie() {
		NewCookie cookie = new NewCookie("name", "pradeep");
		ResponseBuilder builder = Response.ok("Cookie Created!", MediaType.TEXT_PLAIN);
		return builder.cookie(cookie).build();
	}

	@GET
	@Path("/readcookie")
	@Produces(MediaType.TEXT_HTML)
	public String readCookie(@CookieParam("name") String custId) {

		String msg = "Recieved Cookie is: " + custId;
		return msg;
	}

	@PUT
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean createEmployee(@FormParam("eid") int eid, @FormParam("fname") String fname,
			@FormParam("lname") String lname, @FormParam("designation") String designation,
			@FormParam("address1") String address1, @FormParam("address2") String address2,
			@FormParam("salary") double salary) {
		EmployeeDAO dao = new EmployeeDAO();
		Employee e = new Employee();
		e.setEid(eid);
		e.setFname(fname);
		e.setLname(lname);
		e.setDesignation(designation);
		e.setAddress1(address1);
		e.setAddress2(address2);
		e.setSalary(salary);
		return dao.createEmployee(e);
	}

	@DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean deleteEmployee(@FormParam("eid") int eid) {
		EmployeeDAO dao = new EmployeeDAO();
		return dao.deleteEmployee(dao.readEmployee(eid));
	}

	@GET
	@Path("read")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee readEmployee(@QueryParam("eid") int eid) {
		EmployeeDAO dao = new EmployeeDAO();
		return dao.readEmployee(eid);
	}

	@GET
	@Path("readall")
	@Produces(MediaType.APPLICATION_JSON)
	public Set<Employee> readEmployees() {
		EmployeeDAO dao = new EmployeeDAO();
		return dao.readEmployees();
	}

	@POST
	@Path("modify")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean modifyEmployee(@FormParam("eid") int eid, @FormParam("fname") String fname,
			@FormParam("lname") String lname, @FormParam("designation") String designation,
			@FormParam("address1") String address1, @FormParam("address2") String address2,
			@FormParam("salary") double salary) {
		EmployeeDAO dao = new EmployeeDAO();
		Employee e = new Employee();
		e.setEid(eid);
		e.setFname(fname);
		e.setLname(lname);
		e.setDesignation(designation);
		e.setAddress1(address1);
		e.setAddress2(address2);
		e.setSalary(salary);
		return dao.modifyEmployee(e);
	}

}

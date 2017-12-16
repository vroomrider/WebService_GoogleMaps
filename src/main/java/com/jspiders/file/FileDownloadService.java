package com.jspiders.file;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/fileservice")

public class FileDownloadService {

	@GET
	@Path("/download")
	@Produces(MediaType.TEXT_PLAIN)
	public Response download() {
		String filePath = "/home/hacker/MyAccount.txt";

		File f = new File(filePath);

		ResponseBuilder builder = Response.ok(f);
		builder.header("Content-Disposition", "attachment; filename=\"downloaded_MyAccunt.txt\"");

		Response resp = builder.build();
		return resp;
	}

	@GET
	@Path("/read")
	@Produces(MediaType.TEXT_PLAIN)
	public Response read() {
		String filePath = "/home/hacker/MyAccount.txt";

		File f = new File(filePath);

		ResponseBuilder builder = Response.ok(f);
		//builder.header("Content-Disposition", "attachment; filename=\"text_file_response.txt\"");

		Response resp = builder.build();
		return resp;
	}
	
	@GET
	@Path("/image")
	@Produces("image/png")
	public Response image() {
		String filePath = "/home/hacker/MyAccount.png";

		File f = new File(filePath);

		ResponseBuilder builder = Response.ok(f);
		//builder.header("Content-Disposition", "attachment; filename=\"text_file_response.txt\"");

		Response resp = builder.build();
		return resp;
	}
	
	@GET
	@Path("/pdf")
	@Produces("application/pdf")
	public Response pdf() {
		String filePath = "/home/hacker/MyAccount.pdf";

		File f = new File(filePath);

		ResponseBuilder builder = Response.ok(f);
		//builder.header("Content-Disposition", "attachment; filename=\"text_file_response.txt\"");

		Response resp = builder.build();
		return resp;
	}
	
	
}// End Of Class

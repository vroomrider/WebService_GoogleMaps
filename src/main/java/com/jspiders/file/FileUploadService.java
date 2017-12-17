package com.jspiders.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/uploadservice")
public class FileUploadService {

	/**
	 * @Must have the @Consumes with @MediaType.MULTIPART_FORM_DATA
	 * @param uploadedInput
	 * @param file
	 */
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public String upload(@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail) {
		String fileLocation = "/home/hacker/Web services/uploaddocs/" + fileDetail.getFileName();

		// Saving File
		try {
			FileOutputStream out;
			int read = 0;
			byte[] bytes = new byte[1024];
			out = new FileOutputStream(new File(fileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "File Uploaded Successfully..!";
	}
}

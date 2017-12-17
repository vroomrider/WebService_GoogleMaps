package com.jspiders.googlemaps.rest.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.media.multipart.MultiPartFeature;

import com.jspiders.file.FileUploadService;
import com.jspiders.googlemaps.rest.services.EmployeeRestServices;

/**
 * 
 * @author hacker @ApplicationPath("/api/2.0") @ApplicationPath("/api/3.0")
 * 
 *         Hence here By @Extending the @Application we can @control
 *         the @ObjectCreation &
 * @versioning of the application which is a very Advantageous factor...
 */
@ApplicationPath("/api/1.0")
public class GoogleRestApplication extends Application {

	/**
	 * @Empty Class is just to Route the class to the Application
	 */

	/**
	 * @Resources for FileUploading and FileDownloading
	 */
	@Override
	public Set<Class<?>> getClasses() {

		/**
		 * @only the mentioned classes are going to function in this version
		 */
		Set<Class<?>> resources = new HashSet();
		resources.add(MultiPartFeature.class);
		resources.add(FileUploadService.class);
		resources.add(EmployeeRestServices.class);
		return resources;
	}

	/**
	 * @Only a single Object/Instance of Application is being used instantiated
	 *       during server start-up and destroyed at garbage collection time.
	 */
	@Override
	public Set<Object> getSingletons() {
		Set<Object> ref = new HashSet<Object>();
		ref.add(new EmployeeRestServices(10));
		return super.getSingletons();
	}
}

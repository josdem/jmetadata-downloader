package org.jas.downloader.controller;

import java.io.File;
import java.io.IOException;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jas.downloader.bean.INSTALLER;
import org.jas.downloader.service.DownloaderService;
import org.jas.downloader.util.DownloaderContext;


@RequestScoped
@Path("/installer")
public class DownloaderController {
	
	@EJB
	private DownloaderService downloaderService; 
	
	@Inject
	private DownloaderContext downloaderContext;
	
	private Log log = LogFactory.getLog(getClass());
	
	@GET
	@Path("/getUbuntu")
	@Produces({ MediaType.APPLICATION_OCTET_STREAM })
	public Response getQuery(@Context HttpServletRequest request) throws IOException {
		log.info("DOWNLOADING Ubuntu");
		File file = downloaderContext.getFile(INSTALLER.Ubuntu);
        StreamingOutput stream = downloaderService.getStream(file);
        
        return Response.ok(stream).header("content-disposition","attachment; filename = "+file.getName()).build();
	} 

}

package org.jas.downloader.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


@RequestScoped
@Path("/jmetadata")
public class DownloaderController {
	
	private Log log = LogFactory.getLog(getClass());
	
	@GET
	@Path("/getFile")
	@Produces({ MediaType.APPLICATION_OCTET_STREAM })
	public Response getQuery(@Context HttpServletRequest request) throws IOException {
		log.info("DOWNLOADING");
        File file = new File("JMetadata.deb");
        log.info("file path:" + file.getAbsolutePath());
        StreamingOutput stream = null;
        final InputStream in = new FileInputStream(file);
        
        stream = new StreamingOutput() {
            public void write(OutputStream out) throws IOException, WebApplicationException {
                try {
                    int read = 0;
                        byte[] bytes = new byte[1024];

                        while ((read = in.read(bytes)) != -1) {
                            out.write(bytes, 0, read);
                        }
                } catch (Exception e) {
                    throw new WebApplicationException(e);
                }
            }
        };
        in.close();
        
        return Response.ok(stream).header("content-disposition","attachment; filename = "+file.getName()).build();
	} 

}

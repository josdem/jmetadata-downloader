package org.ubuntuone.music.authorizer.controller;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sun.jersey.api.view.Viewable;


@RequestScoped
@Path("/query")
public class AuthorizerController {
	
	private Log log = LogFactory.getLog(getClass());
	
	@GET
	@Path("/auth")
	@Produces(MediaType.TEXT_HTML)
	public Viewable getQuery(@QueryParam("oauth_verifier") String oauthVerifier) {
		log.info("oauthVerifier: " + oauthVerifier);
		return new Viewable("/index.jsp", oauthVerifier);	
	} 

}

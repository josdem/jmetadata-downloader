package org.jas.downloader.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ejb.Stateless;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;

@Stateless
public class DownloaderService {

	public StreamingOutput getStream(File file) throws FileNotFoundException {
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
        
        return stream;
	}

}

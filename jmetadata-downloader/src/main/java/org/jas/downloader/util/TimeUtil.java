package org.jas.downloader.util;

import java.util.Date;

import javax.inject.Named;

@Named
public class TimeUtil {

	public Long getTimestamp() {
		return new Date().getTime();
	}
	
}

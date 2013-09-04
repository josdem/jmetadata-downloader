package org.jas.downloader.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.jas.downloader.dao.DownloaderDao;
import org.jas.downloader.model.Counter;
import org.jas.downloader.util.TimeUtil;

@Stateless
public class DownloaderStats {
	
	@Inject
	private DownloaderDao downloaderDao;
	@Inject
	private TimeUtil timeUtil;

	public void saveRemoteAddress(String remoteAddress) {
		Counter counter = new Counter();
		counter.setRemoteAddress(remoteAddress);
		counter.setTimestamp(timeUtil.getTimestamp());
		downloaderDao.save(remoteAddress);
	}
	
	

}

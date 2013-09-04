package org.jas.downloader.util;

import java.io.File;

import javax.inject.Named;

import org.jas.downloader.bean.INSTALLER;

@Named
public class DownloaderContext {

	public File getFile(INSTALLER type) {

		switch (type) {
			case Ubuntu:
				return new File("installers/JMetadata.deb");
			case Mac:
				return new File("installers/JMetadata.dmg");
			case Windows:
				return new File("installers/JMetadata.exe");
			default:
				return null;
		}
	}

}

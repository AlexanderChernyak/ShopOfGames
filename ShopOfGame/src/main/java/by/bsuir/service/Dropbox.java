package by.bsuir.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;

import org.springframework.web.multipart.MultipartFile;

import com.dropbox.core.DbxAppInfo;
import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWebAuthNoRedirect;
import com.dropbox.core.DbxWriteMode;

public class Dropbox {

	private static final String APP_KEY = "livf297tdeye632";
	private static final String APP_SECRET = "0mqaanar1ppaq4j";
	private static final String ACCESS_TOKEN = "B4y_c7K8uncAAAAAAAAHcx9Ob8BhfFCdkrGOEljXv1LHX_HzhsAQ2bTw8fmcsR1U";

	private DbxClient client;

	public Dropbox() {

		DbxAppInfo appInfo = new DbxAppInfo(APP_KEY, APP_SECRET);

		DbxRequestConfig config = new DbxRequestConfig("JavaTutorial/1.0",
				Locale.getDefault().toString());
		DbxWebAuthNoRedirect webAuth = new DbxWebAuthNoRedirect(config, appInfo);
		client = new DbxClient(config, ACCESS_TOKEN);
	}
	
	

	public String UploadingFile(MultipartFile file) throws DbxException,
			IOException {
		FileInputStream inputStream = (FileInputStream) file.getInputStream();
		try {
			DbxEntry.File uploadedFile = client.uploadFile("/".concat(file.getOriginalFilename()),
					DbxWriteMode.add(), file.getSize(), inputStream);
			String url = client.createShareableUrl(uploadedFile.path);
			return url.substring(0, url.length()-5).concat("?raw=1");
		} finally {
			inputStream.close();
		}
	}

}

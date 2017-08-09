package site.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import site.Site;

/**
 * Dummy console logger for now 
 */
public class Logging {
	
	private static SimpleDateFormat format = new java.text.SimpleDateFormat("YYYY-MM-dd HH:mm:ss"); 
	private static Logger logger = LoggerFactory.getLogger(Site.class);
	
	public static void log(String input) {
		String timestamp = "[" + format.format(new Date()) + "]";
		logger.info(timestamp + " " + input);
	}
}

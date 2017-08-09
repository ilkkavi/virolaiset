package site.util;
import java.security.MessageDigest;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

public class Security {
	// MD5 checksum of security token
	private static final String CHECKSUM = "";
	private static final HexBinaryAdapter adapter = new HexBinaryAdapter();
	
	public static boolean validatePassword(String input) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(input.toLowerCase().getBytes("UTF-8"));
		} catch (Exception e) {
			// Unsupported encoding or No such algorithm
			return false;
		}
		String md5 = adapter.marshal(md.digest()).toLowerCase();
		return md5.equals(CHECKSUM);
	}
}

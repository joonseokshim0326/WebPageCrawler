package crawler;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author jssjp
 *2018. 6. 20.
 * manage url connection
 */
public class HttpConnentCont {

	/**
	 * @param address
	 * @return
	 */
	public static URLConnection connect(String address) {
		URLConnection conn = null;
		try {
			URL url = new URL(address);
			conn = url.openConnection();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return conn;
	}
}

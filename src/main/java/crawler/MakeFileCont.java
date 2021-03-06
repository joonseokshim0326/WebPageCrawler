package crawler;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;

/**
 * @author jssjp
 * 2018. 6. 20.
 * Create a html file.
 */
public class MakeFileCont {

	/**
	 * @param conn
	 * @param address
	 * @param savePath
	 */
	public static void makeFile(URLConnection conn, String address, String savePath) {
		OutputStream out = null;
		InputStream in = null;
		try {
			out = new BufferedOutputStream(new FileOutputStream(savePath + "\\" + "download.html"));
			in = conn.getInputStream();
			byte[] buffer = new byte[1024];
			int numRead;
			long numWritten = 0;
			while ((numRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, numRead);
				numWritten += numRead;
			}
			System.out.println(savePath + "\\" + "download.html" + "\t" + numWritten);
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException IOE) {
				
			}
		}

	}
}

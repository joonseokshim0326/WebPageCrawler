package crawler;

import java.net.URLConnection;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;


/**
 * @author jssjp
 * Make the contents of url into a file.
 *2018. 6. 20.
 */
public class WebPageCrawler {

	public static void main(String[] args) throws crawler.ArgsErrorException, ConnentException {
		URLConnection conn = null;
		Options options = new Options();
		CommandLineParser parser = new DefaultParser();
		options.addOption("u", true, "Url to download");
		options.addOption("d", true, "Path to save the file");
		try {
			CommandLine cmd = parser.parse( options, args);
			String address = cmd.getOptionValue("u");
			String savePath = cmd.getOptionValue("d");
			if(address == null) {
				throw new ArgsErrorException("Args are error. (URL value is null.)");
			}
			if(savePath == null) {
				throw new ArgsErrorException("Args are error. (The path to save is null.)");
			}
			conn = HttpConnentCont.connect(address);
			if(conn != null) {
				MakeFileCont.makeFile(conn, address, savePath);
			}else {
				throw new ConnentException("URL connection error.");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package genericLibraries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class contains reusable methods of java 
 * @author mahi
 */

public class JavaUtility {
	
	/**
	 * This method generates random number with the specified limit
	 * @param limit
	 * @return
	 */
	public int generateRandomNum(int limit)
	{
		Random random = new Random();
		return random.nextInt(limit);
	}
	
	/**
	 * this method generates current time
	 * @return
	 */
	
	public String getCurrentTime() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yy_hh_mm_ss");
		return sdf.format(date);
	}

}

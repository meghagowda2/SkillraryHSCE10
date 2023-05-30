package genericLibraries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 * this class provides java utility
 * @author MUKESH GOWDA
 *
 */

public class JavaUtility 
{
/**
 * This method generates random number within limit
 * @return
 */
	public int genarateRandomNum(int limit)
	{
		Random random = new Random();
return  random.nextInt(limit);
		
	}
/**
 * Ths method gets system time in specified format
 * @return
 */
	public String getCurrentTime()
	{
		Date date = new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("dd_MM_yy_hh_mm_sss");
		return sdf.format(date);
		
	}

}

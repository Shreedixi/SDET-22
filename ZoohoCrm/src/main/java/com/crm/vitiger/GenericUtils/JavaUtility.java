package com.crm.vitiger.GenericUtils;

import java.util.Date;
import java.util.Random;


/**
 * 
 * @author NAGASHREE
 *
 */
public class JavaUtility {

	/**
	 * This method is generate random number to void duplicates
	 * @return
	 */
	public static String getRandomData()
	{
		Random random=new Random();
		int ran=random.nextInt(1000);
		return ""+ran;
	}
	/**
	 * 
	 * @return
	 */
	public static String getCurrentDate()
	{
		Date date=new Date();
		String currentdate=date.toString();
		return currentdate;
	}
}

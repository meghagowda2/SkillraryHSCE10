package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ProprtiesUtility
/**
 * This class contains all reusable methods to perform operations on properties file
 */
{
	private Properties property;
	/**
	 * This method is used to initialize properties method
	 * @param filePath
	 */
	public void propertiesInIt(String filePath)
	{
		
		FileInputStream fis=null;
		try 
		{
			fis = new FileInputStream(filePath);
		} 
		catch (FileNotFoundException e)
		{
			
			e.printStackTrace();
		}
	 property= new Properties();
		
		try {
			property.load(fis);
		} 
		catch (IOException e)
		{
			
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to fetch data from properties file using key
	 * @param key
	 * @return
	 */
	public String readDataFromProperties(String key)
	{
		return property.getProperty(key);
		
	}
	/**
	 * This method is to write data to properties file
	 * 
	 * @param key
	 * @param value
	 * @param filePath
	 * @param comments
	 */
	public void writeToProperties(Object key, Object value, String filePath, String comments)
	{
	property.put(key, value);
	{
		
		FileOutputStream fos=null;
		try {
			fos = new FileOutputStream(filePath);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		try
		{
			property.store(fos, comments);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}




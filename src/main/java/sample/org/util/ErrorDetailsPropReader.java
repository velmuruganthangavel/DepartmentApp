/**
 * This program is proprietary to The Home Depot and is not to be reproduced,
 * used, or disclosed without permission of:
 * 
 *    The Home Depot
 *    2455 Paces Ferry Road, NW
 *    Atlanta, GA 30339-4024
 *
 *  FileName : ErrorDetailsPropReader
 */
package sample.org.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Provides method to get value from properties file using key.
 * 
 * @author RXS8616
 */
public final class ErrorDetailsPropReader
{

	private static ErrorDetailsPropReader errorDetailsPropReader;

	private static Properties properties;

	/**
	 * Private Constructor to avoid instantiating the class as all the methods in class are static.
	 */
	private ErrorDetailsPropReader()
	{
	}

	/**
	 * This method returns the instance of PONotesHandlerImpl class.
	 * 
	 * @return
	 */
	public static synchronized ErrorDetailsPropReader getInsatance()
	{
		if (errorDetailsPropReader == null)
		{
			// The singleton has not been initialized yet, enter a synchronized block
			errorDetailsPropReader = new ErrorDetailsPropReader();
		}

		return errorDetailsPropReader;
	}

	/**
	 * Static block to load properties from ErrorDetails.properties file.
	 * 
	 * @return
	 */
	static
	{
		FileInputStream inputStream = null;

		try
		{
			properties = new Properties();
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("ErrorDetails.properties"));
		}
		catch (IOException e)
		{
			//LogManager.stdErr("Error loading properties file. ", e);
		}
		finally
		{
			if (inputStream != null)
			{
				try
				{
					inputStream.close();
				}
				catch (IOException e)
				{
					//LogManager.stdErr("Error closing input stream after loading properties file. ", e);
				}
			}
		}

	}

	/**
	 * This method retrieves and returns the value from properties for a given key.
	 * 
	 * @param code
	 * @return
	 */
	public String getProperty(int code)
	{
		String codeStr = Integer.toString(code);

		if (properties != null && properties.containsKey(codeStr))
		{
			return properties.getProperty(codeStr);
		}
		else
		{
			//LogManager.stdErr("Value not found for key - " + code + ".");
			return "Error message not found for error code - " + code + ".";
		}
	}

	/**
	 * This method retrieves and returns the value from properties for a given key.
	 * 
	 * @param code
	 * @return
	 */
	public String getProperty(String code)
	{
		if (properties != null && properties.containsKey(code))
		{
			return properties.getProperty(code);
		}
		else
		{
			//LogManager.stdErr("Value not found for key - " + code + ".");
			return "Error message not found for error code - " + code + ".";
		}
	}

}

package sample.org.util;

import org.apache.log4j.Logger;


/**
 * Validation exception class which can be used to set errors using different parameters and log errors in a formatted way.
 * 
 * @author rxs8616
 */
public final class ValidationException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2880594360126782783L;

	private static final Logger LOGGER = Logger.getLogger(ValidationException.class);

	private final int code;

	private final String message;

	/**
	 * Constructor for error code.
	 * 
	 * @param errorCode
	 */
	public ValidationException(int errorCode)
	{
		super(getProperty(errorCode));

		this.code = errorCode;
		this.message = getProperty(errorCode);

		logError(this);
	}

	/**
	 * Constructor when technical error occurs.
	 * 
	 * @param developerMessage
	 */
	public ValidationException(String message)
	{
		super(message);

		this.code = 400;
		this.message = message;

		logError(this);
	}

	/**
	 * @return the code
	 */
	public int getCode()
	{
		return code;
	}

	/**
	 * @return the message
	 */
	@Override
	public String getMessage()
	{
		return message;
	}

	/**
	 * This method return the error message by invoking properties reader for a given error code.
	 * 
	 * @param errorCode
	 * 
	 * @return
	 */
	private static String getProperty(int errorCode)
	{
		ErrorDetailsPropReader errorDetailsPropReader = ErrorDetailsPropReader.getInsatance();
		return errorDetailsPropReader.getProperty(errorCode);
	}

	/**
	 * This method logs the error in a formatted manner.
	 * 
	 * @param ex
	 */
	private void logError(ValidationException ex)
	{
		// Log the error.
		LOGGER.error(buildErrorMsg(ex));
	}

	/**
	 * This method prepares error message from ValidationException.
	 * 
	 * @param ex
	 * 
	 * @return
	 */
	private String buildErrorMsg(ValidationException ex)
	{
		StringBuilder errorMsg = new StringBuilder();

		// Checking for null.
		if (ex != null)
		{
			errorMsg.append(System.getProperty("line.separator"));
			errorMsg.append("Error Code :: ");
			errorMsg.append(ex.code);
			errorMsg.append(System.getProperty("line.separator"));
			errorMsg.append("Error Message :: ");
			errorMsg.append(ex.message);
		}

		return errorMsg.toString();
	}

	/**
	 * Generates a String representation of the ValidationException Object.
	 * 
	 * @return String value of the object
	 */
	@Override
	public String toString()
	{
		return "ValidationException [code=" + code + ", message=" + message + "]";
	}

}

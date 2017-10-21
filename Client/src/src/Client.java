package src;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class that represents UDP DATA TRANSMISSION CLIENT
 */
public class Client {
	
	//----------------------------------------------------------
	// Attributes
	//----------------------------------------------------------
	
	/**
	 * Server IP
	 */
	private int serverIP;
	
	/**
	 * Port
	 */
	private int port;
	
	/**
	 * Number of objects to generate and send
	 */
	private int numberOfObjects;
	
	//----------------------------------------------------------
	// Constructor
	//----------------------------------------------------------
	
	/**
	 * Constructs a client
	 */
	public Client()
	{
		serverIP = 0;
		port = 0;
		numberOfObjects = 0;
	}
	
	//----------------------------------------------------------
	// Method
	//----------------------------------------------------------
	
	/**
	 * Returns server IP
	 * @return serverIP
	 */
	public int getServerIP()
	{
		return serverIP;
	}
	
	/**
	 * Replaces serverIP value with the value sent as parameter
	 * @param pServerIP
	 */
	public void setServerIP(int pServerIP)
	{
		serverIP = pServerIP;
	}
	
	/**
	 * Returns port
	 * @return port
	 */
	public int getPort()
	{
		return port;
	}
	
	/**
	 * Replaces port value with the value sent as parameter
	 * @param pPort
	 */
	public void setPort(int pPort)
	{
		port = pPort;
	}
	
	/**
	 * Returns number of objects to generate and send
	 * @return numberOfObjects
	 */
	public int getNumberOfObjects()
	{
		return numberOfObjects;
	}
	
	/**
	 * Replaces numberOfObjects value with the value that enters as parameter
	 * @param pNumberOfObjects
	 */
	public void setNumberOfObjects(int pNumberOfObjects)
	{
		numberOfObjects = pNumberOfObjects;
	}
	
	/**
	 * Sends message objects
	 */
	public void sendMessageObjects()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				
		for(int i=0; i<numberOfObjects; i++)
		{
			Date date = new Date();
			MessageObject mo = new MessageObject(i, dateFormat.format(date));
			System.out.println("Created message object " + i + " " + mo.getTimeStamp());;
		}
	}

}

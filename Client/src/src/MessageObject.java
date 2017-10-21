package src;

import java.util.Date;

/**
 * Class that represents an object to be sent to UDP Server
 */
public class MessageObject {
	
	//----------------------------------------------------------
	// Attributes
	//----------------------------------------------------------
	
	/**
	 * Sequence number of the object
	 */
	private int sequenceNumber;
	
	/**
	 * Timestamp of the object when it is sent
	 */
	private String timeStamp;
	
	//----------------------------------------------------------
	// Constructor
	//----------------------------------------------------------
	
	/**
	 * Constructs an Object
	 * @param pSequenceNumber Sequence number of the object
	 * @param pTimeStamp Timestamp of the object
	 */
	public MessageObject(int pSequenceNumber, String pTimeStamp)
	{
		sequenceNumber = pSequenceNumber;
		timeStamp = pTimeStamp;
	}
	
	//----------------------------------------------------------
	// Methods
	//----------------------------------------------------------
	
	/**
	 * Returns the sequence number of the object
	 * @return sequenceNumber
	 */
	public int getSequenceNumber()
	{
		return sequenceNumber;
	}
	
	/**
	 * Replaces the value of sequenceNumber with the value sent as parameter
	 * @param pSequenceNumber
	 */
	public void setSequenceNumber(int pSequenceNumber)
	{
		sequenceNumber = pSequenceNumber;
	}
	
	/**
	 * Returns the Timestamp of the object
	 * @return timeStamp
	 */
	public String getTimeStamp()
	{
		return timeStamp;
	}
	
	/**
	 * Replaces the value of timeStamp with the value sent as parameter
	 * @param pTimeStamp
	 */
	public void setTimeStamp(String pTimeStamp)
	{
		timeStamp = pTimeStamp;
	}

}

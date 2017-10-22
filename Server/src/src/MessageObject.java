package src;

import java.io.Serializable;
import java.util.Date;

/**
 * Class that represents an object to be sent to UDP Server
 */
public class MessageObject implements Serializable{
	
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
	private long timeStamp;
	
	//----------------------------------------------------------
	// Constructor
	//----------------------------------------------------------
	
	/**
	 * Constructs an Object
	 * @param pSequenceNumber Sequence number of the object
	 * @param pTimeStamp Timestamp of the object
	 */
	public MessageObject(int pSequenceNumber, long pTimeStamp)
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
	public long getTimeStamp()
	{
		return timeStamp;
	}
	
	/**
	 * Replaces the value of timeStamp with the value sent as parameter
	 * @param pTimeStamp
	 */
	public void setTimeStamp(long pTimeStamp)
	{
		timeStamp = pTimeStamp;
	}

}

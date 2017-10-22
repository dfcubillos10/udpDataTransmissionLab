package src;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class that represents UDP DATA TRANSMISSION CLIENT
 */
public class Client {

	// ----------------------------------------------------------
	// Attributes
	// ----------------------------------------------------------
	/**
	 * Datagram socket
	 */
	public DatagramSocket Socket;
	/**
	 * Server IP
	 */
	private String serverIP;

	/**
	 * Port
	 */
	private int port;

	/**
	 * Number of objects to generate and send
	 */
	private int numberOfObjects;

	// ----------------------------------------------------------
	// Constructor
	// ----------------------------------------------------------

	/**
	 * Constructs a client
	 */
	public Client() {
		serverIP = "0";
		port = 0;
		numberOfObjects = 0;
	}

	// ----------------------------------------------------------
	// Method
	// ----------------------------------------------------------

	/**
	 * Returns server IP
	 * 
	 * @return serverIP
	 */
	public String getServerIP() {
		return serverIP;
	}

	/**
	 * Replaces serverIP value with the value sent as parameter
	 * 
	 * @param pServerIP
	 */
	public void setServerIP(String pServerIP) {
		serverIP = pServerIP;
	}

	/**
	 * Returns port
	 * 
	 * @return port
	 */
	public int getPort() {
		return port;
	}

	/**
	 * Replaces port value with the value sent as parameter
	 * 
	 * @param pPort
	 */
	public void setPort(int pPort) {
		port = pPort;
	}

	/**
	 * Returns number of objects to generate and send
	 * 
	 * @return numberOfObjects
	 */
	public int getNumberOfObjects() {
		return numberOfObjects;
	}

	/**
	 * Replaces numberOfObjects value with the value that enters as parameter
	 * 
	 * @param pNumberOfObjects
	 */
	public void setNumberOfObjects(int pNumberOfObjects) {
		numberOfObjects = pNumberOfObjects;
	}

	/**
	 * Sends message objects
	 */
	public void sendMessageObjects() {
//		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		for (int i = 0; i < numberOfObjects; i++) {
			//Date date = new Date();
			//MessageObject mo = new MessageObject(i, dateFormat.format(date));
			createAndListenSocket(i);
			System.out.println("sent object "+(i+1))
			//System.out.println("Created message object " + i + " " + mo.getTimeStamp());
			;
		}
	}

	public void createAndListenSocket(int secuencia) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			
			Socket = new DatagramSocket();
			//InetAddress IPAddress = InetAddress.getByName("localhost");
			InetAddress IPAddress = InetAddress.getByName(serverIP);
			byte[] incomingData = new byte[1024];
			MessageObject object = new MessageObject(secuencia, System.currentTimeMillis());			
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			ObjectOutputStream os = new ObjectOutputStream(outputStream);
			os.writeObject(object);
			byte[] data = outputStream.toByteArray();
			DatagramPacket sendPacket = new DatagramPacket(data, data.length, IPAddress, port);
			Socket.send(sendPacket);
			System.out.println("Message sent from client");
			DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);
			Socket.receive(incomingPacket);
			String response = new String(incomingPacket.getData());
			System.out.println("Response from server:" + response);
			Thread.sleep(2000);

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

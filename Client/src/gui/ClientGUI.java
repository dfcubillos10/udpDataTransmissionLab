package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import src.Client;

/**
 * ClientGUI
 */
public class ClientGUI extends JFrame {
	
	//----------------------------------------------------------
	// Attributes
	//----------------------------------------------------------
	
	/**
	 * Reference to client logic
	 */
	private Client client;
	
	/**
	 * Reference to parameters panel
	 */
	private ParametersPanel parametersPanel;
	
	//----------------------------------------------------------
	// Constructor
	//----------------------------------------------------------
	
	/**
	 * Constructs ClientGUI
	 */
	public ClientGUI()
	{
		client = new Client();
		
		setTitle("Client");
		setSize(290, 350);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		parametersPanel = new ParametersPanel(this);
		add(parametersPanel, BorderLayout.NORTH);
		
		setVisible(true);
	}
	
	//----------------------------------------------------------
	// Methods
	//----------------------------------------------------------
	
	/**
	 * Returns server IP from client logic
	 * @return serverIP
	 */
	public String getServerIP()
	{
		return String.valueOf(client.getServerIP());
	}
	
	/**
	 * Returns port from client logic
	 * @return
	 */
	public String getPort()
	{
		return String.valueOf(client.getPort());
	}
	
	/**
	 * Returns numberOfObjects from client logic
	 * @return numberOfObjects
	 */
	public String getNumberOfObjects()
	{
		return String.valueOf(client.getNumberOfObjects());
	}
	
	/**
	 * Updates parameters
	 */
	public void updateParameters()
	{
		String newServerIP = parametersPanel.getServerIP();
		String newPort = parametersPanel.getPort();
		String newNumberOfObjects = parametersPanel.getNumberOfObjects();
		
		//Updates parameters in Client
		client.setServerIP(Integer.parseInt(newServerIP));
		client.setPort(Integer.parseInt(newPort));
		client.setNumberOfObjects(Integer.parseInt(newNumberOfObjects));
		
		parametersPanel.setServerIP(newServerIP);
		parametersPanel.setPort(newPort);
		parametersPanel.setNumberOfObjects(newNumberOfObjects);
		
		parametersPanel.clearTextFields();
	}
	
	/**
	 * Sends message objects
	 */
	public void sendMessageObjects()
	{
		client.sendMessageObjects();
	}
	
	//----------------------------------------------------------
	// Main
	//----------------------------------------------------------
	
	/**
	 * Main method of Client project
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println("----------------------------------------------------");
		System.out.println("UDP DATA TRANSMISSION CLIENT");
		System.out.println("----------------------------------------------------");
		
		Client client = new Client();
		
		//Sets number of objects to be created
		client.setNumberOfObjects(10);
		
		ClientGUI clientGUI = new ClientGUI();
	}
}

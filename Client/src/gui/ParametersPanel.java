package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Parameters panel
 */
public class ParametersPanel extends JPanel implements ActionListener {
	
	//----------------------------------------------------------
	// Constants
	//----------------------------------------------------------
	
	/**
	 * UPDATE
	 */
	public final static String UPDATE = "Update";
	
	/**
	 * SEND_MESSAGE_OBJECTS
	 */
	public final static String SEND_MESSAGE_OBJECTS = "Send";
	
	//----------------------------------------------------------
	// Attributes
	//----------------------------------------------------------
	
	/**
	 * Reference to ClientGUI
	 */
	private ClientGUI gui;
	
	/**
	 * Server IP label
	 */
	private JLabel serverIPLabel;
	
	/**
	 * Port label
	 */
	private JLabel portLabel;
	
	/**
	 * Number of objects label
	 */
	private JLabel numberOfObjectsLabel;
	
	/**
	 * Server IP Text Field
	 */
	private JTextField serverIPTextField;
	
	/**
	 * Port Text Field
	 */
	private JTextField portTextField;
	
	/**
	 * Number of objects Text Field
	 */
	private JTextField numberOfObjectsTextField;
	
	/**
	 * Update button
	 */
	private JButton updateButton;
	
	/**
	 * Parameters values title label
	 */
	private JLabel parametersValuesTitleLabel;
	
	/**
	 * Server IP parameter title label
	 */
	private JLabel serverIPParameterTitleLabel;
	
	/**
	 * Port parameter title label
	 */
	private JLabel portParameterTitleLabel;

	/**
	 * Number of objects paramater title label
	 */
	private JLabel numberOfObjectsParameterTitleLabel;
	
	/**
	 * Server IP parameter value label
	 */
	private JLabel serverIPParameterValueLabel;
	
	/**
	 * Port parameter value label
	 */
	private JLabel portParameterValueLabel;
	
	/**
	 * Number of objects parameter value label
	 */
	private JLabel numberOfObjectsParameterValueLabel;
	
	/**
	 * Send message objects button
	 */
	private JButton sendMessageObjectsButton;
	
	//----------------------------------------------------------
	// Constructor
	//----------------------------------------------------------
	
	/**
	 * Constructs Parameters panel
	 * @param pGUI
	 */
	public ParametersPanel(ClientGUI pGUI)
	{
		gui = pGUI;
		
		setLayout(new GridLayout(10,2));
		setPreferredSize(new Dimension(0, 200));
		
		TitledBorder border = BorderFactory.createTitledBorder("Parameters");
		setBorder(border);
		
		serverIPLabel = new JLabel("Server IP");
		serverIPTextField = new JTextField();
		serverIPTextField.setEditable(true);
		serverIPTextField.setBackground(Color.WHITE);
		
		portLabel = new JLabel("Port");
		portTextField = new JTextField();
		portTextField.setEditable(true);
		portTextField.setBackground(Color.WHITE);
		
		numberOfObjectsLabel = new JLabel("Number of objects");
		numberOfObjectsTextField = new JTextField();
		numberOfObjectsTextField.setEditable(true);
		numberOfObjectsTextField.setBackground(Color.WHITE);
		
		updateButton = new JButton("Update");
		updateButton.setActionCommand(UPDATE);
		updateButton.addActionListener(this);
		
		parametersValuesTitleLabel = new JLabel("Parameters values:");
		
		serverIPParameterTitleLabel = new JLabel("SERVER IP:");
		portParameterTitleLabel = new JLabel("PORT:");
		numberOfObjectsParameterTitleLabel = new JLabel("NUMBER OF OBJECTS:");
		
		serverIPParameterValueLabel = new JLabel(gui.getServerIP());
		portParameterValueLabel = new JLabel(gui.getPort());
		numberOfObjectsParameterValueLabel = new JLabel(gui.getNumberOfObjects());
		
		sendMessageObjectsButton = new JButton("Send objects");
		sendMessageObjectsButton.setActionCommand(SEND_MESSAGE_OBJECTS);
		sendMessageObjectsButton.addActionListener(this);
		
		add(serverIPLabel);
		add(serverIPTextField);
		add(portLabel);
		add(portTextField);
		add(numberOfObjectsLabel);
		add(numberOfObjectsTextField);
		add(new JLabel(""));
		add(updateButton);
		add(new JLabel(""));
		add(new JLabel(""));
		add(parametersValuesTitleLabel);
		add(new JLabel(""));
		add(serverIPParameterTitleLabel);
		add(serverIPParameterValueLabel);
		add(portParameterTitleLabel);
		add(portParameterValueLabel);
		add(numberOfObjectsParameterTitleLabel);
		add(numberOfObjectsParameterValueLabel);
		add(new JLabel(""));
		add(sendMessageObjectsButton);
	}
	
	/**
	 * Returns server IP from Text Field
	 * @return serverIP
	 */
	public String getServerIP()
	{
		return serverIPTextField.getText();
	}
	
	/**
	 * Returns port from Text Field
	 * @return port
	 */
	public String getPort()
	{
		return portTextField.getText();
	}
	
	/**
	 * Returns numberOfObjects from Text Field
	 * @return numberOfObjects
	 */
	public String getNumberOfObjects()
	{
		return numberOfObjectsTextField.getText();
	}
	
	/**
	 * Replaces serverIP value with the value that enters as parameter
	 * @param pServerIP
	 */
	public void setServerIP(String pServerIP)
	{
		serverIPParameterValueLabel.setText(pServerIP);
	}
	
	/**
	 * Replaces port value with the value that enters as parameter
	 * @param pPort
	 */
	public void setPort(String pPort)
	{
		portParameterValueLabel.setText(pPort);
	}
	
	/**
	 * Replaces numberOfObjects value with the value that enters as parameter
	 * @param pNumberOfObjects
	 */
	public void setNumberOfObjects(String pNumberOfObjects)
	{
		numberOfObjectsParameterValueLabel.setText(pNumberOfObjects);
	}
	
	/**
	 * Clears Text Fields
	 */
	public void clearTextFields()
	{
		serverIPTextField.setText("");
		portTextField.setText("");
		numberOfObjectsTextField.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();
		
		if(command.equals(UPDATE))
		{
			gui.updateParameters();
		}
		else if(command.equals(SEND_MESSAGE_OBJECTS))
		{
			gui.sendMessageObjects();
		}
	}
}

package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Main class of UDP DATA TRANSMISSION SERVER
 */
public class Main {
	
	public static void main(String[] args) throws IOException
	{
		System.out.println("----------------------------------------------------");
		System.out.println("UDP DATA TRANSMISSION SERVER");
		System.out.println("----------------------------------------------------");
		System.out.print("Enter port:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strPort = br.readLine();
		int port = Integer.parseInt(strPort);
		System.out.print("Selected port:"+strPort);
		Server server = new Server(port);	
		server.createAndListenSocket();
		
		
	}
	
}

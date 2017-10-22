package src;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {
	/**
	 * Datagram socket
	 */
	DatagramSocket socket = null;
	/**
	 * Server port
	 */
	int serverPort=0;
	
	public Server(int prmPort) {
		serverPort = prmPort;
	}

	public void createAndListenSocket() {
		try {
			socket = new DatagramSocket(serverPort);
			byte[] incomingData = new byte[1024];

			while (true) {
				DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);
				socket.receive(incomingPacket);
				byte[] data = incomingPacket.getData();
				ByteArrayInputStream in = new ByteArrayInputStream(data);
				ObjectInputStream is = new ObjectInputStream(in);
				try {
					MessageObject object = (MessageObject) is.readObject();
					int newSeq= object.getSequenceNumber()+1;
					System.out.println("Object received = " + newSeq);
					ClientFile clientFile = new ClientFile();
					clientFile.addReceivedObject(incomingPacket.getAddress().toString(), newSeq, System.currentTimeMillis()- object.getTimeStamp());
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				InetAddress IPAddress = incomingPacket.getAddress();
				int port = incomingPacket.getPort();
				String reply = "Thank you for the message";
				byte[] replyBytea = reply.getBytes();
				DatagramPacket replyPacket = new DatagramPacket(replyBytea, replyBytea.length, IPAddress, port);
				socket.send(replyPacket);
				Thread.sleep(2000);
				//System.exit(0);
			}

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class ClientFile {

	private int lastSequence=0;
	private int received=0;
	private int lost=0;
	private long averageTransmissionTime=0;
	
	public ClientFile() {
	}	
	
	public void addReceivedObject(String prmIpAddress, int sequenceNumber, long transmissionTime)
	{
		
		createOrAppendFile( prmIpAddress, sequenceNumber, transmissionTime);
		
	}
	
	/**
	 * Adds 1 line to the sequence number + transmission time file for the client. If it doesn't exist, it creates the file.
	 */
	public void createOrAppendFile(String prmIpAddress, int sequenceNumber, long transmissionTime) {
		String fileName = "..\\Server\\src\\ClientFiles"+prmIpAddress + ".txt";
		String tempFileName = "..\\Server\\src\\ClientFiles"+prmIpAddress+"temp" + ".txt";
		File file = new File(fileName);
		if (!file.exists()) {
			PrintWriter writer;
			try {
				writer = new PrintWriter(fileName, "UTF-8");
				writer.println(sequenceNumber + ": " + transmissionTime + " ms");
				//prints clients package transmission info
				if(sequenceNumber!=lastSequence+1)
				{
					lost=lost+sequenceNumber-lastSequence;
				}
				lastSequence=sequenceNumber;
				received++;
				averageTransmissionTime=(averageTransmissionTime+transmissionTime)/received;
				
				printClientTransmissionInfo(writer,received, lost, averageTransmissionTime);
				writer.close();
				
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} else {
			if(sequenceNumber==1)
			{
				//resets the file	
				file.delete();
				lastSequence=0;
				received=0;
				lost=0;
				averageTransmissionTime=0;
				
			}
			try (FileWriter fw = new FileWriter(fileName, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter writer = new PrintWriter(bw)) 
			{
				
				copyFile(fileName,tempFileName);
				file.delete();
				
				copyFile(tempFileName,fileName); 
				File tempfile = new File(tempFileName);
				tempfile.delete();
				
				writer.println(sequenceNumber + ": " + transmissionTime + " ms");
						
				//prints clients package transmission info
				if(sequenceNumber!=lastSequence+1)
				{
					lost=lost+sequenceNumber-lastSequence;
				}
				lastSequence=sequenceNumber;
				received++;
				averageTransmissionTime=(averageTransmissionTime+transmissionTime)/received;
				
				printClientTransmissionInfo(writer,received, lost, averageTransmissionTime);
				
			} catch (IOException e) {

			}
		}
	}
	
	public void printClientTransmissionInfo(PrintWriter writer,int receivedPackages, int lostPackages, long average)
	{
		writer.println(receivedPackages+" received packages, "+lostPackages+" lost packages, "+average+"ms average transmission time");
	}
	
	
	private void copyFile(String sourceFileName,String destinationFileName) { 

	      BufferedReader br = null;
	      PrintWriter pw = null; 

	      try {
	          br = new BufferedReader(new FileReader( sourceFileName ));
	    	  pw =  new PrintWriter(new FileWriter( destinationFileName ));

	          String line;
	          while ((line = br.readLine()) != null) {
	        	  if(!line.contains("received packages"))
	        		  pw.println(line);
	          }

	          br.close();
	          pw.close();
	      }catch (Exception e) {
		  e.printStackTrace();
	      }
	}

}

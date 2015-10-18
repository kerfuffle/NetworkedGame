package net.kerfuffle.NetworkedGame;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Connection {

	private String ip;
	private int port;
	private DatagramSocket clientSocket;
	private boolean connected = false;
	
	public Connection(String ip, int port)
	{
		this.ip = ip;
		this.port = port;
		
		try 
		{
			clientSocket = new DatagramSocket();
		} 
		catch (SocketException e) 
		{
			e.printStackTrace();
		}
	}
	
	// x,y,speed,r/g/b,name;
	
	public void sendInitialData()
	{
		byte send[] = Main.p.toInitString().getBytes();
		try 
		{
			DatagramPacket sendPacket = new DatagramPacket(send, send.length, InetAddress.getByName(ip), port);
			clientSocket.send(sendPacket);
			
			byte receive[] = new byte[16];
			DatagramPacket receivePacket = new DatagramPacket(receive, receive.length);
			clientSocket.receive(receivePacket);
			
			String sp[] = new String(receivePacket.getData()).split(";");
			if (sp[0].equals("Success"))
			{
				connected = true;
			}
		} 
		catch (UnknownHostException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void sendData()
	{
		if (connected)
		{
			
		}
	}
	
}

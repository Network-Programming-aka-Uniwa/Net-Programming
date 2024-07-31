/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick Z. Zacharis
 */

import java.io.*;
import java.net.*;

public class UDPClient {
   public static void main(String args[]) throws Exception
   {
        String hostName = "127.0.0.1"; 
        int portNumber = 8888; 
        
        if (args.length == 2) { 
           hostName = args[0]; 
           portNumber = Integer.parseInt(args[1]); 
        } 
        else
        {
            System.out.println("Usage: java EchoClient <host name> <port number>"); 
            System.out.println("The default values for host and port are 127.0.0.1 and 8888\n");
        }       

            
      System.out.println("Type a message to send : ");        
      BufferedReader keybInput =
         new BufferedReader(new InputStreamReader(System.in));
      DatagramSocket clientSocket = new DatagramSocket();
      clientSocket.setSoTimeout(1000);
      InetAddress IPAddress = InetAddress.getByName(hostName);
      byte[] sendData = new byte[1024];
      byte[] receiveData = new byte[1024];
      String sentence = keybInput.readLine();
      sendData = sentence.getBytes();
      DatagramPacket sendPacket = new DatagramPacket
                 (sendData, sendData.length, IPAddress, portNumber);
      clientSocket.send(sendPacket);
      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

      try
      {
        clientSocket.receive(receivePacket);
        String srvResponce = new String(receivePacket.getData());
        System.out.println("The server response :" + srvResponce);
      } 
      catch (SocketTimeoutException e) {
           System.out.println("Timeout reached!!! " + e);
         }
        clientSocket.close();
    }
}


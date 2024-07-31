/**
 *
 * @author Nick Z. Zacharis
 */
import java.net.*;

public class UDPServer {
   public static void main(String args[]) throws Exception
   {
      int portNumber = 8888;

      if(args.length == 0)
      {
         System.out.println("Usage: java UDPServer <port number>");
         System.out.println("The default port is 8888\n");
      }
      else
      {
          portNumber = Integer.parseInt(args[0]); 
      } 
 
      System.out.println("The UDP Server  is running....");   
      DatagramSocket serverSocket = new DatagramSocket(portNumber);
      byte[] receiveData = new byte[1024];
      byte[] sendData = new byte[1024];
      
      while(true)
       {
          DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
          serverSocket.receive(receivePacket);

          String sentence = new String( receivePacket.getData(), 0, receivePacket.getLength());
          System.out.println("Your message is: " + sentence);
          InetAddress IPAddress = receivePacket.getAddress();
          int port = receivePacket.getPort();
          String strServerResponce = sentence.toUpperCase();
          sendData = strServerResponce.getBytes();
          DatagramPacket sendPacket =
             new DatagramPacket(sendData, sendData.length, IPAddress, port);
          serverSocket.send(sendPacket);
        }
      }
} 


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick Z. Zacharis
 */
import java.net.*; 
import java.io.*; 

public class EchoClient {
    public static void main(String[] args) throws IOException 
    { 
        String hostName = "127.0.0.1"; 
        int portNumber = 7777; 
        
        if (args.length == 2) { 
           hostName = args[0]; 
           portNumber = Integer.parseInt(args[1]); 
        } 
        else
        {
            System.out.println("Usage: java EchoClient <host name> <port number>"); 
            System.out.println("The default values for host and port are 127.0.0.1 and 7777\n");
        }
  
        try ( 
            Socket echoSocket = new Socket(hostName, portNumber); 
            PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true); 
            BufferedReader in = 
                new BufferedReader( new InputStreamReader(echoSocket.getInputStream())); 
            BufferedReader stdIn = new BufferedReader( new InputStreamReader(System.in)) 
        ) { 
            System.out.println("Type a message to send : ");     
            String userInput; 
            while ((userInput = stdIn.readLine()) != null) { 
                out.println(userInput); 
                System.out.println("echo: " + in.readLine()); 
            } 
        } catch (UnknownHostException e) { 
            System.err.println("Don't know about host " + hostName); 
            System.exit(1); 
        } catch (IOException e) { 
            System.err.println("Couldn't get I/O for the connection to " + hostName); 
            System.exit(1); 
        } 
    } 
} 


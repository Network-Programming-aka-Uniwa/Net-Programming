/**
 *
 * @author Nick Z. Zacharis
 */
import java.net.*; 
import java.io.*; 
  
public class EchoServer { 
    public static void main(String[] args) throws IOException 
    { 
        int portNumber = 7777;

        if(args.length == 0)
        {
           System.out.println("Usage: java EchoServer <port number>");
           System.out.println("The default port is 7777\n");
        }
        else
        {
            portNumber = Integer.parseInt(args[0]); 
        } 
        System.out.println("The Echo Server  is running....");  
        try
		{
            ServerSocket serverSocket =  
                new   ServerSocket(portNumber );  
			while(true)
			{				
                Socket clientSocket = serverSocket.accept();       
                PrintWriter out =  
                    new   PrintWriter(clientSocket.getOutputStream(), true);                     
                BufferedReader in = new   BufferedReader(  
                    new   InputStreamReader(clientSocket.getInputStream()));
                          
                String inputLine;  
                while   ((inputLine = in.readLine()) != null) {  
				    if(inputLine.equals("bye"))
                       break;
                    out.println(inputLine);  
                }  
			}
        } catch   (IOException e) {  
            System.out.println("An exception has occurred on port "  
                + portNumber);  
            System.out.println(e.getMessage());  
        }  
    }
}
    
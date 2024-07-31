/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick Z. Zacharis
 * 
 * The server displays the data from HTTP Requests (GET, POST, POST (multi-part))
 * Use the file with HTTPServer.html (Right-Click and view)
 */
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class SocketUtils {
	
	static final int bufferLen = 1024;
	
	public static String getRequest(Socket sock) throws Exception {
		
		StringBuilder requestString = new StringBuilder();
		
		byte [] requestBytes = new byte[bufferLen];
		
		InputStream in = sock.getInputStream();
		
		String requestPart1 = null;
                
		while (true) {
             int n = in.read(requestBytes, 0, bufferLen);
             if(n == -1){ break; }

			   requestPart1 = new String(requestBytes, 0, n);
			   requestString.append(requestPart1);
			   
			 if(n < bufferLen)
			 {
				 break;
			 }
		}
  	    return requestString.toString();
	}
}

public class HttpServer {

	public static void main(String[] args) throws Exception {

		ServerSocket serSock = new ServerSocket(8010);
		
		while (true) {
			
			System.out.println("\n\nWaiting for client...\n\n");
			
			Socket sock = serSock.accept();
			
			String request = SocketUtils.getRequest(sock);
			
			System.out.println("Obtained Request .... \n\n" + request );
			
			OutputStream out = sock.getOutputStream();
			
			PrintWriter pw = new PrintWriter(out);
			
			pw.println("HTTP/1.0 200 OK");
			pw.println("Content-type: text/html");
                        pw.println("Server: MyJava 6.1");
                        
			
			pw.println();
			
			pw.println("<html><body>Welcome</body></html>");
			
			pw.close();
			
			sock.close();
		}
		
	}

}

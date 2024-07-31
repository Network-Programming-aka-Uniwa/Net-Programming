import java.net.*;

public class ShowIP {

   public static void main(String[] args) {
       InetAddress address;
       String host = "www.uniwa.gr";
       try {
           address = InetAddress.getByName(host);
           System.out.println("IP address of " + host + " : " 
		                                + address.toString());

		   address = InetAddress.getLocalHost();
           System.out.println("IP address of LocalHost : " 
		                                + address.toString());
           
		   address = InetAddress.getLoopbackAddress();
           System.out.println("IP address of LoopBack : " 
		                                + address.toString());
		   
		   InetAddress [] allAddress = InetAddress.getAllByName("www.google.com");
		   System.out.println("IP address of www.google.com ");
           
		   for(int i =0; i < allAddress.length; i++)	{
               System.out.println("IP address "	+ i + ") " 
			                       + allAddress[i].toString());
           }
           
		   address = InetAddress.getByName("139.91.247.1");
           System.out.println("Host name " + address.getCanonicalHostName());
       }
       catch (UnknownHostException Ex)
       {
           System.out.println("Could not find : " + host);
	   }
   }
}




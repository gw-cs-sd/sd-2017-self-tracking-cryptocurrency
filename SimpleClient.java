/*
/////////////////////////////////////////////////////
/////////////////////////////////////////////////////
////////// Abigail H. Shriver              //////////  
////////// CSci 4243 Senior Design Project //////////  
////////// Self-Tracking E-currency        //////////
/////////////////////////////////////////////////////
/////////////////////////////////////////////////////
*/

import java.net.*;
import javax.net.ssl.*;
import java.io.*;
import java.util.*;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.*;
import sun.misc.*;
import javax.crypto.spec.SecretKeySpec; 	


public class SimpleClient{
	
	static String algor = "AES";
	static byte[] keyVal =
		new byte[] { 
			0x00, 0x01, 0x02, 0x03, 
			0x04, 0x05, 0x06, 0x07,
			0x08, 0x09, 0x10, 0x11, 
			0x12, 0x13, 0x14, 0x15 
		};
	static int port = 8080; 
	static String hostAddress = "localhost";


	public static void main(String args[])  {
		try{
			
//////// Still debugginf SSL socket 
			/*SSLSocketFactory ssf = (SSLSocketFactory) SSLSocketFactory.getDefault();
			
			Socket soc = ssf.createSocket("localhost",port);
			/*SSLSocket sslSoc = (SSLSocket)sslsocketfactory.createSocket(
        		soc,
        		soc.getInetAddress().getHostAddress(),
        		soc.getPort(),
        		true
        	);*/
			//ServerSocket serverSoc = ssf.createServerSocket(port);
			
////////
			Socket soc = new Socket(hostAddress,port);

			OutputStream outStream = soc.getOutputStream();
			ObjectOutputStream objOutStream = new ObjectOutputStream(outStream);
			Currency testCurrency1 = new Currency(
	            "sender2", 
	            "testReciever1", 
	            new ArrayList<String> (),
	            100.00,
	            0.00,
	            new ArrayList<String> (Arrays.asList(
	            	"Restrictive Tree",
	            	"entertainment",
	            	"newspaperMagazines"
	            	)),
	            "currency1"
	        );
	        SecretKeySpec key = new SecretKeySpec(keyVal, "AES");
			Cipher c = Cipher.getInstance(algor);
			c.init(Cipher.ENCRYPT_MODE, key);

	        SealedObject sealedCurrency = new SealedObject(testCurrency1, c);

			objOutStream.writeObject(sealedCurrency);
			objOutStream.writeObject(new String("another object from the client"));
			objOutStream.close();
			outStream.close();
			soc.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}

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
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.*;
import sun.misc.*;
import javax.crypto.spec.SecretKeySpec; 

public class SimpleServer {
	static String algo = "AES";
	static byte[] keyValue =
		new byte[] { 
			0x00, 0x01, 0x02, 0x03, 
			0x04, 0x05, 0x06, 0x07,
			0x08, 0x09, 0x10, 0x11, 
			0x12, 0x13, 0x14, 0x15 
		} ;
	static int port = 8080;

	public static void main(String args[]) {
	
	try {


//////// Still debugging SSL socket 		
    /*
		SSLSocket sslSoc = (SSLSocket)sslsocketfactory.createSocket(
    		soc,
    		soc.getInetAddress().getHostAddress(),
    		soc.getPort(),
    		true
    	);


		SSLServerSocketFactory ssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
	    ServerSocket ss = ssf.createServerSocket(port);
	 */ 
////////

		ServerSocket ss = new ServerSocket(port);
	    Socket soc = ss.accept();

		SecretKeySpec  key = new SecretKeySpec(keyValue, "AES");
		Cipher c = Cipher.getInstance(algo);
		c.init(Cipher.DECRYPT_MODE, key);
		InputStream is = soc.getInputStream();
		ObjectInputStream ois = new ObjectInputStream(is);
		SealedObject sealedCurrency = (SealedObject)ois.readObject();
		Currency unSealedCurrency = (Currency) sealedCurrency.getObject(c);
		if (unSealedCurrency!=null){
			System.out.println("Read Object: " + unSealedCurrency.curID);
		}
		is.close();
		soc.close();
		ss.close();
	}catch(Exception e){
		System.out.println(e);}
	}

}
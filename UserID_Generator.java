//Source: http://stackoverflow.com/questions/41107/how-to-generate-a-random-alpha-numeric-string

/*
/////////////////////////////////////////////////////
/////////////////////////////////////////////////////
////////// Abigail H. Shriver              //////////  
////////// CSci 4243 Senior Design Project //////////  
////////// Self-Tracking E-currency        //////////
////////// Last Updated: Nov. 30, 2016     //////////           
/////////////////////////////////////////////////////
/////////////////////////////////////////////////////
*/

import java.security.SecureRandom;
import java.math.BigInteger;

public final class UserID_Generator {
	private SecureRandom random = new SecureRandom();

	public String nextSessionId() {
		return new BigInteger(130, random).toString(32);
	}
}
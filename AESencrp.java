/*
/////////////////////////////////////////////////////
/////////////////////////////////////////////////////
////////// Abigail H. Shriver              //////////  
////////// CSci 4243 Senior Design Project //////////  
////////// Self-Tracking E-currency        //////////
/////////////////////////////////////////////////////
/////////////////////////////////////////////////////
*/


// Source: http://www.code2learn.com/2011/06/encryption-and-decryption-of-data-using.html


package cryptocurrency; 
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.*;
import sun.misc.*;
import javax.crypto.spec.SecretKeySpec; 

public class AESencrp {
    
    private static final String ALGO = "AES";
    private static final byte[] keyValue = 
        new byte[] { 'T', 'e', 'm', 'p', 'o', 'r', 'a',
        'y', 'k', 'e', 'y','v', 'a', 'l', 'u', 'e' };

    public static String encrypt(String Data) {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(Data.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encVal);
        return encryptedValue;
    }

    public static String decrypt(String encryptedData)  {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }
    
    private static Key generateKey() {
        Key key = new SecretKeySpec(keyValue, ALGO);
       
        return key;
    }

    public static void main(String[] args)  {

        String password = "mypassword";
        String passwordEnc = encrypt(password);
        String passwordDec = decrypt(passwordEnc);

        System.out.println("Plain Text : " + password);
        System.out.println("Encrypted Text : " + passwordEnc);
        System.out.println("Decrypted Text : " + passwordDec);
    }

}

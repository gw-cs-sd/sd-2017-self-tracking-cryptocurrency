/*
/////////////////////////////////////////////////////
/////////////////////////////////////////////////////
////////// Abigail H. Shriver              //////////
////////// CSci 4243 Senior Design Project //////////
////////// Self-Tracking E-currency        //////////
/////////////////////////////////////////////////////
/////////////////////////////////////////////////////
*/


import java.io.IOException;

public class SysUser extends AESencrp{

    SysUser current;

    //randomly generated 
    static String userID; 
    static int userIDLength =8;

    //This MUST be encrypted as SOON as 
    //it is entered into the browser 
    //Prior to being stored ANYWHERE! 
    static String password;
    
    //Payment Type-- Eventually change to an enumeration 
    String paymentType;

    String nameFirst;
    String nameLast; 
    String email; 
    String phone; 
    static String temp;

    public SysUser(){

    }
 
    // User constructor
    public SysUser(
        String passwordIn, 
        String paymentTypeIn, 
        String nameFirstIn, 
        String nameLastIn, 
        String emailIn, 
        String phoneIn) 
    {
        userID = randomlyGenerateUserID();
        try{
            password = AESencrp.encrypt(passwordIn);
        }catch (Exception e){
            return;
        }
        paymentType = passwordIn;
        nameFirst = nameFirstIn;
        nameLast = nameLastIn;
        email = emailIn;
        phone = phoneIn;
    }

    public String getPassword(){
        return this.password;
    }

    //Take random userID and then add another randomly generated sufix to the userId 
    //prior to encyrption, to prevent patterns of UserIDs being detected 
    public static String getEncryptedUser(){
       try{
            return AESencrp.encrypt(userID + randomlyGenerateUserID());
        }catch (Exception e){
            return null;
        }
    }

    //Decrypt the encrypted UserID and only take the first 'userIDLength' characters
    public static String  returnPlainTextUser(String encryptedUserID){
        try{
            return AESencrp.decrypt(encryptedUserID).substring(0,userIDLength);
        }catch (Exception e){
            return null ;
        }
    }

    public static String randomlyGenerateUserID(){
        UserID_Generator temp = new UserID_Generator(); 
        return  temp.nextSessionId().substring(0, userIDLength);
    }

    public static void main(String[] args) {
        /*//Test randomly generated ids 
        for(int i = 0; i< 1000 ; i++){
            System.out.println(randomlyGenerateUserID());
        }*/
        // SysUser test = new SysUser("test213",
        //     "Credit", "TestUser1","TestUserLast", 
        //     "test123@gmail.com", "123-456-7890");
        
        // // Test to make sure the decryption code works 
        // try{
        //     System.out.println( AESencrp.decrypt(password));
        // }catch (Exception e){
        //     return;
        // }

        // System.out.println(AESencrp.decrypt(password));
        // return;
    }
}

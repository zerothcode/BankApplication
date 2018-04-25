package zcController;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class zcMD5 
{
    public static String getMD5(String input) throws NoSuchAlgorithmException 
    {   
        String result = input;
        if(input != null) 
        {        
            MessageDigest md = MessageDigest.getInstance("MD5");        
            md.update(input.getBytes());        
            BigInteger hash = new BigInteger(1, md.digest());        
            result = hash.toString(16);        
            while(result.length() < 32)
                result = "0" + result;          
        }   
        return result;
    }
}

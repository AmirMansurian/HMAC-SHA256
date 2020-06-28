
package hmac;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author amir
 */
public class HMAC {


    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
        
        String Key = "SecretKey";
        String message = "this is message";
        
        Mac hmac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(Key.getBytes(), "HmacSHA256");
        hmac.init(secret_key);
        byte[] hashed = hmac.doFinal(message.getBytes());
        
        String format = String.format("%032x", new BigInteger(1, hashed));
        
        System.out.println(format);
    }
    
}

/**
 * 
 */
package util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author jsonis
 *
 */
public class EncryptUtil {
	
	
	public static String md5(String data){
		try{
			MessageDigest messageDigect = MessageDigest.getInstance("MD5");
			byte[] md = messageDigect.digest(data.getBytes());
			BigInteger bigInteger = new BigInteger(1,md);
			String hashText = bigInteger.toString(16);
			while(hashText.length() < 32){
				hashText = "0" +  hashText;
			}
			return hashText;
			
		}catch (NoSuchAlgorithmException e){
			throw new RuntimeException(e);
		}
	}
	
	

}

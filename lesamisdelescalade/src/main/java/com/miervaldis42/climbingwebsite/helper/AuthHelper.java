package com.miervaldis42.climbingwebsite.helper;

// Imports
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;


/*
 * Class for Auth controller
 */
public class AuthHelper {
	
	// Email validator
	public Boolean checkEmailFormat(String email) {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Boolean validate = email.matches(regex);
		
		return validate;
	}
	

 	public byte[] hashPassword(final String userPassword) {
		// Variables for hashing
 		final char[] password = userPassword.toCharArray();
 		
		String saltSentence = "L'escalade, c'est trop bien !!";
		final byte[] salt = saltSentence.getBytes();
		
		final int iterations = 10000;
		final int keyLength = 512;

		// Hashing in process...
		try {
		    SecretKeyFactory skf = SecretKeyFactory.getInstance( "PBKDF2WithHmacSHA512" );
		    PBEKeySpec spec = new PBEKeySpec( password, salt, iterations, keyLength );
		    SecretKey key = skf.generateSecret( spec );
		    byte[] res = key.getEncoded( );
		    return res;
		} catch ( NoSuchAlgorithmException | InvalidKeySpecException e ) {
		    throw new RuntimeException( e );
		}
    }

}

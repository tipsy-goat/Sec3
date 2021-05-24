/**
 *
 * @author Markos Asimomytis
 * icsd11011
 * 
 */

/*
 * Markos Asimomytis
 * icsd11011
 */

package sec3;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class KeyGen {
    // methods named according to security standards
    public static void startKeyGen() throws NoSuchAlgorithmException{
        // Making a KeyPair
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        
        // Initialize
        keyGen.initialize(2048);
        
        // Generate Pair
        KeyPair pair = keyGen.generateKeyPair();
        
        // Get Private Key
        PrivateKey priv = pair.getPrivate();
        
        // Get Public Key
        PublicKey publ = pair.getPublic();
    }
    

}

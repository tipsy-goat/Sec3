/*
 *
 * @author Markos Asimomytis
 * icsd11011
 * Kostantinos Fessas
 * icsd12197 
 * 
 */

package sec3;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class KeyGen {
    private static String privKey;
    private static String pubKey;

    public static String getPrivKey() {
        return privKey;
    }

    public static String getPubKey() {
        return pubKey;
    }
    
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
        privKey=pair.getPrivate().toString();
        
        // Get Public Key
        PublicKey publ = pair.getPublic();
        pubKey=pair.getPublic().toString();
        
    }
    

}

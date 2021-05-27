/*
 * Markos Asimomytis
 * icsd11011
 */
package sec3;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marko
 */
public class Sec3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        try {
            //
            KeyGen.startKeyGen();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Sec3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        FileHandler f = new FileHandler();
//        f.storePrivateKey();
//        f.storePublicKey();
        User u = new User();
        try {
            System.out.println(u.createHashedPass(u.createSalt32()));
//        System.out.println(u.createPass());
//        System.out.println(u.createPass());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Sec3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

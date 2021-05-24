/*
 * Markos Asimomytis
 * icsd11011
 */
package sec3;

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
    public static void main(String[] args) {
        try {
            //
            KeyGen.startKeyGen();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Sec3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

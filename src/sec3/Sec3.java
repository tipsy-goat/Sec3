/*
 *
 * @author Markos Asimomytis
 * icsd11011
 * Kostantinos Fessas
 * icsd12197 
 * 
 */

package sec3;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sec3 {

    
    public static void main(String[] args) throws IOException {
//        try {
//            //
//            KeyGen.startKeyGen();
//        } catch (NoSuchAlgorithmException ex) {
//            Logger.getLogger(Sec3.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
////        FileHandler f = new FileHandler();
////        f.storePrivateKey();
////        f.storePublicKey();
//        User u = new User();
//        try {
//            System.out.println("This is the Hashed Password "+u.createHashedPass(u.createSalt32()));
////        System.out.println(u.createPass());
////        System.out.println(u.createPass());
//        } catch (NoSuchAlgorithmException ex) {
//            Logger.getLogger(Sec3.class.getName()).log(Level.SEVERE, null, ex);
//        }

    FileHandler f = new FileHandler();
    f.readUser();
    f.storeUsers();
    }
    
}

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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FileHandler {
    
    public void readUser(){
        //Fill
    }
    
    public void readPollData(){
        //Fill
    }
    
    public void storePrivateKey() throws IOException{
        //used for testing purposes
        File f = new File("Privatekey.txt");
        FileWriter w = new FileWriter("Privatekey.txt");
        w.write(KeyGen.getPrivKey());
    }
    
    public void storePublicKey() throws IOException{
        
        File f = new File("Publickey.txt");
        FileWriter w = new FileWriter("Publickey.txt");
        w.write(KeyGen.getPubKey());
    }

}

/*
 *
 * @author Markos Asimomytis
 * icsd11011
 * Kostantinos Fessas
 * icsd12197 
 * 
 */

package sec3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class FileHandler {
    
    public void readUser() throws FileNotFoundException{
        //Fill
        File f = new File("UsersInput.txt");
        Scanner sc = new Scanner(f);
        
        while (sc.hasNextLine()){
            String data = sc.nextLine();
            String[] arrOfData = data.split(";");
            User e = new User(arrOfData[0],arrOfData[1]);
            User.Users.add(e);
        }
        
        
    }
    
    public void readPollData(){
        //Fill
    }
    
    public void storeUsers() throws IOException{
        File f = new File("Users.txt");
        //users with their salt and hashed passwords
        FileWriter w = new FileWriter("Users.txt");
        for (int i=0; i<User.Users.size();i++){
            w.write(User.Users.get(i).name+":"+User.Users.get(i).mail+":"+User.Users.get(i).salt+":"+User.Users.get(i).hashedPassword+"\n");
            System.err.println(User.Users.get(i).name+":"+User.Users.get(i).mail+":"+User.Users.get(i).salt+":"+User.Users.get(i).hashedPassword+"\n");
        
    }
        w.close();
    }
    
    public void storePrivateKey() throws IOException{
        //used for testing purposes
        File f = new File("Privatekey.txt");
        FileWriter w = new FileWriter("Privatekey.txt");
        w.write(KeyGen.getPrivKey());
        w.close();
    }
    
    public void storePublicKey() throws IOException{
        
        File f = new File("Publickey.txt");
        FileWriter w = new FileWriter("Publickey.txt");
        w.write(KeyGen.getPubKey());
        w.close();
    }

}

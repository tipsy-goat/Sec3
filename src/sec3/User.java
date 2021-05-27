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

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class User {
    private String name;
    private String mail;
    private String hashedPassword;
    private String salt;
    
    protected static ArrayList<User> Users = new ArrayList<User>();
    protected static ArrayList<String> Pass = new ArrayList<String>();
    
    public void User(String name, String mail){
        this.name=name;
        this.mail=mail;
        this.salt=createSalt32();
        try {
            this.hashedPassword=createHashedPass(salt);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected static String createPass(){
        boolean check = true;
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 12;
        Random random = new Random();

        String pass = random.ints(leftLimit, rightLimit + 1)
        .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
        .limit(targetStringLength)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
        if (Pass.isEmpty()){
            Pass.add(pass);
        }else{
            for(int i = 0; i < Pass.size();i++){
                if(Pass.get(i).equals(pass)){
                    check=false;
                }
            }
        }
        if(!check){
            createPass();
        }
        System.err.println(pass);
        return pass;
    }
    
    protected static String createHashedPass(String salt) throws NoSuchAlgorithmException{
        MessageDigest m = MessageDigest.getInstance("SHA-512");
        m.update(salt.getBytes());
        byte[] hash = m.digest(createPass().getBytes(StandardCharsets.UTF_8));
        return "done";
    }
    
    protected static String createSalt32(){
    int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 32;
        Random random = new Random();

        String salt = random.ints(leftLimit, rightLimit + 1)
        .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
        .limit(targetStringLength)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
        System.err.println(salt);
        return salt;
}
}

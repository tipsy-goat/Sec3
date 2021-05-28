/*
 *
 * @author Markos Asimomytis
 * icsd11011
 * Kostantinos Fessas
 * icsd12197 
 * 
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
    protected String name;
    protected String mail;
    protected String hashedPassword;
    protected String salt;
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();// to use with toHex
    
    protected static ArrayList<User> Users = new ArrayList<User>();
    protected static ArrayList<String> Pass = new ArrayList<String>();
    
    public User(String name, String mail){
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
//        System.err.println("This is the Password "+pass);
        return pass;
    }
    
    protected static String createHashedPass(String salt) throws NoSuchAlgorithmException{
        MessageDigest m = MessageDigest.getInstance("SHA-512");
        m.update(salt.getBytes());
        byte[] hash = m.digest(createPass().getBytes(StandardCharsets.UTF_8));
        return toHex(hash);
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
//        System.err.println("This is a salt "+salt);
        return salt;
}
    protected static String toHex(byte[] bytes){
        // to be used when storing a hashed password from byte to string
    byte[] hexChars = new byte[bytes.length * 2];
    for (int j = 0; j < bytes.length; j++) {
        int v = bytes[j] & 0xFF;
        hexChars[j * 2] = (byte) HEX_ARRAY[v >>> 4];
        hexChars[j * 2 + 1] = (byte) HEX_ARRAY[v & 0x0F];
    }
    return new String(hexChars, StandardCharsets.UTF_8);
}
}

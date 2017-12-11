/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Constants;

/**
 *
 * @author nilsf
 */
public interface Constants {
    
    //Admin password
    public static String adminPWD = "123";
    public static final String filesPath = System.getProperty("user.home");
    
    
    //////////////////////////////////////////////
    /////////            SQL            /////////
    public static String sqlWriteStudent = "SELECT fornavn, etternavn, email from bruker";
 
    
 
}

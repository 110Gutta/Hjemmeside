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
    public static String sqlWriteStudent = "SELECT firstname, lastname, email from User";
    public static String sqlDeleteUser = "DELETE FROM User WHERE firstname = ? AND lastname = ?";
    public static String sqlSelectModule = "SELECT modulename, learninggoals, moduletext from Module";
    public static String sqlInsertIntoModule = "INSERT INTO module (modulename, learninggoals, moduletext, modulefile) values (?, ?, ?, ?)";
    public static String sqlSelectAllFromMuduleID = "SELECT * FROM module WHERE modueid = ?";
    public static String sqlInsertInnlevering = "INSERT INTO Delivery (email, modueid, deliveryfile) values (?, ?, ?)";
    public static String sqlDeleteModule = "DELETE FROM module WHERE moduleid = ?";
    
 
}

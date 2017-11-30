/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.text.SimpleDateFormat;

/**
 *
 * @author nilsf
 */
public interface Constants {
    public static String LOGIN = "login";
    public static String LOGIN_ERROR = "loginError";
    public static String USER = "user";
    public static boolean DEBUG = true;
    public static final String filesPath = System.getProperty("user.home");
    public static SimpleDateFormat dateFormatShort =  new SimpleDateFormat("dd-MM-yyyy");
}

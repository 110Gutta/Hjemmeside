/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package utils;

import exceptions.InvalidParameterValueException;
import javax.servlet.http.HttpServletRequest;

/**
*
* @author nilsf
*/
public class Utils {
public static String getParam(String key, HttpServletRequest request) throws InvalidParameterValueException{
if(request.getParameter(key)==null || request.getParameter(key).trim().equals("")){
throw new InvalidParameterValueException("Null Parameter: "+key.toUpperCase());
}else{
return request.getParameter(key);
}
}
}
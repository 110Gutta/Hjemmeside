/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package exceptions;

/**
*
* @author nilsf
*/
public class InvalidParameterValueException extends Exception{
/**
* 
*/
private static final long serialVersionUID = 1L;

public InvalidParameterValueException(String msg) {
super(msg);
}
}
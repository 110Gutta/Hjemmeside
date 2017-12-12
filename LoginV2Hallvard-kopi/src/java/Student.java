/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hallvardlauvrak
 */
public class Student {
    private String fname;
    private String lname;
    private String email;
    private int stnr; //studentnummer
    
    public Student (String fname, String lname, String email, int stnr) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.stnr = stnr;
    }

    public String getFname() {
	return fname;
    }
    public void setFname(String fname) {
	this.fname = fname;
    }
    public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
        public int getStnr() {
        return stnr;
    }
    public void setStnr(int stnr) {
	this.stnr = stnr;
    }
    
    public void printInfo() {
        System.out.println("Studentnr: "+getStnr()+"fornavn:"+getFname()+"etternavn:"+getLname()+"email:"+getEmail());
    }
}

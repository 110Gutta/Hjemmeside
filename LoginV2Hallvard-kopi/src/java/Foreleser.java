/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hallvardlauvrak
 */
public class Foreleser {
    private String fname;
    private String lname;
    private String email;
    private int annr; //ansattnummer
    
    public Foreleser (String fname, String lname, String email, int annr) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.annr = annr;
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
        public int getAnnr() {
        return annr;
    }
    public void setAnnr(int annr) {
	this.annr = annr;
    }
    
    public void printInfo() {
        System.out.println("Studentnr: "+getAnnr()+"fornavn:"+getFname()+"etternavn:"+getLname()+"email:"+getEmail());
    }
}


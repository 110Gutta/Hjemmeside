/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author nilsf
 */
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;



@Entity
public class User implements Serializable{
    @Id
    @Column
    private String email;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String password;
    @Column
    private int userID;
    
    
    /**
    private enum UserStatus {
    pending,
    active,
    inactive,
    deleted;
} */
    
    public static enum Type{
		Teacher("Teacher"),
		Student("Student");
		private final String type;
		private Type(String type) {
			this.type = type;
		}
		public String stringValue(){
			return this.type;
		}
	}
    private Type userType;
    //private UserStatus userStatus;

    private Date regDate;
	private boolean active;
  /**
   *public User(String email, String fName, String lName, String password) {
        this.email = email;
        this.password = password;
        this.fName = fName;
        this.lName = lName;

    }
    **/
    
    public User(){
    }
    
    
    public int getUserId() {
	return userID;
    }
    
    public void setUserId(int userId) {
	this.userID = userId;
    }
    
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public String getfirstName() {
        return firstName;
    }
    
    public void setfirstName(String fName) {
        this.firstName = fName;
    }
    
    
     public String getlastName() {
        return lastName;
    }
     
    public void setlastName(String lName) {
       this.lastName = lName;
    }
    
     
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public Date getRegDate() {
		return regDate;
    }
    
    public void setRegDate(Date regDate) {
	this.regDate = regDate;
    }
    
        
    public boolean isActive() {
	return active;
    }
    
    public void setActive(boolean active) {
    	this.active = active;
    }
       
    
   public Type getUserType() {
		return userType;
	}
	public void setUserType(Type userType) {
		this.userType = userType;
	}
        
       /**
    public UserStatus getUserStatus() {
        	return userStatus;
	}
    public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	} */
}

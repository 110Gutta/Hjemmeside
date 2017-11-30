/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author nilsf
 */
import Java.DataBase;
import exceptions.MemberNotFoundException;
import java.io.Closeable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import Objects.User;


public class UserDAO {
    DataBase db = new DataBase();
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
              
    User u = new User();
    
    public User getUser(String username) throws SQLException,
			MemberNotFoundException{
        try {
            con = db.getCon();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM `t_users` WHERE `Email` = '" + username + "'");
			
        if (rs.first()) {
            u = new User();
            u.setUserId(rs.getInt("ID"));
            u.setfirstName(rs.getString("FirstName"));
            u.setlastName(rs.getString("LastName"));
            u.setPassword(rs.getString("Password"));
            u.setEmail(rs.getString("Email"));
            u.setUserType(User.Type.valueOf(rs.getString("UserType")));
            
        } else {
            throw new MemberNotFoundException("User not found: " + username.toUpperCase());
	}
        
	} catch (SQLException e) {
            e.printStackTrace();
            throw e;
            
	} finally {
            IOUtils.closeQuietly((Closeable) rs);
            IOUtils.closeQuietly((Closeable) st);
            IOUtils.closeQuietly((Closeable) con);
	}
		return u;
	}
    
    
    
    public int addUser(User u) throws SQLException {
		
    int userId = -1;
        try {       
            
            con = db.getCon();
            st = con.createStatement();
            pst = con.prepareStatement("INSERT INTO t_users(Password,FirstName,LastName,Email,UserType) VALUES"
                                    + "(?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        
            pst.setString(2, u.getPassword());
            pst.setString(3, u.getfirstName());
            pst.setString(4, u.getlastName());
            pst.setString(5, u.getEmail());
            pst.setString(6, u.getUserType().toString());
            pst.executeUpdate();
            
            rs = pst.getGeneratedKeys();
            if (rs.first()) {
                userId = rs.getInt(1);
                System.out.println("GENERATED ID IS  : " + rs.getInt(1));
            }
	} catch (SQLException e) {
		e.printStackTrace();
		throw e;
	} finally {
                IOUtils.closeQuietly((Closeable) rs);
                IOUtils.closeQuietly((Closeable) st);
                IOUtils.closeQuietly((Closeable) con);
	}
            return userId;
	} 
    
    
}


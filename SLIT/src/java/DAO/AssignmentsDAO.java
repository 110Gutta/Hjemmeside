/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import Objects.AssignmentObject;
import DB.DataBase;
import java.io.Closeable;
import org.apache.tomcat.util.http.fileupload.IOUtils;

/**
 *
 * @author nilsf
 */
public class AssignmentsDAO {
    
    DataBase db = new DataBase();
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public ArrayList<AssignmentObject> getAssignments() throws SQLException{
        ArrayList<AssignmentObject> assignments = new ArrayList<>();
	try{
	    con = db.getCon();
            st = con.createStatement();
            
	    String query = "SELECT t_teacher_assignments.Id,t_teacher_assignments.TotalMarks,t_teacher_assignments.DueDate,t_teacher_assignments.Date, " +
                " t_student_assignments.StudendId, t_student_assignments.Result, t_student_assignments.Date as StudentDate" +
                " FROM t_teacher_assignments " +
                " left join t_student_assignments on t_teacher_assignments.Id = t_student_assignments.AssingnmentId ";
            query += " ORDER BY t_teacher_assignments.Date DESC";
            
	    rs = st.executeQuery(query);
	    while(rs.next()){
		AssignmentObject assignment = new AssignmentObject();
		assignment.setId(rs.getString("Id"));
                assignment.setStudentId(rs.getString("StudendId"));
                assignment.setDueDate(rs.getDate("DueDate"));
                assignment.setCreatedDate(rs.getDate("Date"));
                assignment.setStatus(rs.getDate("DueDate")); // SKJEKK OM DOBBELT OPP HER
                assignment.setResult(rs.getString("Result"));
                assignment.setTotalMarks(rs.getString("Totalmarks"));
                assignment.setStudentSubmittedDate(rs.getDate("StudentDate"));
                assignments.add(assignment);
		}
		}catch(SQLException e){
			e.printStackTrace();
			throw e;
		}finally{
			IOUtils.closeQuietly((Closeable) rs);
                        IOUtils.closeQuietly((Closeable) st);
                        IOUtils.closeQuietly((Closeable) con);
		}
        return assignments;
    }
    
    public int submitAssignment(String studentId,String assignId) throws SQLException {
	
	int assignmentId = -1;
        try {         
		con = db.getCon();
		pst = con.prepareStatement(
		"INSERT INTO `t_student_assignments`(`StudendID`,`Date`,`Result`,`AssingnmentId`) VALUES (?,NOW(),?,?)",
		Statement.RETURN_GENERATED_KEYS);
                
		pst.setString(1, studentId);
		pst.setString(2, null);
                pst.setString(3, assignId);
		pst.executeUpdate();
		rs = pst.getGeneratedKeys();
                
		if (rs.first()) {
			assignmentId = rs.getInt(1);
			System.out.println("GENERATED ASSIGNMENT ID IS  : " + rs.getInt(1));
		}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			IOUtils.closeQuietly((Closeable) pst);
			IOUtils.closeQuietly((Closeable) con);
		}
        return assignmentId;
    }
    
    public int createNewAssignment(Date dueDate,String totalMarks) throws SQLException {
      
	int assignmentId = -1;
        try {
		con = db.getCon();
		pst = con.prepareStatement("INSERT INTO `t_teacher_assignments`(`DueDate`,`Date`,`TotalMarks`) VALUES (?,NOW(),?)",
		Statement.RETURN_GENERATED_KEYS);
		pst.setDate(1, new java.sql.Date(dueDate.getTime()));
		pst.setString(2, totalMarks);
		pst.executeUpdate();
		rs = pst.getGeneratedKeys();
		if (rs.first()) {
			assignmentId = rs.getInt(1);
			System.out.println("GENERATED NEW ASSIGNMENT ID IS  : " + rs.getInt(1));
		}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			IOUtils.closeQuietly((Closeable) pst);
			IOUtils.closeQuietly((Closeable) con);
		}
        return assignmentId;
    }
    
    public void announceMarks(String studentId,String assignmentId,String marks) throws SQLException {
		
		try {
			con = db.getCon();
                        pst = con.prepareStatement("UPDATE `t_student_assignments` SET `Result` = ? WHERE `StudendId` = ? AND `AssingnmentId` = ?");
			pst.setString(1, marks);
			pst.setString(2, studentId);
                        pst.setString(3, assignmentId);
			if(pst.executeUpdate() < 1) {
				throw new SQLException(
						"Unable to submit marks. Please try later.");
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			IOUtils.closeQuietly((Closeable) pst);
			IOUtils.closeQuietly((Closeable) con);
		}
	}
}

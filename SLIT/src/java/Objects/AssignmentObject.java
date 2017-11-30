/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.util.Date;

/**
 *
 * @author nilsf
 */


public class AssignmentObject {
    private String id,studentId,result,totalMarks,status;
    private Date dueDate,createdDate,studentSubmittedDate;
    
    public AssignmentObject() {
        
    }
    
    public void setId(String id){
        this.id =id;
    }
    public String getId(){
        return this.id;
    }
    public void setStudentId(String stuId){
        this.studentId = stuId;
    }
    public String getStudentId(){
        return studentId;
    }
    public void setDueDate(Date dueD){
        this.dueDate = dueD;
    }
    public Date getDueDate(){
        return dueDate;
    }
    public void setCreatedDate(Date createdD){
        this.createdDate = createdD;
    }
    public Date getCreatedDate(){
        return createdDate;
    }
    public void setStudentSubmittedDate(Date studentD){
        this.studentSubmittedDate = studentD;
    }
    public Date getStudentSubmittedDate(){
        return studentSubmittedDate;
    }
    public void setResult(String rslt){
        this.result = rslt;
    }
    public String getResult(){
        return result;
    }
    public void setTotalMarks(String tltM){
        this.totalMarks = tltM;
    }
    public String getTotalMarks(){
        return totalMarks;
    }
    public void setStatus(Date dueDate){
        if(dueDate.getDate() < new Date().getDate()){
            this.status = "Closed";
        }else{
            this.status = "Active";
        }
    }
    public String getStatus(){
        return status;
    }
}

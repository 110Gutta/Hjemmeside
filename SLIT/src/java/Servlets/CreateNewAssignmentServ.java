/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import dao.AssignmentsDAO;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.json.simple.JSONObject;
import Utils.Constants;

/**
 *
 * @author nilsf
 */
@MultipartConfig(maxFileSize = 1024*1024*16) // max filezise allowed
public class CreateNewAssignmentServ extends HttpServlet {

     private AssignmentsDAO assignmentDAO = new AssignmentsDAO();
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/create-new.jsp");
    	request.setAttribute("pageMenu", "Assigments");
        rd.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
	response.setContentType("text/x-json");
	HashMap<String, Object> hm = new HashMap<>();
        try{
        Part filePart = request.getPart("file");
        Date dueDate = Constants.dateFormatShort.parse(request.getParameter("dueDate"));
        String totalMarks = request.getParameter("totalMarks");
        
        if (filePart != null) {
            int id = assignmentDAO.createNewAssignment(dueDate, totalMarks);
            InputStream input = filePart.getInputStream();
            OutputStream output = new FileOutputStream(Constants.filesPath+"/"+id+".docx");
            byte [] buffer = new byte[256];
            int bytesRead = 0;
            while((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
            if(input != null){
                   input.close();
            }
            if(output != null){
                   output.close();
            }
        }
        hm.put("response", "success");
        hm.put("redirect", request.getContextPath()+"/assignments");
        }catch(IllegalArgumentException e){	
		e.printStackTrace();
		hm.put("response", "fail");
		hm.put("message", "Your operation has failed. Its seems that someone else is tampering data.");
	}catch(Exception e){
		e.printStackTrace();
		hm.put("response", "fail");
		hm.put("message", e.getMessage());
	}
        
        out.print(JSONObject.toJSONString(hm));
    }


}

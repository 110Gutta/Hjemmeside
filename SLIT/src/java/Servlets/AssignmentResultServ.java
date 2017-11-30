/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import dao.AssignmentsDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

/**
 *
 * @author nilsf
 */
public class AssignmentResultServ extends HttpServlet {

    
    private final AssignmentsDAO assignmentDAO = new AssignmentsDAO();
     
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/x-json");
             PrintWriter out = response.getWriter();
        
            RequestDispatcher rd = request.getRequestDispatcher("/announce-result.jsp");
            request.setAttribute("pageMenu", "Assigments");
            request.setAttribute("studentId", request.getParameter("studentId"));
            request.setAttribute("assignmentId", request.getParameter("assignmentId"));
            rd.forward(request, response);
        
       	
            // post
	HashMap<String, Object> hm = new HashMap<>();
        try{
            String studentId = request.getParameter("studentId");
            String assignmentId = request.getParameter("assignmentId");
            String marks = request.getParameter("marks");
            assignmentDAO.announceMarks(studentId, assignmentId, marks);
            hm.put("response", "success");
            hm.put("redirect", request.getContextPath()+"/assignments");
        }catch(IllegalArgumentException e){	
		e.printStackTrace();
		hm.put("response", "fail");
		hm.put("message", "Your operation has been failed. Its seems that someone else is tampering data.");
	}catch(Exception e){
		e.printStackTrace();
		hm.put("response", "fail");
		hm.put("message", e.getMessage());
	}
           out.print(JSONObject.toJSONString(hm));
    }
    
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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
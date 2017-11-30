/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAO.UserDAO;
import exceptions.InvalidParameterValueException;
import exceptions.MemberNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Objects.User;
import org.json.simple.JSONObject;
import sessions.UserSessionManager;
import Utils.Constants;
import utils.Utils;

/**
 *
 * @author nilsf
 */
public class LoginServ extends HttpServlet {

    private final UserDAO userDAO = new UserDAO();
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
         response.setContentType("application/json");
        RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
    	request.setAttribute("pageMenu", "Login");
        rd.forward(request, response);
        
        //POST PART
        PrintWriter out = response.getWriter();
		HashMap<String, Object> json = new HashMap<>();
		
		HttpSession session = request.getSession();
                String username,password;
                
                try{
                    username = Utils.getParam("username", request);
		    password = Utils.getParam("password", request);
                    User user = userDAO.getUser(username);
                    if(user.getPassword().equals(password)){
			    session.setAttribute(Constants.USER, user);
			    session.setAttribute(Constants.LOGIN, true);
			    UserSessionManager.addOnlineUser(user);
			    json.put("success", true);
			    json.put("message", "Login Success");
			    json.put("isVerified",true);
			    json.put("redirect", request.getContextPath()+"/uprofile");
					
			}else{
			    json.put("success", false);
			    json.put("message", "Invalid Email/Password");
			    session.setAttribute(Constants.LOGIN_ERROR, "Invalid Email/Password");
		    }
                }catch(MemberNotFoundException e){
			    json.put("success", false);
			    json.put("message", "Invalid Email/Password");
			    session.setAttribute(Constants.LOGIN_ERROR, "Invalid Email/Password");
		}catch(InvalidParameterValueException e) {
			    json.put("success", false);
			    json.put("message", "Invalid Request Format");
			    session.setAttribute(Constants.LOGIN_ERROR, "Invalid Request Format");
		}catch (SQLException e) {
			    json.put("success", false);
			    json.put("message", "Somthing went wrong at SERVER. Please try again...");
			    session.setAttribute(Constants.LOGIN_ERROR, "Somthing went wrong at SERVER. Please try again...");
		}
                out.print(JSONObject.toJSONString(json));
		out.close();
                
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
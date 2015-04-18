/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Serv;

import Connection.UserConnection;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thursday
 */
public class SignUp2 extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SignUp2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignUp2 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        
        UserConnection us = new UserConnection();
        
        request.getParameter("lastname");
        
        if( request.getParameter("user").trim().length() > 0 && request.getParameter("firstname").trim().length() >0
            && request.getParameter("lastname").trim().length() >0 && request.getParameter("anotherpass").trim().length() > 0 ){
        
        if(request.getParameter("anotherpass").equals(request.getParameter("passwordsignup"))){
            
        if(us.checkUsername(request.getParameter("user"))){
        
            us.makeruser(request.getParameter("user") ,
                request.getParameter("anotherpass"),
                request.getParameter("firstname") , 
                request.getParameter("lastname"));  
                request.setAttribute("message", "Account Created!");
        }
        else{
            request.setAttribute("message", "Username already taken");
        } 
            
        }else request.setAttribute("message", "Enter Password Again");
            
        }else request.setAttribute("message", "Input in all of the fields");
        
           RequestDispatcher view = request.getRequestDispatcher("jsp/login.jsp");
           view.forward(request, response);
           // response.sendRedirect("jsp/login.jsp");
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

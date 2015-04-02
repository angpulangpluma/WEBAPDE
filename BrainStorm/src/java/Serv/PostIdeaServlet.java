/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Serv;

import Connection.ProjectConnection;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thursday
 */
public class PostIdeaServlet extends HttpServlet {

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
            out.println("<title>Servlet PostIdeaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PostIdeaServlet at " + request.getContextPath() + "</h1>");
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
        
        
      String strid = request.getParameter("selected");
      String user = request.getParameter("userid");
      String idea = request.getParameter("ideadesc");
      ProjectConnection pc= new ProjectConnection();
      int id;
      int uid=-1;
      if(strid.equals("new")){
          System.out.println("Add new topic");
      }else{
          id = Integer.parseInt(strid.trim());
          uid = Integer.parseInt(user.trim());
          pc.saveIdea(id, uid, idea);
      }
      
      response.sendRedirect("IdeaPageServlet?id="+uid);
      
      
      
        
        
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
              String strid = request.getParameter("selected");
      String user = request.getParameter("userid");
      String idea = request.getParameter("ideadesc");
      ProjectConnection pc= new ProjectConnection();
      int id;
      int uid=-1;
      if(strid.equals("new")){
          
          
          
          
      }else{
          id = Integer.parseInt(strid.trim());
          uid = Integer.parseInt(user.trim());
          pc.saveIdea(id, uid, idea);
      }
      
      response.sendRedirect("IdeaPageServlet?id="+uid);
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

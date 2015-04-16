/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serv;

import Bean.HomePageBean;
import Bean.UserBean;
import Connection.HomePageConnection;
import Connection.NotificationConnection;
import Connection.SearchConnection;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hsibayan
 */
@WebServlet(name = "SearchAddServlet", urlPatterns = {"/SearchAddServlet"})
public class SearchAddServlet extends HttpServlet {

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
            out.println("<title>Servlet SearchJoinGroupServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchJoinGroupServlet at " + request.getContextPath() + "</h1>");
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
        
        int groupID = 0, userID = 0;
        HomePageConnection hCon = new HomePageConnection();
        SearchConnection sCon = new SearchConnection();
        HttpSession session = request.getSession();
        UserBean user = (UserBean) session.getAttribute("user");
        String chosen = request.getParameter("chosen");
        boolean isMember = false;
        
        switch (chosen) {
            case "Join Group":
                groupID = parseInt(request.getParameter("id"));
                userID = user.getID();
                break;
            case "Add Member":
                groupID = parseInt(request.getParameter("groupID"));
                userID = parseInt(request.getParameter("userID"));
                isMember = sCon.isMember(groupID, userID);
                break;
        }
        
        if(!isMember)
            hCon.saveMember(userID, groupID);
        
        //---
        HomePageBean pagebean = new HomePageBean();

        hCon.getGroups(user.getID(), pagebean);
        
        NotificationConnection nc = new NotificationConnection();
        pagebean.setNotification(nc.getNotifs(user.getID()));

        session.setAttribute("homepage", pagebean);
        //--
        
        response.setContentType("text/plain");  
        response.setCharacterEncoding("UTF-8"); 
        response.getWriter().write(isMember + "");
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

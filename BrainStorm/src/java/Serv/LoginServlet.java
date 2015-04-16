/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serv;

import Bean.Group;
import Bean.HomePageBean;
import Bean.Project;
import Bean.UserBean;
import Connection.HomePageConnection;
import Connection.NotificationConnection;
import Connection.ProjectConnection;
import Connection.UserConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Thursday
 */
public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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

        String user = (String) request.getParameter("emaillogin");
        String password = (String) request.getParameter("passwordlogin");

//        System.out.println("user&pass: " + user + "-" + password);
        HttpSession session = request.getSession();
        UserBean Bean = new UserBean();
        if (UserConnection.userquery.isVerify(user, password, Bean)) {

            HomePageBean pagebean = new HomePageBean();
            HomePageConnection HPC = new HomePageConnection();
            ProjectConnection pc = new ProjectConnection();
            NotificationConnection nc = new NotificationConnection();
            HPC.getGroups(Bean.getID(), pagebean);
            ArrayList<Group> groups = pagebean.getGroups();
         for (Group g : groups){
             System.out.println("initializing ideas, groups");
             ArrayList<Project> projects = g.getProjects();
             for (Project p : projects){
                 System.out.println("initializing ideas, projects");
                 pc.getTopics(p);
                 p.setIdeaCount(pc.getIdeaCount(p.getID()));
             }
         }
            pagebean.setNotification(nc.getNotifs(Bean.getID()));
            //create arraylist of group
            //initialize arraylist of all groups
            
            session.setAttribute("homepage", pagebean);
            session.setAttribute("user", Bean);
            //session.setAttribute("grplist", groupbean);
            response.sendRedirect("Version 1/Home Page.jsp");
        }

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

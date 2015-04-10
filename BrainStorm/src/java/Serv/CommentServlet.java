/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Serv;

import Bean.Member;
import Connection.NotificationConnection;
import Connection.ProjectConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thursday
 */
public class CommentServlet extends HttpServlet {

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
            out.println("<title>Servlet CommentServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CommentServlet at " + request.getContextPath() + "</h1>");
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
        
       String comment = request.getParameter("text");
       String ideaid = request.getParameter("topicid");
       String userid = request.getParameter("userid");

       System.out.println("TOPIC ID IS "+ ideaid);
       
       ProjectConnection pc = new ProjectConnection();
       pc.SaveComment(userid, ideaid, comment);
        Calendar cal = Calendar.getInstance();
    	cal.getTime();
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    	String r = sdf.format(cal.getTime());
        
        NotificationConnection nc= new NotificationConnection();
        int topicid = nc.getTopicId(Integer.parseInt(ideaid));
       int groupid= pc.getGroupID(topicid);
       ArrayList<Member> members; 
        String projectname = pc.getProjectname2(topicid);
        String topicname = pc.getTopicname2(topicid);
        
        
      members = nc.getGroupmates(Integer.parseInt(userid), groupid);
     System.out.println("MEMBERS ARE "+ members.size()+ "USER ID IS "+Integer.parseInt(userid)+" groupid"+groupid );
      nc.saveNotif(Integer.parseInt(userid.trim()), groupid,"posted a new comment under project "+projectname+ " and topic "+ topicname, members);
        
       response.setContentType("text/plain");  
        response.setCharacterEncoding("UTF-8"); 
        response.getWriter().write(r); 
     
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

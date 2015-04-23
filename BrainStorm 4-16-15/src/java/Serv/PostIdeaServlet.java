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
import java.util.ArrayList;
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
        String project =  request.getParameter("projid");
        String topictitle = request.getParameter("topictitle");
        int intproject = Integer.parseInt(project.trim());

        ProjectConnection pc= new ProjectConnection();
        int id;
        int uid=-1;
        uid = Integer.parseInt(user.trim());
        if(strid.equals("new")){
            System.out.println("Add new topic");
            int newtopicid = pc.getMaxProjID();
            newtopicid++;
            pc.saveTopic(newtopicid, intproject,topictitle);
            System.out.println("Saved topic!");
            pc.saveIdea(newtopicid, uid, idea);
        }
        else {
            id = Integer.parseInt(strid.trim());
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
        String project =  request.getParameter("projid");
        String topictitle = request.getParameter("topictitle");
        int intproject = Integer.parseInt(project.trim());
        int id;
        int uid=-1;
        uid = Integer.parseInt(user.trim());
        int newtopicid;      
        NotificationConnection nc= new NotificationConnection();
        String projectname = nc.getProjectname(intproject);
        int groupid;
        ArrayList<Member> members;
      
        if(strid.equals("new")){
            System.out.println("Add new topic");
            newtopicid = pc.getMaxProjID();
            System.out.println("newtopicID is "+newtopicid );
            newtopicid = 1 + newtopicid;

            System.out.println("LATEST ID IS "+newtopicid);

            pc.saveTopic(newtopicid, intproject,topictitle);
            pc.saveIdea(newtopicid, uid, idea);
            groupid = pc.getGroupID(newtopicid);
            
            //handles notification
            members = nc.getGroupmates(uid, groupid);
            nc.saveNotif(uid, groupid,"posted a new idea under project "+projectname , members);
            //  nc.saveNotif(uid, groupid,"posted a new idea", members);
        }
        else {
            id = Integer.parseInt(strid.trim());
            pc.saveIdea(id, uid, idea);
            groupid = pc.getGroupID(id);
            members = nc.getGroupmates(uid, groupid);
            nc.saveNotif(uid, groupid,"posted a new idea under project "+projectname , members);
        }
      
        response.sendRedirect("IdeaPageServlet?projid="+intproject+"&"+"grpid="+groupid);
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

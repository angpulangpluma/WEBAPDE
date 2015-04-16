/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import Bean.Group;
import Bean.HomePageBean;
import Bean.Project;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Thursday
 */
public class HomePageConnection {

    public void getGroups(int id, HomePageBean Bean) {
        boolean logged = false;

        String sql = "select groups.groupid, groups.groupname, groupmembers.userID "
                + "from groups, groupmembers "
                + "where groups.groupID = groupmembers.groupID and groupmembers.userID = " + id;

        try {
            Group g;
            Connection con = DataBase.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                g = new Group(rs.getInt(1), rs.getString(2));
                System.out.println("GROUPS ARE " + g.getGroupName());
                getProject(rs.getInt(1), g);
                getMember(rs.getInt(1), g);

                Bean.addGroup(g);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

  
    
    public void saveMember(int uid, int gid) {

        String sql = "INSERT INTO `brainstorm`.`groupmembers` (`groupID`, `userID`) VALUES ('" + gid + "', '" + uid + "')";

        try {

            Connection con = DataBase.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public int getmaxProjectID(){
        String sql=  "select MAX(projectID) from project" ;
        int max=0;
        try {

            Connection con = DataBase.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                max= rs.getInt(1);
            }
            
        } catch (Exception e) {
            System.out.println("ERROR AY NASA GETMAX");
            System.out.println(e);
        }
        
        return max;
    }
    
    public void saveProject(String id, String name){
        
        String sql="INSERT INTO project (`groupID`, `projectname`) VALUES ("+ id+ ", '"+ name +"');";
        try {

            Connection con = DataBase.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("ERROR AY NASA SAVEPROJ");
            System.out.println(e);
        }
        
        
    }
    
    public void saveGroup(int gid, int uid, String gname) {

        String sql = "INSERT INTO groups (`groupID`, `groupName`, `leaderID`) VALUES (" + gid + ", '" + gname + "'," + uid + ");";

        try {

            Connection con = DataBase.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public int getMaxGroupID() {

        String sql = "select MAX(groupID) from groups";
        int max = 0;
        try {

            Connection con = DataBase.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                max = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return max;

    }

    public void changePass(int id,String pass){
        
        String sql = "UPDATE user SET `password` = '" +pass+ "' WHERE `userID`=' " +id+"'";
        
          try {

            Connection con = DataBase.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            stmt.executeUpdate(sql);
            
        } catch (Exception e) {
            System.out.println(e);
        }
         
    }
    
    public void changeName(int id,String fname,String lname){
        
        String sql = "UPDATE user SET firstname= '"+fname+ "', lastname = '"+lname+"' WHERE userID= "+ 1;
        
          try {

            Connection con = DataBase.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            stmt.executeUpdate(sql);
            
        } catch (Exception e) {
            System.out.println(e);
        }
         
    }
    
    public String searchGroup(String word, int id){
        
        String sql="select groups.groupID, groups.groupName from groups , groupmembers "
                + "where groups.groupID = groupmembers.groupID " 
                + "and groupmembers.groupID != "+id+" and leaderID != "+id+" and groupName like '%"+word+"%'";
        
        int counter = 0;
        String people = null;
        try {

            Connection con = DataBase.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                people = rs.getString(2);
            }

            while (rs.next() && counter < 5) {
                people = people + "\n" + rs.getString(2);
                counter++;
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return people;
    }
        
        
    
    
    public String getSuggestions(String word) {

        String sql = "select username,firstname, lastname "
                + "from user "
                + "where firstname LIKE '%" + word + "%' or  lastname LIKE '%" + word + "%'";
        int counter = 0;
        String people = null;
        try {

            Connection con = DataBase.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                people = rs.getString("firstname") + " " + rs.getString("lastname");
            }

            while (rs.next() && counter < 5) {
                people = people + "\n" + rs.getString("firstname") + " " + rs.getString("lastname");
                counter++;
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return people;
    }

    private void getMember(int id, Group g) {

        String sql = "select groupID, user.userID, firstname, lastname "
                + "from groupmembers, user "
                + "where groupmembers.userID = user.userID and groupID =" + id;

        try {
            Project p;
            Connection con = DataBase.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                g.addMember(rs.getString(3), rs.getString(4));
                // g.addProject(rs.getInt(1), rs.getString(3));
                System.out.println("MEMBER OF ID " + id + " " + rs.getString(3));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void getProject(int id, Group g) {

        String sql = "select projectID, groups.groupID, projectname from project, groups "
                + "where project.groupID = groups.groupID "
                + "and groups.groupID = " + id;

        /*
         select  topicID,topicname,projectname 
         from topic, project 
         where topic.projectID = project.ProjectID
         
         */
        try {
            Project p;
            Connection con = DataBase.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                g.addProject(rs.getInt(1), rs.getString(3));
                System.out.println("TOPIC OF ID " + id + " " + rs.getString(3));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    

}

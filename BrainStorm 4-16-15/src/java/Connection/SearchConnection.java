/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Connection;

import Bean.Group;
import Bean.HomePageBean;
import Bean.UserBean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hsibayan
 */
public class SearchConnection {
    
    public void getGroups(String str, ArrayList<Group> groups, int ID) {
        
        String sql = "select distinct a.groupID, a.groupName, concat(c.firstname, ' ', c.lastname)\n" +
                    "from groups a, groupmembers b, user c\n" +
                    "where a.groupID = b.groupID and a.leaderID = c.userID\n" +
                    "and a.groupName like '%" + str + "%' \n" +
                    "and a.groupID not in (select groupID from groupmembers where userID = " + ID + ")";
        /*
        String sql = "select a.groupID, a.groupName, concat(c.firstname, ' ', c.lastname), count(distinct d.projectname)\n" +
                "from groups a, groupmembers b, user c, project d, idea e\n" +
                "where a.groupID = b.groupID and a.leaderID = c.userID and a.groupID = d.groupID\n" +
                "and a.groupName like '%" + str + "%' \n" +
                "and a.groupID not in (select groupID from groupmembers where userID = " + ID + ")\n" +
                "group by a.groupID, a.groupName, concat(c.firstname, ' ', c.lastname)";
        */
        
        System.out.println("SQL - " + sql);
        try {
            Group g;
            Connection con = DataBase.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                g = new Group(rs.getInt(1), rs.getString(2));
                g.setLeader(rs.getString(3));
                groups.add(g);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void getUsers(String str, ArrayList<UserBean> users, int myID) {
        
        String sql = "select userID, firstname, lastname from user\n" +
                    "where concat(firstname, ' ', lastname) LIKE '%" + str + "%' and userID != " + myID;
        
        //System.out.println("IN GET PEOPLE: " + sql);
        try {
            UserBean u;
            Connection con = DataBase.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                u = new UserBean();
                u.setID(rs.getInt(1));
                u.setFirstName(rs.getString(2));
                u.setLastName(rs.getString(3));
                users.add(u);
                //System.out.println("MARIENEEEE! - " +rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public boolean isMember(int groupID, int userID) {
        String sql = "select count(*) from groupmembers where groupID = " + groupID + " and userID = " + userID;
        System.out.println("isMember SQL:\n"+sql);
        try {
            Connection con = DataBase.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            rs.next();
            if(rs.getInt(1) == 1)
                return true;
            else return false;
        } catch (SQLException ex) {
            Logger.getLogger(SearchConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}

package com.tmrnd.db;

import com.tmrnd.model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: saradhid
 * Date: 6/5/18
 * Time: 11:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class DbConnector {

    public static void connectTeamDatabase(List<Team> teamList){
        try
        {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost/tmrnd";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "kirthy", "HongLeong9#");

            // create a sql date object so we can use it in our INSERT statement
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            String teamQuery = "insert into tmrnd.team(team_id) values(?)";
            submitTeam(conn,teamList,teamQuery);

            conn.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    private static boolean submitTeam(Connection con,List<Team> teamList,String teamQuery){
        try {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(teamQuery);
            for (Team ins:teamList){
                ps.setObject(1, ins.getTeam_id());
                ps.addBatch();
            }
            ps.executeBatch();
            con.commit();
            return true;
        }catch (Exception e) {
            System.out.println("Exception Caught, updating log.");
            return false;
        }
    }

    public static void connectTaskDatabase(List<Task> taskList){
        try
        {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost/tmrnd";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "kirthy", "HongLeong9#");

            // create a sql date object so we can use it in our INSERT statement
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            String taskQuery = "insert into tmrnd.task(task_id,skill) values(?,?)";
            submitTask(conn,taskList,taskQuery);

            conn.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    private static boolean submitTask(Connection con,List<Task> taskList,String teamQuery){
        try {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(teamQuery);
            for (Task ins:taskList){
                ps.setObject(1, ins.getTaskId());
                ps.setObject(2, ins.getSkill());
                ps.addBatch();
            }
            ps.executeBatch();
            con.commit();
            return true;
        }catch (Exception e) {
            System.out.println("Exception Caught, updating log.");
            return false;
        }
    }

    public static void connectTeamSkillDatabase(List<TeamSkill> teamSkillList){
        try
        {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost/tmrnd";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "kirthy", "HongLeong9#");

            // create a sql date object so we can use it in our INSERT statement
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            String taskQuery = "insert into tmrnd.team_skill(team_id,skill) values(?,?)";
            submitTeamSkill(conn,teamSkillList,taskQuery);

            conn.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    private static boolean submitTeamSkill(Connection con,List<TeamSkill> teamSkillList,String teamQuery){
        try {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(teamQuery);
            for (TeamSkill ins:teamSkillList){
                ps.setObject(1, ins.getTeamId());
                ps.setObject(2, ins.getSkill());
                ps.addBatch();
            }
            ps.executeBatch();
            con.commit();
            return true;
        }catch (Exception e) {
            System.out.println("Exception Caught, updating log.");
            return false;
        }
    }
}

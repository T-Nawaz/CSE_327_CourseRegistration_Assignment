<<<<<<< HEAD
package com.company;

import java.awt.*;
import java.sql.*;

/**
 * Created by Abid Hasan on 3/26/2017.
 */
public class DatabaseConnector {

    private static final String dbUrl="jdbc:mysql://localhost/course";
    private static final String userName="root";
    private static final String password=null;
    private static Statement DBstatement;
    private static Connection DBconnection;


    public DatabaseConnector() {

        try {
            DBconnection = DriverManager.getConnection(dbUrl,userName,password);
            DBstatement=DBconnection.createStatement();
            System.out.println("Connection Success");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection Failed");

        }

    }

    public Object getData(String query){

        Course ResultCourse=new Course();
        ResultSet resultSet=null;
        try {
            resultSet=DBstatement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return resultSet;
    }

    public void addData(String query){
        try {
            DBstatement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
=======
package com.company;

import java.awt.*;
import java.sql.*;

/**
 * Created by Abid Hasan on 3/26/2017.
 */
public class DatabaseConnector {

    private static final String dbUrl="jdbc:mysql://localhost/course";
    private static final String userName="root";
    private static final String password=null;
    private static Statement DBstatement;
    private static Connection DBconnection;


    public DatabaseConnector() {

        try {
            DBconnection = DriverManager.getConnection(dbUrl,userName,password);
            DBstatement=DBconnection.createStatement();
            System.out.println("Connection Success");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection Failed");

        }

    }

    public Object getData(String query){

        Course ResultCourse=new Course();
        ResultSet resultSet=null;
        try {
            resultSet=DBstatement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return resultSet;
    }

    public void addData(String query){
        try {
            DBstatement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
>>>>>>> origin/master

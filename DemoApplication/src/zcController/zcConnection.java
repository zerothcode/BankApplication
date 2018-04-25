package zcController;

import java.sql.*;

/**
 *
 * @author RK Raju Khunt
 */
public class zcConnection {
    public static Connection con = null;
    public static Connection rkConnection() {
        return zerothcodeConnecction();
    }

    private static Connection ghclConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://192.161.3.87/pmsanugar", "root", "");
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://192.161.1.81/pmsanugar", "root", "");
                return con;
            } catch (ClassNotFoundException | SQLException ex) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://192.161.1.81/pmsanugar", "root", "");
                    return con;
                } catch (ClassNotFoundException | SQLException exx) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Error Connection On Server :" + e.getMessage());
                    javax.swing.JOptionPane.showMessageDialog(null, "Error Connection On TKZ :" + ex.getMessage());
                    javax.swing.JOptionPane.showMessageDialog(null, "Error Connection on Ncomputing:" + exx.getMessage());
                    System.exit(0);
                }
            }
        }
        return null;
    }
    
    private static Connection zerothcodeConnecction(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/zerothcode", "root", "RKinfotech");
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }
    
    public static Connection totalRecord(){
      try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://192.161.3.87/ghcl1", "root", "");
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://192.161.1.81/ghcl1", "root", "");
                return con;
            } catch (ClassNotFoundException | SQLException ex) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://192.161.1.81/ghcl1", "root", "");
                    return con;
                } catch (ClassNotFoundException | SQLException exx) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Error Connection On Server :" + e.getMessage());
                    javax.swing.JOptionPane.showMessageDialog(null, "Error Connection On TKZ :" + ex.getMessage());
                    javax.swing.JOptionPane.showMessageDialog(null, "Error Connection on Ncomputing:" + exx.getMessage());
                    System.exit(0);
                }
            }
        }
        return null;
    }
}

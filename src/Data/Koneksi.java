/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Andi
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;


public class Koneksi {
    private String url = "jdbc:mysql://localhost/politeknikcontoh";
    private String username = "root";
    private String password = "";
    
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return java.sql.DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException e) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    public ResultSet getQuery(Connection con, String sql) throws SQLException{
        return con.createStatement().executeQuery(sql);
    }
    
    public static void main(String[] args) {
        Koneksi koneksi = new Koneksi();
        if (koneksi.getConnection() != null) {
            JOptionPane.showMessageDialog(null, "Koneksi OK!");
        } else {
            JOptionPane.showMessageDialog(null, "404");
    }
}

}
package panels;




import java.sql.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sairam
 */
public class dbConn {

    public dbConn() throws SQLException {
        this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/libmanage","root","");
    }
    public Connection conn;
}

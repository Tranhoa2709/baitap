/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.SinhVien;

public class DBConnection {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    /*   /**
    * Link của db.
    * Thay 3306 bằng port của db (thường mặc định là 3306)
    * Thay qlhp bằng tên của db
    */
    private static final String DB_URL = "jdbc:mysql://localhost:3306/qlhp";
    
    // tên đăng nhập csdl
    private static final String DB_USER = "root";
    
    // password đăng nhập cơ sở dữ liệu
    private static final String DB_PASSWORD = "root";

    
    // Kết nối đến db
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException ex) {
        }
        return connection;
    }

    // Khởi tạo kết nối
    public void connect() {
        connection = DBConnection.getConnection();
    }

// Đóng kết nối đến cơ sở dữ liệu cũng như các thành phần liên quan. 
    public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    // Tạo câu lệnh tham số hóa ()
    public boolean prepareStatement(String query) {
        try {
            preparedStatement = connection.prepareStatement(query);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Lấy kết nối
    public Connection getConnect() {
        return connection;
    }

    // Set kết nối
    public void setConnect(Connection connect) {
        this.connection = connect;
    }

    // Lấy câu lệnh tham số hóa. 
    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

    
    // Set câu lệnh tham số hóa
    public void setPreparedStatement(PreparedStatement preparedStatement) {
        this.preparedStatement = preparedStatement;
    }

    // Lấy ra result set () 
    public ResultSet getResultSet() {
        return resultSet;
    }

    // Set result set
    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

}

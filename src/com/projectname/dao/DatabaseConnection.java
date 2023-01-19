package com.projectname.dao;

import java.sql.Connection;

import com.projectname.dao.MysqlConnection;


public class DatabaseConnection {
    static Connection connection = null;
    public static Connection getConnections(){
        connection = MysqlConnection.getConnection("jdbc:mysql:///students", "c2f", "c2fdbAdmin");
        return connection;
    }

}

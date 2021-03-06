package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnect {
    static Connection con;

    private static String dbHost = "soyura.com";
    private static String port = "3306";
    private static String dbName = "quizDb";
    private static String userName = "soyura";
    private static String password = "Soyura@123";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        connect();
    }

    public static void connect() throws ClassNotFoundException,SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://"+dbHost+":"+port+"/"+dbName,userName,password); // database name = quizDb
    }

    public static void pushToDB(String sql)throws ClassNotFoundException,SQLException{
        if(con == null){
            connect();
        }
        con.createStatement().executeUpdate(sql);
    }

    public static ResultSet getFromDB(String sql)throws ClassNotFoundException,SQLException{
        if(con == null){
            connect();
        }
        return con.createStatement().executeQuery(sql);
    }

    public static Connection getDBConnection()throws Exception{
        if (con == null) {
            connect();
        }
        return con;
    }
}

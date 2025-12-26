package db;

import java.sql.*;

public class DBConnection {
    private static Connection conn;

    public static Connection  getConnection() {
      try{
          if(conn==null)
              conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","devadas","Datladevadas(9848)");
      }
      catch (Exception e){
          e.printStackTrace();
      }
        return conn;
    }
}

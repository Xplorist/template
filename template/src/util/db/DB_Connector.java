package util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import util.config.ConfigReader;

public class DB_Connector
{
  private static String driver = null;
  private static String url = null;
  private static String user = null;
  private static String password = null;
  
  static
  {
    try
    {
       ResourceBundle rb = ConfigReader.getProperties("config/db_mysql_template");// MySQL連接
      // ResourceBundle rb = ConfigReader.getProperties("config/db_oracle_template");// Oracle連接
      driver = rb.getString("driver");
      url = rb.getString("url");
      user = rb.getString("username");
      password = rb.getString("password");
      Class.forName(driver);
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }
  
  public static Connection getConnection()
  {
    Connection conn = null;
    try
    {
      conn = DriverManager.getConnection(url, user, password);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return conn;
  }
}

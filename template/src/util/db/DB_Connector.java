package util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
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
      //Properties prop = ConfigReader.getProperties("config/db_mysql_template.properties");// MySQL連接
      Properties prop = ConfigReader.getProperties("config/db_oracle_template.properties");// Oracle連接
      driver = prop.getProperty("driver");
      url = prop.getProperty("url");
      user = prop.getProperty("username");
      password = prop.getProperty("password");
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

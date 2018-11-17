package util.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader
{
  public static String getPropertyByPath(String configPath, String property)
  {
    String configFilePath = ConfigReader.class.getClassLoader().getResource("/").getPath() + configPath;
    Properties prop = new Properties();
    try
    {
      BufferedReader bufReader = new BufferedReader(new FileReader(configFilePath));
      prop.load(bufReader);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    String result = prop.getProperty(property);
    
    return result;
  }
  
  public static Properties getProperties(String configPath)
  {
    String configFilePath = ConfigReader.class.getClassLoader().getResource("/").getPath() + configPath;
    Properties prop = new Properties();
    try
    {
      BufferedReader bufReader = new BufferedReader(new FileReader(configFilePath));
      prop.load(bufReader);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return prop;
  }
}

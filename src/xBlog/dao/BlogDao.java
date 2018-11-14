package xBlog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.db.DB_Connector;
import xBlog.bean.FileBean;

public class BlogDao
{
  private String errorFlag = null;
  private Connection conn = null;
  private PreparedStatement ps = null;
  private ResultSet rs = null;
  
  public void initResouces()
  {
    try
    {
      this.errorFlag = "0";
      this.conn = DB_Connector.getConnection();
      this.ps = null;
      this.rs = null;
      this.conn.setAutoCommit(false);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
  
  public void closeResouces()
  {
    try
    {
      if (this.rs != null) {
        this.rs.close();
      }
      if (this.ps != null) {
        this.ps.close();
      }
      if ((this.conn != null) && (!this.conn.isClosed()))
      {
        if ("1".equals(this.errorFlag)) {
          this.conn.rollback();
        } else {
          this.conn.commit();
        }
        this.conn.setAutoCommit(true);
        this.conn.close();
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
  
  public void template()
  {
    initResouces();
    try
    {
      String sql = "";
      this.ps = this.conn.prepareStatement(sql);
      this.ps.setString(1, "");
      this.rs = this.ps.executeQuery();
      while (this.rs.next()) {
        this.rs.getString("");
      }
    }
    catch (SQLException e)
    {
      this.errorFlag = "1";
      e.printStackTrace();
    }
    closeResouces();
  }
  
  public void addFile(String name_original, String name_stored, String file_path)
  {
    initResouces();
    try
    {
      String sql = "insert into blog_file (name_original, name_stored, file_path) values(?, ?, ?)";
      this.ps = this.conn.prepareStatement(sql);
      this.ps.setString(1, name_original);
      this.ps.setString(2, name_stored);
      this.ps.setString(3, file_path);
      this.ps.executeUpdate();
    }
    catch (SQLException e)
    {
      this.errorFlag = "1";
      e.printStackTrace();
    }
    closeResouces();
  }
  
  public List<FileBean> queryFiles()
  {
    List<FileBean> result = new ArrayList<FileBean>();
    initResouces();
    try
    {
      String sql = "SELECT * FROM xblog.blog_file";
      this.ps = this.conn.prepareStatement(sql);
      this.rs = this.ps.executeQuery();
      while (this.rs.next())
      {
        FileBean bean = new FileBean();
        bean.setPkid(this.rs.getString("pkid"));
        bean.setName_original(this.rs.getString("name_original"));
        bean.setName_stored(this.rs.getString("name_stored"));
        bean.setFile_path(this.rs.getString("file_path"));
        bean.setCreate_date(this.rs.getString("create_date"));
        bean.setCreater(this.rs.getString("creater"));
        bean.setUpdate_date(this.rs.getString("update_date"));
        bean.setUpdater(this.rs.getString("updater"));
        result.add(bean);
      }
    }
    catch (SQLException e)
    {
      this.errorFlag = "1";
      e.printStackTrace();
    }
    closeResouces();
    
    return result;
  }
}

package template.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import util.db.DB_Connector;

public class BaseDao {
	protected String errorFlag = null;
	protected Connection conn = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;
	protected CallableStatement proc = null;
	
	// 初始化dao變量
	protected void initResources() {
		try {
			errorFlag = "0";
			conn = DB_Connector.getConnection();
			ps = null;
			rs = null;
			conn.setAutoCommit(false);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	// 關閉dao變量
	protected void closeResources() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null && !conn.isClosed()) {
				if ("1".equals(errorFlag)) {
					conn.rollback();
				} else {
					conn.commit();
				}
				conn.setAutoCommit(true);
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// dao模板
	public String template() {
		String flag = "1";// 1成功，0失敗
		initResources();

		try {
			String sql = "";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "");
			//ps.executeUpdate();
			rs = ps.executeQuery();

			while (rs.next()) {
				rs.getString("");
			}
		} catch (SQLException e) {
			flag = "0";
			errorFlag = "1";
			e.printStackTrace();
		}
		closeResources();
		
		return flag;
	}
	
	// 調用存儲過程dao模板
	public String procedureTemplate(){
		 String flag = "1";// 1成功，0失敗
	     try {
			proc = conn.prepareCall("{ call HYQ.TESTB(?,?) }");
			proc.setString(1, "100");
			proc.registerOutParameter(2, Types.VARCHAR);
			proc.execute();
			flag = proc.getString(2);
		} catch (SQLException e) {
			errorFlag = "1";
			e.printStackTrace();
		} 
	     
	    return flag;
	}
}

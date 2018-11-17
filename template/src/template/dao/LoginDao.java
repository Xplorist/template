package template.dao;

import java.sql.SQLException;
import java.sql.Types;

public class LoginDao extends BaseDao {
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
	
	// 登陆
	public boolean login(String username, String password) {
		boolean flag = false;// 1成功，0失敗
		initResources();
		
		int count = 0;
		try {
			String sql = "SELECT count(*) count FROM user t "
					+ "where  t.username = ? and t.password = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			//ps.executeUpdate();
			rs = ps.executeQuery();
			
			while (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			errorFlag = "1";
			e.printStackTrace();
		}
		closeResources();
		if(count > 0) {
			flag = true;
		}
		
		return flag;
	}

	public LoginDao() {
		super();
	}
	
}

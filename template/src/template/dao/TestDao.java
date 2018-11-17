package template.dao;

import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import template.model.SendDeptBean;

/**
 *	測試dao
 * @author C3005579
 * @date 2018年11月17日 上午11:52:56 
 */
public class TestDao extends BaseDao {
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
	
	// 查詢分發單位
	public List<SendDeptBean> querySendDeptList() {
		List<SendDeptBean> result = new ArrayList<SendDeptBean>();
		//String flag = "1";// 1成功，0失敗
		initResources();

		try {
			String sql = "select t.*               \n"
					+"  from ER_SEND_DEPT t    \n"
					+" where t.bill_type = 'MR'\n"
					+"   and t.is_use = 'Y'    \n"
					+" order by t.dept_id asc  \n";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, "");
			//ps.executeUpdate();
			rs = ps.executeQuery();

			while (rs.next()) {
				SendDeptBean bean = new SendDeptBean();
				bean.setDept_id(rs.getString("dept_id"));
				bean.setBill_type(rs.getString("bill_type"));
				bean.setDept_name(rs.getString("dept_name"));
				bean.setCreate_date(rs.getString("create_date"));
				bean.setCreater(rs.getString("creater"));
				bean.setIs_use(rs.getString("is_use"));
				bean.setPkid(rs.getString("pkid"));
				result.add(bean);
			}
		} catch (SQLException e) {
			//flag = "0";
			errorFlag = "1";
			e.printStackTrace();
		}
		closeResources();
		
		return result;
	}

	public TestDao() {
		super();
	}
}



package template.controller;

import java.util.List;

import template.dao.TestDao;
import template.model.SendDeptBean;
import template.model.TemplateBean;
import template.model.UserBean;

/**
 *	測試action
 * @author C3005579
 * @date 2018年11月17日 上午11:50:39 
 */
public class TestAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private TestDao dao = new TestDao();// dao
	private String bill_type;// 單據類型
	
	// 模板action
	public void template() {
		result = dao.template();
		
		jsonObject.put("result", result);
		sendJson(jsonObject);
	}
	
	// MyBatis模板
	public void template4MyBatis() {
		result = dao.template4MyBtis();
		
		jsonObject.put("result", result);
		sendJson(jsonObject);
	}
	
	// 查询分发单位list
	public void querySendDept() {
		List<SendDeptBean> sendDeptList = dao.querySendDeptList(bill_type);
		
		jsonObject.put("sendDeptList", sendDeptList);
		sendJson(jsonObject);
	}
	
	// 查询用户list
	public void queryUserList() {
		List<UserBean> userList = dao.queryUserList();
		
		jsonObject.put("userList", userList);
		sendJson(jsonObject);
	}
	
	// MyBatis模板
	public void queryTemplateList() {
		List<TemplateBean> templateList = dao.queryTemplateList();
		
		jsonObject.put("templateList", templateList);
		sendJson(jsonObject);
	}
	
	// MyBatis模板
	public void queryTemplateList4Main() {
		List<TemplateBean> templateList = dao.queryTemplateList();
		
		int count = 0;
		for(TemplateBean bean : templateList) {
			count++;
			System.out.println("第" + count + "個name:" + bean.getName());
		}
	}

	public TestAction() {
		super();
	}

	public TestDao getDao() {
		return dao;
	}

	public void setDao(TestDao dao) {
		this.dao = dao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getBill_type() {
		return bill_type;
	}

	public void setBill_type(String bill_type) {
		this.bill_type = bill_type;
	}
	
}



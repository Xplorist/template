package template.controller;

import java.util.List;

import template.dao.TestDao;
import template.model.SendDeptBean;

/**
 *	測試action
 * @author C3005579
 * @date 2018年11月17日 上午11:50:39 
 */
public class TestAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private TestDao dao = new TestDao();// dao
	
	// 模板action
	public void template() {
		result = dao.template();
		
		jsonObject.put("result", result);
		sendJson(jsonObject);
	}
	
	// 模板action
	public void querySendDept() {
		List<SendDeptBean> sendDeptList = dao.querySendDeptList();
		
		jsonObject.put("sendDeptList", sendDeptList);
		sendJson(jsonObject);
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
	
}



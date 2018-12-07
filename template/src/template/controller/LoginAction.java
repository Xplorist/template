package template.controller;

import template.dao.LoginDao;

public class LoginAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private LoginDao dao = new LoginDao();
	private String username;// 用户名
	private String password;// 密码
	
	// dao模板
	public void template() {
		result = dao.template();
		
		jsonObject.put("result", result);
		sendJson(jsonObject);
	}
	
	// 登陆
	public void login() {
		boolean result = dao.login(username, password);
		
		jsonObject.put("result", result);
		sendJson(jsonObject);
	}

	public LoginAction() {
		super();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public LoginDao getDao() {
		return dao;
	}

	public void setDao(LoginDao dao) {
		this.dao = dao;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

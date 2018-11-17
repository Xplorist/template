package template.model;

/**
 *	分發單位bean
 * @author C3005579
 * @date 2018年11月17日 下午1:38:51 
 */
public class SendDeptBean {
	private String dept_id;//單位id
	private String bill_type;//單據類型（ER：評估報告，MR：耗材評估報告，SWR：swr執行單）
	private String dept_name;//單位名稱
	private String create_date;//創建時間
	private String creater;//創建人
	private String is_use;//是否有效
	private String pkid;//主鍵id
	public SendDeptBean() {
		super();
	}
	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}
	public String getBill_type() {
		return bill_type;
	}
	public void setBill_type(String bill_type) {
		this.bill_type = bill_type;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public String getIs_use() {
		return is_use;
	}
	public void setIs_use(String is_use) {
		this.is_use = is_use;
	}
	public String getPkid() {
		return pkid;
	}
	public void setPkid(String pkid) {
		this.pkid = pkid;
	}

}



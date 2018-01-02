package multi.admin.vo;

public class Admin_HostVO {
	public Admin_HostVO(){}
	public Admin_HostVO(String cRN, String user_id, String host_name, String host_account, String zipcode) {
		CRN = cRN;
		this.user_id = user_id;
		this.host_name = host_name;
		this.host_account = host_account;
		this.zipcode = zipcode;
	}
	public String getCRN() {
		return CRN;
	}
	public void setCRN(String cRN) {
		CRN = cRN;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getHost_name() {
		return host_name;
	}
	public void setHost_name(String host_name) {
		this.host_name = host_name;
	}
	public String getHost_account() {
		return host_account;
	}
	public void setHost_account(String host_account) {
		this.host_account = host_account;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	private String CRN = null;
	private String user_id = null;
	private String host_name = null;
	private String host_account = null;
	private String zipcode = null;
}

package multi.admin.vo;

public class Admin_UserVO {
	public Admin_UserVO(){}

	private String user_id = null;
	public Admin_UserVO(String user_id, String sSN1, String sSN2, String passwd, String user_name, String gender,
			String phone, String nickname, String zipcode, String email, String grade) {
		this.user_id = user_id;
		SSN1 = sSN1;
		SSN2 = sSN2;
		this.passwd = passwd;
		this.user_name = user_name;
		this.gender = gender;
		this.phone = phone;
		this.nickname = nickname;
		this.zipcode = zipcode;
		this.email = email;
		this.grade = grade;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getSSN1() {
		return SSN1;
	}
	public void setSSN1(String sSN1) {
		SSN1 = sSN1;
	}
	public String getSSN2() {
		return SSN2;
	}
	public void setSSN2(String sSN2) {
		SSN2 = sSN2;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}

	private String SSN1 = null;
	private String SSN2 = null;
	private String passwd = null;
	private String user_name = null;
	private String gender = null;
	private String phone = null;
	private String nickname = null;
	private String zipcode = null;
	private String email = null;
	private String grade = null;
}

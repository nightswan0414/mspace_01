package multi.admin.vo;

public class Admin_ClubVO {
	public Admin_ClubVO(){}
	
	public Integer getClub_no() {
		return club_no;
	}
	public void setClub_no(Integer club_no) {
		this.club_no = club_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getClub_name() {
		return club_name;
	}
	public void setClub_name(String club_name) {
		this.club_name = club_name;
	}
	public String getClub_title() {
		return club_title;
	}
	public void setClub_title(String club_title) {
		this.club_title = club_title;
	}
	public String getClub_content() {
		return club_content;
	}
	public void setClub_content(String club_content) {
		this.club_content = club_content;
	}
	public String getClub_thumb_img() {
		return club_thumb_img;
	}
	public void setClub_thumb_img(String club_thumb_img) {
		this.club_thumb_img = club_thumb_img;
	}
	public Integer getMax_member() {
		return max_member;
	}
	public void setMax_member(Integer max_member) {
		this.max_member = max_member;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getL_category_no() {
		return l_category_no;
	}
	public void setL_category_no(String l_category_no) {
		this.l_category_no = l_category_no;
	}
	public String getC_category_no() {
		return c_category_no;
	}
	public void setC_category_no(String c_category_no) {
		this.c_category_no = c_category_no;
	}

	public Admin_ClubVO(Integer club_no, String user_id, String club_name, String club_title, String club_content,
			String club_thumb_img, Integer max_member, String create_time, String l_category_no, String c_category_no) {
		this.club_no = club_no;
		this.user_id = user_id;
		this.club_name = club_name;
		this.club_title = club_title;
		this.club_content = club_content;
		this.club_thumb_img = club_thumb_img;
		this.max_member = max_member;
		this.create_time = create_time;
		this.l_category_no = l_category_no;
		this.c_category_no = c_category_no;
	}

	private Integer club_no = null;
	private String user_id = null;
	private String club_name = null;
	private String club_title = null;
	private String club_content = null;
	private String club_thumb_img = null;
	private Integer max_member = null;
	private String create_time = null;
	private String l_category_no = null;
	private String c_category_no = null;
}

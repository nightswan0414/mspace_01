package multi.admin.dao;

import java.util.List;

import multi.admin.vo.Admin_UserVO;

public interface Admin_UserDAO {
	public List<Admin_UserVO> user_findAll() throws Exception;
	public Admin_UserVO user_check( Admin_UserVO uvo ) throws Exception;
	public Admin_UserVO user_del( Admin_UserVO uvo ) throws Exception;
}

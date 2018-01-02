package multi.admin.dao;

import java.util.List;

import multi.admin.vo.Admin_HostVO;
import multi.admin.vo.Admin_UserVO;

public interface Admin_HostDAO {
	public List<Admin_HostVO> host_findAll() throws Exception;
	public List<Admin_HostVO> host_request_findAll() throws Exception;
	public Admin_HostVO host_check( Admin_HostVO uvo ) throws Exception;
	public Admin_HostVO host_del( Admin_HostVO uvo ) throws Exception;
}

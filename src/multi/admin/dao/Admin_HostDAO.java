package multi.admin.dao;

import java.util.List;

import main.vo.HostApplyVO;
import main.vo.HostVO;
import main.vo.UserVO;


public interface Admin_HostDAO {
	public List<HostVO> host_findAll() throws Exception;
	public List<HostApplyVO> host_request_findAll() throws Exception;
	public HostApplyVO host_check( HostApplyVO uvo ) throws Exception;
	
	public int host_user_accept ( HostApplyVO hvo ) throws Exception;
	public int host_user_refuse ( HostApplyVO hvo ) throws Exception;
	public int host_user_remove_request( HostApplyVO hvo) throws Exception;
	
	public int host_user_downgrade ( HostVO hvo ) throws Exception;
	public int host_user_remove ( HostVO hvo ) throws Exception;
	
	public UserVO host_user_check ( HostVO hvo ) throws Exception;
	
	
	
}

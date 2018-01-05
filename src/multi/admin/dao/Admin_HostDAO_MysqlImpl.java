package multi.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import multi.admin.vo.Admin_HostApplyVO;
import multi.admin.vo.Admin_HostVO;
import multi.admin.vo.Admin_UserVO;

public class Admin_HostDAO_MysqlImpl implements Admin_HostDAO {
	@Autowired @Qualifier("sqlSession")
	private SqlSession sqlSession = null;
	
	@Override
	public List<Admin_HostVO> host_findAll() throws Exception {
		return sqlSession.selectList("admin_host.p_admin_host_findAll");
	}
	
	@Override
	public List<Admin_HostApplyVO> host_request_findAll() throws Exception {
		return sqlSession.selectList("admin_host.p_admin_host_request_findAll");
	}

	@Override
	public Admin_HostApplyVO host_check( Admin_HostApplyVO hvo) throws Exception {
		return sqlSession.selectOne("admin_host.p_admin_host_one_person_check", hvo);
	}
	
	@Override
	public int host_user_accept( Admin_HostApplyVO hvo) throws Exception {
		return sqlSession.update("admin_host.p_admin_host_user_accept",hvo);
	}
	
	@Override
	public int host_user_refuse(Admin_HostApplyVO hvo) throws Exception {
		return sqlSession.delete("admin_host.p_admin_host_user_refuse",hvo);
	}
	
	@Override
	public int host_user_remove_request(Admin_HostApplyVO hvo) throws Exception {
		return sqlSession.delete("admin_host.p_admin_host_user_remove_request",hvo);
	}

	@Override
	public Admin_UserVO host_user_check( Admin_HostVO hvo) throws Exception {
		return sqlSession.selectOne("admin_host.p_admin_host_user_findUserInfo",hvo);
	}
	





	@Override
	public int host_user_downgrade(Admin_HostVO hvo) throws Exception {
		return sqlSession.update("admin_host.p_admin_host_user_downgrade",hvo);
	}

	@Override
	public int host_user_remove(Admin_HostVO hvo) throws Exception {
		return sqlSession.delete("admin_host.p_admin_host_user_remove",hvo);
	}

	
	



}

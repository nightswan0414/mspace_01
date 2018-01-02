package multi.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

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
	public List<Admin_HostVO> host_request_findAll() throws Exception {
		return sqlSession.selectList("admin_host.p_admin_host_request_findAll");
	}

	@Override
	public Admin_HostVO host_check( Admin_HostVO hvo) throws Exception {
		return sqlSession.selectOne("admin_host.p_admin_host_one_person_check", hvo);
	}

	@Override
	public Admin_HostVO host_del( Admin_HostVO hvo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



}

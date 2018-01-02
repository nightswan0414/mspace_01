package multi.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import multi.admin.vo.Admin_UserVO;

public class Admin_UserDAO_MysqlImpl implements Admin_UserDAO {
	@Autowired @Qualifier("sqlSession")
	private SqlSession sqlSession = null;
	
	@Override
	public List<Admin_UserVO> user_findAll() throws Exception {
		return sqlSession.selectList("admin_user.p_admin_user_findAll");
	}

	@Override
	public Admin_UserVO user_check(Admin_UserVO uvo) throws Exception {
		return sqlSession.selectOne("admin_user.p_admin_user_findUser",uvo);
	}

	@Override
	public Admin_UserVO user_del(Admin_UserVO uvo) throws Exception {
		return sqlSession.selectOne("admin_user.p_admin_user_DelUser",uvo);
	}

}

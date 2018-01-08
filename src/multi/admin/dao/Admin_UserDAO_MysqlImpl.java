package multi.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import main.vo.UserVO;

public class Admin_UserDAO_MysqlImpl implements Admin_UserDAO {
	@Autowired @Qualifier("sqlSession")
	private SqlSession sqlSession = null;
	
	@Override
	public List<UserVO> user_findAll() throws Exception {
		return sqlSession.selectList("admin_user.p_admin_user_findAll");
	}

	@Override
	public UserVO user_check(UserVO uvo) throws Exception {
		return sqlSession.selectOne("admin_user.p_admin_user_findUser",uvo);
	}

	@Override
	public UserVO user_del(UserVO uvo) throws Exception {
		return sqlSession.selectOne("admin_user.p_admin_user_DelUser",uvo);
	}

	@Override
	public int user_modify(UserVO uvo) throws Exception {
		return sqlSession.update("admin_user.p_admin_user_modifyUser",uvo);
	}

}

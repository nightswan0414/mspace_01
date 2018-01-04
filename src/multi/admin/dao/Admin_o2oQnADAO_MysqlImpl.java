package multi.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import multi.admin.vo.Admin_o2oQnAVO;

public class Admin_o2oQnADAO_MysqlImpl implements Admin_o2oQnADAO{
	@Autowired @Qualifier("sqlSession")
	private SqlSession sqlSession = null;
	
	@Override
	public List<Admin_o2oQnAVO> findAllAskWithNoRe() throws Exception {
		return sqlSession.selectList("admin_o2oQnA.p_admin_o2oQnA_findAll_noRe");
	}

	@Override
	public List<Admin_o2oQnAVO> findAllAskWithRe() throws Exception {
		return sqlSession.selectList("admin_o2oQnA.p_admin_o2oQnA_findAll_Re");
	}
	
	@Override
	public int addAsking( Admin_o2oQnAVO ovo ) throws Exception {
		return sqlSession.insert("admin_o2oQnA.p_admin_o2oQnA_add", ovo );
	}

	@Override
	public Admin_o2oQnAVO check_oneAsking(Admin_o2oQnAVO ovo) throws Exception {
		return sqlSession.selectOne("admin_o2oQnA.p_admin_o2oQnA_checkOne",ovo);
	}



}

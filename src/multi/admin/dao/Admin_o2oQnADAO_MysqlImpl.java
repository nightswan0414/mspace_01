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
	public List<Admin_o2oQnAVO> findAllAsk() throws Exception {
		return null;
	}

	@Override
	public int addAsking( Admin_o2oQnAVO ovo ) throws Exception {
		return sqlSession.insert("admin_o2oQnA.p_o2oQnA_add", ovo );
	}

	@Override
	public Admin_o2oQnAVO check_oneAsking(Admin_o2oQnAVO ovo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

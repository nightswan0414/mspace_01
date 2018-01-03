package multi.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import multi.admin.vo.Admin_FaqVO;

public class Admin_FaqDAO_MysqlImpl implements Admin_FaqDAO {
	
	@Autowired @Qualifier("sqlSession")
	private SqlSession sqlSession = null;
	
	@Override
	public List<Admin_FaqVO> findAll() throws Exception {
		return sqlSession.selectList("admin_faq.p_admin_faq_FindAllTexts");
	}
	
	@Override
	public Admin_FaqVO faq_read(Admin_FaqVO fvo) throws Exception {
		return sqlSession.selectOne("admin_faq.p_admin_faq_readFaq",fvo);
	}

	@Override
	public int faq_modify(Admin_FaqVO fvo) throws Exception {
		return sqlSession.update("admin_faq.p_admin_faq_modifyFaq",fvo);
	}

	@Override
	public int faq_remove(Admin_FaqVO fvo) throws Exception {
		return sqlSession.delete("admin_faq.p_admin_faq_delFaq",fvo);
	}
	
	@Override
	public int faq_add(Admin_FaqVO fvo) throws Exception {
		return sqlSession.insert("admin_faq.p_admin_faq_addFaq",fvo);
	}




	


	

}

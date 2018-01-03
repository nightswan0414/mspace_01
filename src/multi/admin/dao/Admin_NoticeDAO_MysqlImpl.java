package multi.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import multi.admin.vo.Admin_NoticeVO;

public class Admin_NoticeDAO_MysqlImpl implements Admin_NoticeDAO {
	
	@Autowired @Qualifier("sqlSession")
	private SqlSession sqlSession = null;
	
	@Override
	public List<Admin_NoticeVO> findAll() throws Exception {
		return sqlSession.selectList("admin_notice.p_admin_notice_FindAllTexts");
	}

	@Override
	public Admin_NoticeVO findByPK(Admin_NoticeVO pvo) throws Exception {
		return sqlSession.selectOne("admin_notice.p_admin_notice_FindText",pvo);
	}
	
	@Override
	public int add(Admin_NoticeVO pvo) throws Exception {
		return sqlSession.insert("admin_notice.p_admin_notice_AddText",pvo);
	}

	@Override
	public int mod(Admin_NoticeVO pvo) throws Exception {
		return sqlSession.update("admin_notice.p_admin_notice_modText",pvo);
	}

	@Override
	public int delByPK(Admin_NoticeVO pvo) throws Exception {
		return sqlSession.delete("admin_notice.p_admin_notice_DelByPK",pvo);
	}
}

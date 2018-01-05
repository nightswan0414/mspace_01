package multi.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import multi.admin.vo.Admin_ClubVO;

public class Admin_ClubDAO_MysqlImpl implements Admin_ClubDAO {
	@Autowired @Qualifier("sqlSession")
	private SqlSession sqlSession = null;
	
	@Override
	public List<Admin_ClubVO> findAllClub() throws Exception {
		return sqlSession.selectList("admin_club.p_admin_club_FindAllClubs");
	}

	@Override
	public int removeClub(Admin_ClubVO cvo) throws Exception {
		return sqlSession.delete("admin_club.p_admin_club_Remove",cvo);
	}

	@Override
	public Admin_ClubVO check_specific_Club(Admin_ClubVO cvo) throws Exception {
		return sqlSession.selectOne("admin_club.p_admin_club_FindSpecificClub", cvo);
	}

}

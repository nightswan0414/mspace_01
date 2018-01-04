package multi.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import multi.admin.vo.Admin_SpaceVO;

public class Admin_SpaceDAO_MysqlImpl implements Admin_SpaceDAO{
	@Autowired @Qualifier("sqlSession")
	private SqlSession sqlSession = null;
	
	public List<Admin_SpaceVO> findHostPlaces( Admin_SpaceVO svo ) throws Exception {
		return sqlSession.selectList("admin_space.p_admin_host_space_check",svo);
	}

	@Override
	public List<Admin_SpaceVO> findAllPlacesCreatedDesc(Admin_SpaceVO svo) throws Exception {
		return sqlSession.selectList("admin_space.p_admin_space_created_desc");
	}

	@Override
	public List<Admin_SpaceVO> findAllPlacesCreatedAsc(Admin_SpaceVO svo) throws Exception {
		return sqlSession.selectList("admin_space.p_admin_space_created_asc");
	}

	@Override
	public List<Admin_SpaceVO> findAllPlacesPriceDesc(Admin_SpaceVO svo) throws Exception {
		return sqlSession.selectList("admin_space.p_admin_space_price_desc");
	}

	@Override
	public List<Admin_SpaceVO> findAllPlacesPriceAsc(Admin_SpaceVO svo) throws Exception {
		return sqlSession.selectList("admin_space.p_admin_space_price_asc");
	}

}

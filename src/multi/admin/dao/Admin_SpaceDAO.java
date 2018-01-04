package multi.admin.dao;

import java.util.List;
import multi.admin.vo.Admin_SpaceVO;

public interface Admin_SpaceDAO {
	public List<Admin_SpaceVO> findHostPlaces( Admin_SpaceVO svo ) throws Exception;
	public List<Admin_SpaceVO> findAllPlacesCreatedDesc( Admin_SpaceVO svo ) throws Exception;	
	public List<Admin_SpaceVO> findAllPlacesCreatedAsc( Admin_SpaceVO svo ) throws Exception;
	public List<Admin_SpaceVO> findAllPlacesPriceDesc( Admin_SpaceVO svo ) throws Exception;	
	public List<Admin_SpaceVO> findAllPlacesPriceAsc( Admin_SpaceVO svo ) throws Exception;
}

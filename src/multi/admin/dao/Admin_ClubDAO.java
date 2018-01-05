package multi.admin.dao;

import java.util.List;

import multi.admin.vo.Admin_ClubVO;

public interface Admin_ClubDAO {
	public List<Admin_ClubVO> findAllClub() throws Exception;
	public int removeClub( Admin_ClubVO cvo ) throws Exception;
	public Admin_ClubVO check_specific_Club( Admin_ClubVO cvo ) throws Exception;
}

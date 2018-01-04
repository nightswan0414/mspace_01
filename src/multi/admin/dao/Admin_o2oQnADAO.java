package multi.admin.dao;

import java.util.List;

import multi.admin.vo.Admin_o2oQnAVO;

public interface Admin_o2oQnADAO {
	public List<Admin_o2oQnAVO> findAllAskWithNoRe() throws Exception;
	public List<Admin_o2oQnAVO> findAllAskWithRe() throws Exception;
	public int addAsking ( Admin_o2oQnAVO ovo ) throws Exception;
	public Admin_o2oQnAVO check_oneAsking ( Admin_o2oQnAVO ovo ) throws Exception;
}

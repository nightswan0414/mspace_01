package multi.admin.dao;

import java.util.List;

import multi.admin.vo.Admin_NoticeVO;

public interface Admin_NoticeDAO {
	public List<Admin_NoticeVO> findAll() throws Exception;
	public Admin_NoticeVO findByPK(Admin_NoticeVO pvo) throws Exception;
	public int add(Admin_NoticeVO pvo) throws Exception;
	public int mod(Admin_NoticeVO pvo) throws Exception;
	public int delByPK(Admin_NoticeVO pvo) throws Exception;
}

package multi.admin.dao;

import java.util.List;

import main.vo.NoticeVO;


public interface Admin_NoticeDAO {
	public List<NoticeVO> findAll() throws Exception;
	public NoticeVO findByPK(NoticeVO pvo) throws Exception;
	public int add(NoticeVO pvo) throws Exception;
	public int mod(NoticeVO pvo) throws Exception;
	public int delByPK(NoticeVO pvo) throws Exception;
}

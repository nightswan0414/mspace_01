package multi.admin.dao;

import java.util.List;

import main.vo.FaqVO;

public interface Admin_FaqDAO {
	
	public List<FaqVO> findAll() throws Exception;
	public FaqVO faq_read( FaqVO fvo ) throws Exception;
	public int faq_modify( FaqVO fvo ) throws Exception;
	public int faq_remove( FaqVO fvo ) throws Exception;
	public int faq_add( FaqVO fvo ) throws Exception;
}

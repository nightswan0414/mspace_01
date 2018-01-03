package multi.admin.dao;
//±è¼Ò¿µ
import java.util.List;

import multi.admin.vo.Admin_FaqVO;

public interface Admin_FaqDAO {
	
	public List<Admin_FaqVO> findAll() throws Exception;
	public Admin_FaqVO faq_read( Admin_FaqVO fvo ) throws Exception;
	public int faq_modify( Admin_FaqVO fvo ) throws Exception;
	public int faq_remove( Admin_FaqVO fvo ) throws Exception;
	public int faq_add( Admin_FaqVO fvo ) throws Exception;
}

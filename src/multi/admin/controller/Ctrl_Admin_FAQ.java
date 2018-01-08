package multi.admin.controller;

import static main.Single.i;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import main.Controller;
import main.ModelAndView;
import main.ModelAttribute;
import main.RequestMapping;
import main.vo.FaqVO;
import multi.admin.dao.Admin_FaqDAO;

/* 
FAQ ����

FAQ ����Ʈ Ȯ���ϴ� ������
Ư�� FAQ�� �д� ������
Ư�� FAQ�� ���� �� ó��. �����̷�Ʈ �� FAQ ����Ʈ Ȯ���ϴ� ������
Ư�� FAQ�� ���� �� �̿�. �����̷�Ʈ �� FAQ ����Ʈ Ȯ���ϴ� ������
FAQ �߰� ������
FAQ �߰� �� ó��. �����̷�Ʈ �� FAQ ����Ʈ Ȯ���ϴ� ������
 */

@Controller
public class Ctrl_Admin_FAQ {
	@Autowired @Qualifier("admin_FaqDAO")
	private Admin_FaqDAO admin_FaqDAO = null;
		
	// FAQ ����Ʈ Ȯ���ϴ� ������
	@RequestMapping("/admin_faq.do")
	public ModelAndView admin_faq() throws Exception {
		ModelAndView mnv = new ModelAndView("admin_faq");
		List<FaqVO> rl = admin_FaqDAO.findAll();
		mnv.addObject("rl", rl);
		return mnv;
	}
	// Ư�� FAQ�� �д� ������
	@RequestMapping("/admin_faq_read.do")
	public ModelAndView admin_faq_read( @ModelAttribute FaqVO fvo ) throws Exception {
		ModelAndView mnv = new ModelAndView("admin_faq_read");
		FaqVO vo = admin_FaqDAO.faq_read(fvo);
		mnv.addObject("vo", vo);
		return mnv;
	}
	// Ư�� FAQ�� ���� �� ó��. �����̷�Ʈ �� FAQ ����Ʈ Ȯ���ϴ� ������
	@RequestMapping("/admin_faq_mod.do")
	public ModelAndView admin_faq_mod( @ModelAttribute FaqVO fvo ) throws Exception {
		ModelAndView mnv = new ModelAndView();
		admin_FaqDAO.faq_modify(fvo);
		mnv.setViewName("redirect:/admin_faq.do");
		return mnv;
	}
	// Ư�� FAQ�� ���� �� �̿�. �����̷�Ʈ �� FAQ ����Ʈ Ȯ���ϴ� ������
	@RequestMapping("/admin_faq_remove.do")
	public ModelAndView admin_faq_remove( @ModelAttribute FaqVO fvo ) throws Exception {
		ModelAndView mnv = new ModelAndView();
		i(fvo.getFaq_no());
		admin_FaqDAO.faq_remove(fvo);
		mnv.setViewName("redirect:/admin_faq.do");
		return mnv;
	}
	// FAQ �߰� ������
	@RequestMapping("/admin_faq_add.do")
	public ModelAndView admin_faq_add( ) throws Exception {
		ModelAndView mnv = new ModelAndView("admin_faq_add");
		return mnv;
	}
	// FAQ �߰� �� ó��. �����̷�Ʈ �� FAQ ����Ʈ Ȯ���ϴ� ������
	@RequestMapping("/admin_faq_add2.do")
	public ModelAndView admin_faq_add2( @ModelAttribute FaqVO fvo ) throws Exception {
		ModelAndView mnv = new ModelAndView();
		admin_FaqDAO.faq_add(fvo);
		mnv.setViewName("redirect:/admin_faq.do");
		return mnv;
	}
	
}
package multi.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import main.Controller;
import main.ModelAndView;
import main.ModelAttribute;
import main.RequestMapping;
import main.vo.UserVO;
import multi.admin.dao.Admin_UserDAO;


/* 
�ɹ� ����

���� ����Ʈ ������
Ư�� ���� Ŭ���� Ȯ�� ������
Ư�� ���� ����. �����̷�Ʈ ���� ����Ʈ ������
���� ���� ���� ������. Ư�� ���� ���� �ҷ���
���� ���� ���� ���������� ���� ���� ���� �Ϸ� ��. �����̷�Ʈ ���� ����Ʈ ������.
���� ��� ������. �̱���. ���� �ϳ� ��ü
 */

@Controller
public class Ctrl_Admin_Users {
	@Autowired @Qualifier("admin_UserDAO")
	private Admin_UserDAO admin_UserDAO = null;
	
	// ���� ����Ʈ ������
	@RequestMapping("/admin_users.do")
	public ModelAndView admin_users() throws Exception {
		ModelAndView mnv = new ModelAndView("admin_users");
		List<UserVO> ls = admin_UserDAO.user_findAll();
		mnv.addObject("ls", ls);
		return mnv;
	}
	// Ư�� ���� Ŭ���� Ȯ�� ������
	@RequestMapping("/admin_user_check.do")
	public ModelAndView admin_user_check( @ModelAttribute UserVO uvo ) throws Exception {
		ModelAndView mnv = new ModelAndView("admin_user_check");
		UserVO vo = admin_UserDAO.user_check(uvo);
		mnv.addObject("vo", vo);
		return mnv;
	}
	// Ư�� ���� ����. �����̷�Ʈ ���� ����Ʈ ������
	@RequestMapping("/admin_user_del.do")
	public ModelAndView admin_user_del( @ModelAttribute UserVO uvo ) throws Exception {
		ModelAndView mnv = new ModelAndView();
		admin_UserDAO.user_del(uvo);
		mnv.setViewName("redirect:/admin_users.do");
		return mnv;
	}
	// ���� ���� ���� ������. Ư�� ���� ���� �ҷ���
	@RequestMapping("/admin_user_mod.do")
	public ModelAndView admin_user_mod( @ModelAttribute UserVO uvo ) throws Exception {
		ModelAndView mnv = new ModelAndView("admin_user_mod");
		UserVO vo = admin_UserDAO.user_check(uvo);
		mnv.addObject("vo", vo);
		return mnv;
	}
	// ���� ���� ���� ���������� ���� ���� ���� �Ϸ� ��. �����̷�Ʈ ���� ����Ʈ ������.
	@RequestMapping("/admin_user_mod2.do")
	public ModelAndView admin_user_mod2( @ModelAttribute UserVO uvo ) throws Exception {
		ModelAndView mnv = new ModelAndView();
		admin_UserDAO.user_modify(uvo);
		mnv.setViewName("redirect:/admin_users.do");
		return mnv;
	}
	// ���� ��� ������. �̱���. ���� �ϳ� ��ü
	@RequestMapping("/admin_user_stastic.do")
	public ModelAndView admin_user_stastic() throws Exception {
		ModelAndView mnv = new ModelAndView("admin_user_stastic");
		return mnv;
	}
	
}
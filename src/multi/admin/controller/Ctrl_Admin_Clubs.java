package multi.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import main.Controller;
import main.ModelAndView;
import main.ModelAttribute;
import main.RequestMapping;
import main.vo.ClubVO;
import multi.admin.dao.Admin_ClubDAO;

/* 
���� ����

���� ����Ʈ Ȯ�� ������
Ư�� ���� ������ �̿�. �����̷�Ʈ �� ���� ����Ʈ Ȯ�� ������
Ư�� ���� ������ Ȯ���ϴ� ������
 */

@Controller
public class Ctrl_Admin_Clubs {
	@Autowired @Qualifier("admin_ClubDAO")
	private Admin_ClubDAO admin_ClubDAO = null;
	
	// ���� ����Ʈ Ȯ�� ������
	@RequestMapping("/admin_clubs.do")
	public ModelAndView admin_clubs( @ModelAttribute ClubVO cvo ) throws Exception {
		ModelAndView mnv = new ModelAndView("admin_clubs");
		List<ClubVO> ls = admin_ClubDAO.findAllClub();
		mnv.addObject("ls", ls);
		
		return mnv;
	}
	// Ư�� ���� ������ �̿�. �����̷�Ʈ �� ���� ����Ʈ Ȯ�� ������
	@RequestMapping("/admin_club_remove.do")
	public ModelAndView admin_club_remove( @ModelAttribute ClubVO cvo ) throws Exception {
		ModelAndView mnv = new ModelAndView();
		admin_ClubDAO.removeClub(cvo);
		mnv.setViewName("redirect:/admin_clubs.do");
		return mnv;
	}
	// Ư�� ���� ������ Ȯ���ϴ� ������
	@RequestMapping("/admin_club_detail.do")
	public ModelAndView admin_club_detail( @ModelAttribute ClubVO cvo ) throws Exception {
		ModelAndView mnv = new ModelAndView("admin_club_detail");
		ClubVO vo = admin_ClubDAO.check_specific_Club(cvo);
		mnv.addObject("vo", vo);
		return mnv;
	}
}
package multi.admin.controller;

import java.util.List;
import static main.Single.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import main.Controller;
import main.ModelAndView;
import main.ModelAttribute;
import main.RequestMapping;
import main.RequestParam;
import multi.admin.dao.Admin_ClubDAO;
import multi.admin.dao.Admin_FaqDAO;
import multi.admin.dao.Admin_HostDAO;
import multi.admin.dao.Admin_NoticeDAO;
import multi.admin.dao.Admin_SpaceDAO;
import multi.admin.dao.Admin_UserDAO;
import multi.admin.dao.Admin_o2oQnADAO;
import multi.admin.vo.Admin_ClubVO;
import multi.admin.vo.Admin_FaqVO;
import multi.admin.vo.Admin_HostVO;
import multi.admin.vo.Admin_NoticeVO;
import multi.admin.vo.Admin_SpaceVO;
import multi.admin.vo.Admin_UserVO;
import multi.admin.vo.Admin_o2oQnAVO;

/* 
葛烙 包府
 */

@Controller
public class Ctrl_Admin_Clubs {
	@Autowired @Qualifier("admin_ClubDAO")
	private Admin_ClubDAO admin_ClubDAO = null;
	
	// 葛烙 包府
	@RequestMapping("/admin_clubs.do")
	public ModelAndView admin_clubs( @ModelAttribute Admin_ClubVO cvo ) throws Exception {
		ModelAndView mnv = new ModelAndView("admin_clubs");
		List<Admin_ClubVO> ls = admin_ClubDAO.findAllClub();
		mnv.addObject("ls", ls);
		
		return mnv;
	}
	
	@RequestMapping("/admin_club_remove.do")
	public ModelAndView admin_club_remove( @ModelAttribute Admin_ClubVO cvo ) throws Exception {
		ModelAndView mnv = new ModelAndView();
		admin_ClubDAO.removeClub(cvo);
		mnv.setViewName("redirect:/admin_clubs.do");
		return mnv;
	}
	
	@RequestMapping("/admin_club_detail.do")
	public ModelAndView admin_club_detail( @ModelAttribute Admin_ClubVO cvo ) throws Exception {
		ModelAndView mnv = new ModelAndView("admin_club_detail");
		Admin_ClubVO vo = admin_ClubDAO.check_specific_Club(cvo);
		mnv.addObject("vo", vo);
		return mnv;
	}
}
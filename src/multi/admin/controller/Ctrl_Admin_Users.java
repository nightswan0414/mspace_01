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
import multi.admin.dao.Admin_FaqDAO;
import multi.admin.dao.Admin_HostDAO;
import multi.admin.dao.Admin_NoticeDAO;
import multi.admin.dao.Admin_SpaceDAO;
import multi.admin.dao.Admin_UserDAO;
import multi.admin.dao.Admin_o2oQnADAO;
import multi.admin.vo.Admin_FaqVO;
import multi.admin.vo.Admin_HostVO;
import multi.admin.vo.Admin_NoticeVO;
import multi.admin.vo.Admin_SpaceVO;
import multi.admin.vo.Admin_UserVO;
import multi.admin.vo.Admin_o2oQnAVO;

/* 
干滚 包府
 */

@Controller
public class Ctrl_Admin_Users {
	@Autowired @Qualifier("admin_UserDAO")
	private Admin_UserDAO admin_UserDAO = null;
	@Autowired @Qualifier("admin_HostDAO")
	private Admin_HostDAO admin_HostDAO = null;
	@Autowired @Qualifier("admin_SpaceDAO")
	private Admin_SpaceDAO admin_SpaceDAO = null;
	@Autowired @Qualifier("admin_NoticeDAO")
	private Admin_NoticeDAO admin_NoticeDAO = null;
	@Autowired @Qualifier("admin_FaqDAO")
	private Admin_FaqDAO admin_FaqDAO = null;
	@Autowired @Qualifier("admin_o2oQnADAO")
	private Admin_o2oQnADAO admin_o2oQnADAO = null;
	
	// 干滚 包府
	@RequestMapping("/admin_users.do")
	public ModelAndView admin_users() throws Exception {
		ModelAndView mnv = new ModelAndView("admin_users");
		List<Admin_UserVO> ls = admin_UserDAO.user_findAll();
		mnv.addObject("ls", ls);
		return mnv;
	}
	
	@RequestMapping("/admin_user_check.do")
	public ModelAndView admin_user_check( @ModelAttribute Admin_UserVO uvo ) throws Exception {
		ModelAndView mnv = new ModelAndView("admin_user_check");
		Admin_UserVO vo = admin_UserDAO.user_check(uvo);
		mnv.addObject("vo", vo);
		return mnv;
	}
	
	@RequestMapping("/admin_user_del.do")
	public ModelAndView admin_user_del( @ModelAttribute Admin_UserVO uvo ) throws Exception {
		ModelAndView mnv = new ModelAndView();
		admin_UserDAO.user_del(uvo);
		mnv.setViewName("redirect:/admin_users.do");
		return mnv;
	}
	@RequestMapping("/admin_user_mod.do")
	public ModelAndView admin_user_mod( @ModelAttribute Admin_UserVO uvo ) throws Exception {
		ModelAndView mnv = new ModelAndView("admin_user_mod");
		Admin_UserVO vo = admin_UserDAO.user_check(uvo);
		mnv.addObject("vo", vo);
		return mnv;
	}
	
	@RequestMapping("/admin_user_mod2.do")
	public ModelAndView admin_user_mod2( @ModelAttribute Admin_UserVO uvo ) throws Exception {
		ModelAndView mnv = new ModelAndView();
		admin_UserDAO.user_modify(uvo);
		mnv.setViewName("redirect:/admin_users.do");
		return mnv;
	}
	@RequestMapping("/admin_user_stastic.do")
	public ModelAndView admin_user_stastic() throws Exception {
		ModelAndView mnv = new ModelAndView("admin_user_stastic");
		return mnv;
	}
	
}
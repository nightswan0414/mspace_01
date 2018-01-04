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
공지사항 관리
 */

@Controller
public class Ctrl_Admin_Notices {
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
	
	// 공지사항 관리
	@RequestMapping("/admin_notice_list.do")
	public ModelAndView textList() throws Exception {
		List<Admin_NoticeVO> rl = admin_NoticeDAO.findAll();
		ModelAndView mnv=new ModelAndView("admin_notice_list");
		mnv.addObject("rl",rl);
		return mnv;
	}

	@RequestMapping("/admin_notice_read.do")
	public ModelAndView textRead(@ModelAttribute Admin_NoticeVO pvo) throws Exception {
		
		Admin_NoticeVO vo = admin_NoticeDAO.findByPK(pvo);
		ModelAndView mnv=new ModelAndView("admin_notice_read");
		mnv.addObject("vo",vo);

		return mnv;
	}
	
	@RequestMapping("/admin_notice_add.do")
	public ModelAndView textAdd(@ModelAttribute Admin_NoticeVO pvo) throws Exception {
		ModelAndView mnv=new ModelAndView("admin_notice_add");
		return mnv;
	}
	
	@RequestMapping("/admin_notice_add2.do")
	public String textAdd2(@ModelAttribute Admin_NoticeVO pvo) throws Exception {
		admin_NoticeDAO.add(pvo);
		return "redirect:/admin_notice_list.do";
	}
	
	@RequestMapping("/admin_notice_mod.do")
	public ModelAndView mod(@ModelAttribute Admin_NoticeVO pvo) throws Exception {
		ModelAndView mnv=new ModelAndView("admin_notice_mod");
		mnv.addObject("vo", pvo);
		return mnv;
	}
	
	@RequestMapping("/admin_notice_mod2.do")
	public String mod2(@ModelAttribute Admin_NoticeVO pvo) throws Exception {
		
		admin_NoticeDAO.mod(pvo);
		return "redirect:/admin_notice_read.do?notice_no="+pvo.getNotice_no();
	}
	
	@RequestMapping("/admin_notice_del.do")
	public String del(@ModelAttribute Admin_NoticeVO pvo) throws Exception {
		admin_NoticeDAO.delByPK(pvo);
		return "redirect:/admin_notice_list.do";
	}
	
}
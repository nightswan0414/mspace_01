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
import multi.admin.dao.Admin_UserDAO;
import multi.admin.dao.Admin_o2oQnADAO;
import multi.admin.vo.Admin_FaqVO;
import multi.admin.vo.Admin_HostVO;
import multi.admin.vo.Admin_NoticeVO;
import multi.admin.vo.Admin_UserVO;
import multi.admin.vo.Admin_o2oQnAVO;

/* 
干滚 包府
魄概磊 包府
拱前 包府
葛烙 包府
目孤聪萍 包府
傍瘤荤亲 包府
捞亥飘 包府
FAQ 包府
1:1 包府
 */

@Controller
public class CtrlAdmin {
	@Autowired @Qualifier("admin_UserDAO")
	private Admin_UserDAO admin_UserDAO = null;
	@Autowired @Qualifier("admin_HostDAO")
	private Admin_HostDAO admin_HostDAO = null;
	@Autowired @Qualifier("admin_NoticeDAO")
	private Admin_NoticeDAO admin_NoticeDAO = null;
	@Autowired @Qualifier("admin_FaqDAO")
	private Admin_FaqDAO admin_FaqDAO = null;
	@Autowired @Qualifier("admin_o2oQnADAO")
	private Admin_o2oQnADAO admin_o2oQnADAO = null;
	
	@RequestMapping("/admin_main.do")
	public ModelAndView admin_main() throws Exception {
		ModelAndView mnv = new ModelAndView("admin_main");
		return mnv;
	}
	@RequestMapping("/admin_main_test.do")
	public ModelAndView admin_main_test() throws Exception {
		ModelAndView mnv = new ModelAndView("admin_main_test");
		return mnv;
	}
	
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
	
	//魄概磊 包府
	@RequestMapping("/admin_hosts.do")
	public ModelAndView admin_hosts() throws Exception {
		ModelAndView mnv = new ModelAndView("admin_hosts");
		List<Admin_HostVO> ls = admin_HostDAO.host_findAll();
		mnv.addObject("ls", ls);
		return mnv;
	}
	
	@RequestMapping("/admin_host_request.do")
	public ModelAndView admin_host_request() throws Exception {
		ModelAndView mnv = new ModelAndView("admin_host_request");
		List<Admin_HostVO> ls = admin_HostDAO.host_request_findAll();
		mnv.addObject("ls", ls);
		return mnv;
	}
	
	@RequestMapping("/admin_host_request_view.do")
	public ModelAndView admin_host_request_view( @ModelAttribute Admin_HostVO hvo ) throws Exception {
		ModelAndView mnv = new ModelAndView("admin_host_request_view");
		Admin_HostVO vo = admin_HostDAO.host_check(hvo);
		mnv.addObject("vo", vo);
		return mnv;
	}
	
	@RequestMapping("/admin_host_user_check.do")
	public ModelAndView admin_host_user_check( @ModelAttribute Admin_HostVO hvo ) throws Exception {
		ModelAndView mnv = new ModelAndView("admin_host_user_check");
		Admin_UserVO vo = admin_HostDAO.host_user_check(hvo);
		mnv.addObject("vo", vo);
		return mnv;
	}
	
	@RequestMapping("/admin_host_user_accept.do")
	public ModelAndView admin_host_user_accept( @ModelAttribute Admin_HostVO hvo ) throws Exception {
		ModelAndView mnv = new ModelAndView();
		admin_HostDAO.host_user_accept(hvo);
		mnv.setViewName("redirect:/admin_host_request.do");
		return mnv;
	}
	
	@RequestMapping("/admin_host_user_refuse.do")
	public ModelAndView admin_host_user_refuse( @ModelAttribute Admin_HostVO hvo ) throws Exception {
		ModelAndView mnv = new ModelAndView();
		admin_HostDAO.host_user_refuse(hvo);
		mnv.setViewName("redirect:/admin_host_request.do");
		return mnv;
	}
	
	@RequestMapping("/admin_host_user_downgrade.do")
	public ModelAndView admin_host_user_downgrade( @ModelAttribute Admin_HostVO hvo ) throws Exception {
		ModelAndView mnv = new ModelAndView();
		admin_HostDAO.host_user_downgrade(hvo);
		mnv.setViewName("redirect:/admin_hosts.do");
		return mnv;
	}
	
	@RequestMapping("/admin_host_user_remove.do")
	public ModelAndView admin_host_user_remove( @ModelAttribute Admin_HostVO hvo ) throws Exception {
		ModelAndView mnv = new ModelAndView();
		admin_HostDAO.host_user_remove(hvo);
		mnv.setViewName("redirect:/admin_hosts.do");
		return mnv;
	}
	
	// 拱前 包府
	@RequestMapping("/admin_space.do")
	public ModelAndView admin_space() throws Exception {
		ModelAndView mnv = new ModelAndView("admin_space");
		
		return mnv;
	}
	
	// 葛烙 包府
	@RequestMapping("/admin_gathering.do")
	public ModelAndView admin_gathering() throws Exception {
		ModelAndView mnv = new ModelAndView("admin_gathering");
		
		return mnv;
	}
	// 目孤聪萍 包府
	@RequestMapping("/admin_community.do")
	public ModelAndView admin_community() throws Exception {
		ModelAndView mnv = new ModelAndView("admin_community");
		
		return mnv;
	}
	
	// 傍瘤荤亲 包府
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
	
	// 捞亥飘 包府
	@RequestMapping("/admin_event.do")
	public ModelAndView admin_event() throws Exception {
		ModelAndView mnv = new ModelAndView("admin_event");
			
		return mnv;
	}
	
	// FAQ 包府
	@RequestMapping("/admin_faq.do")
	public ModelAndView admin_faq() throws Exception {
		ModelAndView mnv = new ModelAndView("admin_faq");
		List<Admin_FaqVO> rl = admin_FaqDAO.findAll();
		mnv.addObject("rl", rl);
		return mnv;
	}
	
	@RequestMapping("/admin_faq_read.do")
	public ModelAndView admin_faq_read( @ModelAttribute Admin_FaqVO fvo ) throws Exception {
		ModelAndView mnv = new ModelAndView("admin_faq_read");
		Admin_FaqVO vo = admin_FaqDAO.faq_read(fvo);
		mnv.addObject("vo", vo);
		return mnv;
	}
	
	@RequestMapping("/admin_faq_mod.do")
	public ModelAndView admin_faq_mod( @ModelAttribute Admin_FaqVO fvo ) throws Exception {
		ModelAndView mnv = new ModelAndView();
		admin_FaqDAO.faq_modify(fvo);
		mnv.setViewName("redirect:/admin_faq.do");
		return mnv;
	}
	
	@RequestMapping("/admin_faq_remove.do")
	public ModelAndView admin_faq_remove( @ModelAttribute Admin_FaqVO fvo ) throws Exception {
		ModelAndView mnv = new ModelAndView();
		i(fvo.getFaq_no());
		admin_FaqDAO.faq_remove(fvo);
		mnv.setViewName("redirect:/admin_faq.do");
		return mnv;
	}
	
	@RequestMapping("/admin_faq_add.do")
	public ModelAndView admin_faq_add( ) throws Exception {
		ModelAndView mnv = new ModelAndView("admin_faq_add");
		return mnv;
	}
	
	@RequestMapping("/admin_faq_add2.do")
	public ModelAndView admin_faq_add2( @ModelAttribute Admin_FaqVO fvo ) throws Exception {
		ModelAndView mnv = new ModelAndView();
		admin_FaqDAO.faq_add(fvo);
		mnv.setViewName("redirect:/admin_faq.do");
		return mnv;
	}
	
	// 1:1 包府
	@RequestMapping("/admin_o2oQnA.do")
	public ModelAndView admin_o2oQnA() throws Exception {
		ModelAndView mnv = new ModelAndView("admin_o2oQnA");
			
		return mnv;
	}
	
	@RequestMapping("/admin_o2oQnA_add.do")
	public ModelAndView admin_o2oQnA_add( @ModelAttribute Admin_o2oQnAVO ovo ) throws Exception {
		ModelAndView mnv = new ModelAndView();
		admin_o2oQnADAO.addAsking(ovo);
		mnv.setViewName("redirect:/admin_o2oQnA.do");
		
		return mnv;
	}
	
	@RequestMapping("/admin_o2oQnA_list.do")
	public ModelAndView admin_o2oQnA_list( @ModelAttribute Admin_o2oQnAVO ovo ) throws Exception {
		ModelAndView mnv = new ModelAndView("admin_o2oQnA_list");
		List<Admin_o2oQnAVO> ls = admin_o2oQnADAO.findAllAsk();
		mnv.addObject("ls", ls);
		return mnv;
	}
}
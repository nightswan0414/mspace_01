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
import multi.admin.dao.Admin_HostDAO;
import multi.admin.dao.Admin_UserDAO;
import multi.admin.vo.Admin_HostVO;
import multi.admin.vo.Admin_UserVO;

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
	
	@RequestMapping("/admin_main.do")
	public ModelAndView admin_main() throws Exception {
		ModelAndView mnv = new ModelAndView("admin_main");
		
		return mnv;
	}
	
	// 干滚 包府
	@RequestMapping("/admin_user_main.do")
	public ModelAndView admin_user_main() throws Exception {
		ModelAndView mnv = new ModelAndView("admin_user_main");
		
		return mnv;
	}
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
	@RequestMapping("/admin_host_main.do")
	public ModelAndView admin_host_main() throws Exception {
		ModelAndView mnv = new ModelAndView("admin_host_main");
		
		return mnv;
	}
	
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
	public ModelAndView admin_host_request_view( @ModelAttribute Admin_HostVO hvo, @RequestParam("CRN") String CRN ) throws Exception {
		ModelAndView mnv = new ModelAndView("admin_host_request_view");
		i(hvo.getCRN());
		i(CRN);
		hvo.setCRN(CRN);
		Admin_HostVO vo = admin_HostDAO.host_check(hvo);
		mnv.addObject("vo", vo);
		
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
	@RequestMapping("/admin_announcement.do")
	public ModelAndView admin_announcement() throws Exception {
		ModelAndView mnv = new ModelAndView("admin_announcement");
		
		return mnv;
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
			
		return mnv;
	}
	
	// 1:1 包府
	@RequestMapping("/admin_one_one.do")
	public ModelAndView admin_one_one() throws Exception {
		ModelAndView mnv = new ModelAndView("admin_one_one");
			
		return mnv;
	}
}
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
import multi.admin.vo.Admin_HostApplyVO;
import multi.admin.vo.Admin_HostVO;
import multi.admin.vo.Admin_NoticeVO;
import multi.admin.vo.Admin_SpaceVO;
import multi.admin.vo.Admin_UserVO;
import multi.admin.vo.Admin_o2oQnAVO;

/* 
판매자 관리
 */

@Controller
public class Ctrl_Admin_Hosts {
	@Autowired @Qualifier("admin_HostDAO")
	private Admin_HostDAO admin_HostDAO = null;
	//판매자 관리
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
		List<Admin_HostApplyVO> ls = admin_HostDAO.host_request_findAll();
		mnv.addObject("ls", ls);
		return mnv;
	}
	
	@RequestMapping("/admin_host_request_view.do")
	public ModelAndView admin_host_request_view( @ModelAttribute Admin_HostApplyVO hvo ) throws Exception {
		ModelAndView mnv = new ModelAndView("admin_host_request_view");
		Admin_HostApplyVO vo = admin_HostDAO.host_check(hvo);
		mnv.addObject("vo", vo);
		return mnv;
	}
	
	@RequestMapping("/admin_host_user_accept.do")
	public ModelAndView admin_host_user_accept( @ModelAttribute Admin_HostApplyVO hvo ) throws Exception {
		ModelAndView mnv = new ModelAndView();
		admin_HostDAO.host_user_accept(hvo);
		mnv.setViewName("redirect:/admin_host_request.do");
		return mnv;
	}
	
	@RequestMapping("/admin_host_user_refuse_write.do")
	public ModelAndView admin_host_user_refuse_write( @ModelAttribute Admin_HostApplyVO hvo ) throws Exception {
		ModelAndView mnv = new ModelAndView("admin_host_user_refuse_write");
		mnv.addObject("vo", hvo);
		return mnv;
	}
	
	@RequestMapping("/admin_host_user_refuse.do")
	public ModelAndView admin_host_user_refuse( @ModelAttribute Admin_HostApplyVO hvo ) throws Exception {
		ModelAndView mnv = new ModelAndView();
		admin_HostDAO.host_user_refuse(hvo);
		mnv.setViewName("redirect:/admin_host_request.do");
		return mnv;
	}
	@RequestMapping("/admin_host_user_remove_request.do")
	public ModelAndView admin_host_user_remove_request( @ModelAttribute Admin_HostApplyVO hvo ) throws Exception {
		ModelAndView mnv = new ModelAndView();
		i(hvo.getHost_apply_no());
		admin_HostDAO.host_user_remove_request(hvo);
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
	

	
	@RequestMapping("/admin_host_user_check.do")
	public ModelAndView admin_host_user_check( @ModelAttribute Admin_HostVO hvo ) throws Exception {
		ModelAndView mnv = new ModelAndView("admin_host_user_check");
		Admin_UserVO vo = admin_HostDAO.host_user_check(hvo);
		mnv.addObject("vo", vo);
		return mnv;
	}
	
}
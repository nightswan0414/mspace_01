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
import main.CookieValue;
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
import multi.admin.vo.Admin_FaqVO;
import multi.admin.vo.Admin_HostVO;
import multi.admin.vo.Admin_NoticeVO;
import multi.admin.vo.Admin_SpaceVO;
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
	
	@Autowired @Qualifier("admin_SpaceDAO")
	private Admin_SpaceDAO admin_SpaceDAO = null;
	
	@Autowired @Qualifier("admin_ClubDAO")
	private Admin_ClubDAO admin_ClubDAO = null;
	
	@Autowired @Qualifier("admin_NoticeDAO")
	private Admin_NoticeDAO admin_NoticeDAO = null;
	
	@Autowired @Qualifier("admin_FaqDAO")
	private Admin_FaqDAO admin_FaqDAO = null;
	
	@Autowired @Qualifier("admin_o2oQnADAO")
	private Admin_o2oQnADAO admin_o2oQnADAO = null;

	
	@RequestMapping("/admin_main.do")
	public ModelAndView admin_main( @CookieValue("UID") String UID ) throws Exception {
		ModelAndView mnv = new ModelAndView("admin_main");
		return mnv;
	}
}
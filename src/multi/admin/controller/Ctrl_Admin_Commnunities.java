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
public class Ctrl_Admin_Commnunities {
	
	// 目孤聪萍 包府
	@RequestMapping("/admin_community.do")
	public ModelAndView admin_community() throws Exception {
		ModelAndView mnv = new ModelAndView("admin_community");
		
		return mnv;
	}
	
}
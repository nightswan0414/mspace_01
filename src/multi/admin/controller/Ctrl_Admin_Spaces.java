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
물품 관리
 */

@Controller
public class Ctrl_Admin_Spaces {
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
	
	// 물품 관리
	@RequestMapping("/admin_space.do")
	public ModelAndView admin_space() throws Exception {
		ModelAndView mnv = new ModelAndView("admin_space");
		
		return mnv;
	}
	@RequestMapping("/admin_spaces.do")
	public ModelAndView admin_space( @ModelAttribute Admin_SpaceVO svo, @RequestParam("value_check")String value_check  ) throws Exception {
		ModelAndView mnv = new ModelAndView("admin_spaces");
		List<Admin_SpaceVO> ls = null;
		if( value_check == null || value_check.equals("") ){
			ls = admin_SpaceDAO.findAllPlacesCreatedDesc(svo);
			value_check = "최신 순으로 정렬";
		} else if ( value_check.equals("casc") ){
			ls = admin_SpaceDAO.findAllPlacesCreatedAsc(svo);
			value_check = "오래된 순으로 정렬";
		} else if ( value_check.equals("cdesc") ){
			ls = admin_SpaceDAO.findAllPlacesCreatedDesc(svo);
			value_check = "최신 순으로 정렬";
		} else if ( value_check.equals("pasc") ){
			ls = admin_SpaceDAO.findAllPlacesPriceAsc(svo);
			value_check = "싼 가격 순으로 정렬";
		} else if ( value_check.equals("pdesc") ){
			ls = admin_SpaceDAO.findAllPlacesPriceDesc(svo);
			value_check = "비싼 가격 순으로 정렬";
		}
		mnv.addObject("ls", ls);
		mnv.addObject("value_check", value_check);
		
		return mnv;
	}
	@RequestMapping("/admin_host_spaces.do")
	public ModelAndView admin_host_space_rooms( @ModelAttribute Admin_SpaceVO svo, @ModelAttribute Admin_HostVO hvo  ) throws Exception {
		ModelAndView mnv = new ModelAndView("admin_host_spaces");
		List<Admin_SpaceVO> ls = admin_SpaceDAO.findHostPlaces(svo);
		mnv.addObject("ls", ls);
		mnv.addObject("host_name", hvo.getHost_name());
		// 판매자에서 공간 정보를 불러들일 때 호출
		return mnv;
	}
	
}
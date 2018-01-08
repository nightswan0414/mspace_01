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
import main.vo.HostVO;
import main.vo.SpaceVO;
import multi.admin.dao.Admin_FaqDAO;
import multi.admin.dao.Admin_HostDAO;
import multi.admin.dao.Admin_NoticeDAO;
import multi.admin.dao.Admin_SpaceDAO;
import multi.admin.dao.Admin_UserDAO;
import multi.admin.dao.Admin_o2oQnADAO;

/* 
��ǰ ����

��ǰ ���� ����Ʈ ������
��ҿ� ���� �Ǹ��� ���� Ȯ�� ������
 */

@Controller
public class Ctrl_Admin_Spaces {
	@Autowired @Qualifier("admin_SpaceDAO")
	private Admin_SpaceDAO admin_SpaceDAO = null;
	
	@Autowired @Qualifier("admin_HostDAO")
	private Admin_HostDAO admin_HostDAO = null;

	// ��ǰ ���� ����Ʈ ������
	@RequestMapping("/admin_spaces.do")
	public ModelAndView admin_space( @ModelAttribute SpaceVO svo, @RequestParam("value_check")String value_check  ) throws Exception {
		ModelAndView mnv = new ModelAndView("admin_spaces");
		List<SpaceVO> ls = null;
		if( value_check == null || value_check.equals("") ){
			ls = admin_SpaceDAO.findAllPlacesCreatedDesc(svo);
			value_check = "�ֽ� ������ ����";
		} else if ( value_check.equals("casc") ){
			ls = admin_SpaceDAO.findAllPlacesCreatedAsc(svo);
			value_check = "������ ������ ����";
		} else if ( value_check.equals("cdesc") ){
			ls = admin_SpaceDAO.findAllPlacesCreatedDesc(svo);
			value_check = "�ֽ� ������ ����";
		} else if ( value_check.equals("pasc") ){
			ls = admin_SpaceDAO.findAllPlacesPriceAsc(svo);
			value_check = "�� ���� ������ ����";
		} else if ( value_check.equals("pdesc") ){
			ls = admin_SpaceDAO.findAllPlacesPriceDesc(svo);
			value_check = "��� ���� ������ ����";
		}
		mnv.addObject("ls", ls);
		mnv.addObject("value_check", value_check);
		
		return mnv;
	}
	// ��ҿ� ���� �Ǹ��� ���� Ȯ�� ������
	@RequestMapping("/admin_host_spaces.do")
	public ModelAndView admin_host_space_rooms( @ModelAttribute SpaceVO svo, @ModelAttribute HostVO hvo  ) throws Exception {
		ModelAndView mnv = new ModelAndView("admin_host_spaces");
		List<SpaceVO> ls = admin_SpaceDAO.findHostPlaces(svo);
		mnv.addObject("ls", ls);
		mnv.addObject("host_name", hvo.getHost_name());
		return mnv;
	}
	
}
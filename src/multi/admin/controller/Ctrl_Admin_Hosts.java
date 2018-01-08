package multi.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import main.Controller;
import main.ModelAndView;
import main.ModelAttribute;
import main.RequestMapping;
import main.vo.HostApplyVO;
import main.vo.HostVO;
import main.vo.UserVO;
import multi.admin.dao.Admin_HostDAO;

/* 
�Ǹ��� ����

�Ǹ��� ����Ʈ ȣ�� ������
�Ǹ��� ��û ���� ����Ʈ Ȯ�� ������
Ư�� �Ǹ��� ��û ���� Ȯ�� ������
Ư�� �Ǹ��� ��û�� �޾Ƶ��� ��. �����̷�Ʈ �� �Ǹ��� ��û ���� ����Ʈ Ȯ�� ������
Ư�� �Ǹ��� ��û�� ���� �� ������� �ۼ� �ϴ� ������
���� ���� �ۼ� �� �̿�. �����̷�Ʈ �� Ư�� �Ǹ��� ��û ���� Ȯ�� ������
Ư�� �Ǹ��� ��û ���� �����ϴ� ������. �����̷�Ʈ �� Ư�� �Ǹ��� ��û ���� Ȯ�� ������
�Ǹ��ڷ� ��ϵ� ��� ������ ������ �� �̿�. �����̷�Ʈ �� �Ǹ��� ����Ʈ ���� Ȯ�� ������
�Ǹ��� ���� ����. �����̷�Ʈ �� �Ǹ��� ����Ʈ ���� Ȯ�� ������
�Ǹ��� ���� Ư�� ������ ������ �� �� �̿��ϴ� ������
 */

@Controller
public class Ctrl_Admin_Hosts {
	@Autowired @Qualifier("admin_HostDAO")
	private Admin_HostDAO admin_HostDAO = null;
	// �Ǹ��� ����Ʈ ȣ�� ������
	@RequestMapping("/admin_hosts.do")
	public ModelAndView admin_hosts() throws Exception {
		ModelAndView mnv = new ModelAndView("admin_hosts");
		List<HostVO> ls = admin_HostDAO.host_findAll();
		mnv.addObject("ls", ls);
		return mnv;
	}
	// �Ǹ��� ��û ���� ����Ʈ Ȯ�� ������
	@RequestMapping("/admin_host_request.do")
	public ModelAndView admin_host_request() throws Exception {
		ModelAndView mnv = new ModelAndView("admin_host_request");
		List<HostApplyVO> ls = admin_HostDAO.host_request_findAll();
		mnv.addObject("ls", ls);
		return mnv;
	}
	// Ư�� �Ǹ��� ��û ���� Ȯ�� ������
	@RequestMapping("/admin_host_request_view.do")
	public ModelAndView admin_host_request_view( @ModelAttribute HostApplyVO hvo ) throws Exception {
		ModelAndView mnv = new ModelAndView("admin_host_request_view");
		HostApplyVO vo = admin_HostDAO.host_check(hvo);
		mnv.addObject("vo", vo);
		return mnv;
	}
	// Ư�� �Ǹ��� ��û�� �޾Ƶ��� ��. �����̷�Ʈ �� �Ǹ��� ��û ���� ����Ʈ Ȯ�� ������
	@RequestMapping("/admin_host_user_accept.do")
	public ModelAndView admin_host_user_accept( @ModelAttribute HostApplyVO hvo ) throws Exception {
		ModelAndView mnv = new ModelAndView();
		admin_HostDAO.host_user_accept(hvo);
		mnv.setViewName("redirect:/admin_host_request.do");
		return mnv;
	}
	// Ư�� �Ǹ��� ��û�� ���� �� ������� �ۼ� �ϴ� ������
	@RequestMapping("/admin_host_user_refuse_write.do")
	public ModelAndView admin_host_user_refuse_write( @ModelAttribute HostApplyVO hvo ) throws Exception {
		ModelAndView mnv = new ModelAndView("admin_host_user_refuse_write");
		mnv.addObject("vo", hvo);
		return mnv;
	}
	// ���� ���� �ۼ� �� �̿�. �����̷�Ʈ �� Ư�� �Ǹ��� ��û ���� Ȯ�� ������
	@RequestMapping("/admin_host_user_refuse.do")
	public ModelAndView admin_host_user_refuse( @ModelAttribute HostApplyVO hvo ) throws Exception {
		ModelAndView mnv = new ModelAndView();
		admin_HostDAO.host_user_refuse(hvo);
		mnv.setViewName("redirect:/admin_host_request.do");
		return mnv;
	}
	// Ư�� �Ǹ��� ��û ���� �����ϴ� ������. �����̷�Ʈ �� Ư�� �Ǹ��� ��û ���� Ȯ�� ������
	@RequestMapping("/admin_host_user_remove_request.do")
	public ModelAndView admin_host_user_remove_request( @ModelAttribute HostApplyVO hvo ) throws Exception {
		ModelAndView mnv = new ModelAndView();
		admin_HostDAO.host_user_remove_request(hvo);
		mnv.setViewName("redirect:/admin_host_request.do");
		return mnv;
	}
	// �Ǹ��ڷ� ��ϵ� ��� ������ ������ �� �̿�. �����̷�Ʈ �� �Ǹ��� ����Ʈ ���� Ȯ�� ������
	@RequestMapping("/admin_host_user_downgrade.do")
	public ModelAndView admin_host_user_downgrade( @ModelAttribute HostVO hvo ) throws Exception {
		ModelAndView mnv = new ModelAndView();
		admin_HostDAO.host_user_downgrade(hvo);
		mnv.setViewName("redirect:/admin_hosts.do");
		return mnv;
	}
	// �Ǹ��� ���� ����. �����̷�Ʈ �� �Ǹ��� ����Ʈ ���� Ȯ�� ������
	@RequestMapping("/admin_host_user_remove.do")
	public ModelAndView admin_host_user_remove( @ModelAttribute HostVO hvo ) throws Exception {
		ModelAndView mnv = new ModelAndView();
		admin_HostDAO.host_user_remove(hvo);
		mnv.setViewName("redirect:/admin_hosts.do");
		return mnv;
	}
	// �Ǹ��� ���� Ư�� ������ ������ �� �� �̿��ϴ� ������
	@RequestMapping("/admin_host_user_check.do")
	public ModelAndView admin_host_user_check( @ModelAttribute HostVO hvo ) throws Exception {
		ModelAndView mnv = new ModelAndView("admin_host_user_check");
		UserVO vo = admin_HostDAO.host_user_check(hvo);
		mnv.addObject("vo", vo);
		return mnv;
	}
	
}
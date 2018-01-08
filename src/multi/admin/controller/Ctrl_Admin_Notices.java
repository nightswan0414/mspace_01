package multi.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import main.Controller;
import main.ModelAndView;
import main.ModelAttribute;
import main.RequestMapping;
import main.vo.NoticeVO;
import multi.admin.dao.Admin_NoticeDAO;


/* 
�������� ����

�������� ����Ʈ Ȯ���ϱ�
�������� �ϳ� �б�
�������� �߰� ������
�������� �߰��� �̿�. �����̷�Ʈ �� �������� ����Ʈ Ȯ���ϱ� ������
�������� ���� ������. Ư�� �������� Ŭ���� ���� �޾Ƶ���.
�������� ���� ó��. �����̷�Ʈ�� Ư�� �������� �б� ������ ����
�������� ����. �����̷�Ʈ �� �������� ����Ʈ Ȯ���ϱ� ������
 */

@Controller
public class Ctrl_Admin_Notices {
	@Autowired @Qualifier("admin_NoticeDAO")
	private Admin_NoticeDAO admin_NoticeDAO = null;
	
	// �������� ����Ʈ Ȯ���ϱ�
	@RequestMapping("/admin_notice_list.do")
	public ModelAndView textList() throws Exception {
		List<NoticeVO> rl = admin_NoticeDAO.findAll();
		ModelAndView mnv=new ModelAndView("admin_notice_list");
		mnv.addObject("rl",rl);
		return mnv;
	}
	// �������� �ϳ� �б�
	@RequestMapping("/admin_notice_read.do")
	public ModelAndView textRead(@ModelAttribute NoticeVO pvo) throws Exception {
		
		NoticeVO vo = admin_NoticeDAO.findByPK(pvo);
		ModelAndView mnv=new ModelAndView("admin_notice_read");
		mnv.addObject("vo",vo);

		return mnv;
	}
	// �������� �߰� ������
	@RequestMapping("/admin_notice_add.do")
	public ModelAndView textAdd(@ModelAttribute NoticeVO pvo) throws Exception {
		ModelAndView mnv=new ModelAndView("admin_notice_add");
		return mnv;
	}
	// �������� �߰��� �̿�. �����̷�Ʈ �� �������� ����Ʈ Ȯ���ϱ� ������
	@RequestMapping("/admin_notice_add2.do")
	public String textAdd2(@ModelAttribute NoticeVO pvo) throws Exception {
		admin_NoticeDAO.add(pvo);
		return "redirect:/admin_notice_list.do";
	}
	// �������� ���� ������. Ư�� �������� Ŭ���� ���� �޾Ƶ���.
	@RequestMapping("/admin_notice_mod.do")
	public ModelAndView mod(@ModelAttribute NoticeVO pvo) throws Exception {
		ModelAndView mnv=new ModelAndView("admin_notice_mod");
		mnv.addObject("vo", pvo);
		return mnv;
	}
	// �������� ���� ó��. �����̷�Ʈ�� Ư�� �������� �б� ������ ����
	@RequestMapping("/admin_notice_mod2.do")
	public String mod2(@ModelAttribute NoticeVO pvo) throws Exception {
		
		admin_NoticeDAO.mod(pvo);
		return "redirect:/admin_notice_read.do?notice_no="+pvo.getNotice_no();
	}
	// �������� ����. �����̷�Ʈ �� �������� ����Ʈ Ȯ���ϱ� ������
	@RequestMapping("/admin_notice_del.do")
	public String del(@ModelAttribute NoticeVO pvo) throws Exception {
		admin_NoticeDAO.delByPK(pvo);
		return "redirect:/admin_notice_list.do";
	}
	
}
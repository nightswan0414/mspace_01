package multi.admin.controller;

import static main.Single.i;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import main.Controller;
import main.ModelAndView;
import main.ModelAttribute;
import main.RequestMapping;
import main.RequestParam;
import multi.admin.dao.Admin_o2oQnADAO;
import multi.admin.mail.EmailUtility;
import multi.admin.vo.Admin_o2oQnAVO;
/* 
1:1 ����
 */

@Controller
public class Ctrl_Admin_o2oQnA {
	@Autowired @Qualifier("admin_o2oQnADAO")
	private Admin_o2oQnADAO admin_o2oQnADAO = null;
	
	// 1:1 ����
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
	public ModelAndView admin_o2oQnA_list() throws Exception {
		ModelAndView mnv = new ModelAndView("admin_o2oQnA_list");
		List<Admin_o2oQnAVO> ls = admin_o2oQnADAO.findAllAskWithNoRe();
		mnv.addObject("ls", ls);
		return mnv;
	}
	
	@RequestMapping("/admin_o2oQnA_list_reply.do")
	public ModelAndView admin_o2oQnA_list_reply() throws Exception {
		ModelAndView mnv = new ModelAndView("admin_o2oQnA_list_reply");
		List<Admin_o2oQnAVO> ls = admin_o2oQnADAO.findAllAskWithRe();
		mnv.addObject("ls", ls);
		return mnv;
	}
	
	@RequestMapping("/admin_o2oQnA_read.do")
	public ModelAndView admin_o2oQnA_read( @ModelAttribute Admin_o2oQnAVO ovo ) throws Exception {
		ModelAndView mnv = new ModelAndView("admin_o2oQnA_read");
		Admin_o2oQnAVO vo = admin_o2oQnADAO.check_oneAsking(ovo);
		mnv.addObject("vo", vo);
		return mnv;
	}
	
	@RequestMapping("/admin_o2oQnA_Email.do")
	public ModelAndView admin_o2oQnA_Email( @ModelAttribute Admin_o2oQnAVO ovo ) throws Exception {
		ModelAndView mnv = new ModelAndView();
        String host = "smtp.gmail.com";
        String port = "587";
        String mailFrom = "multipro2018@gmail.com";
        String password = "rmfnpdlxm2";
       
        String created_time = ovo.getThe_time();
        String customer_email = ovo.getO2o_email();
        String customer_content = ovo.getO2o_content();
        String admin_reply = ovo.getRe_o2o_content();
        
        String subject = "�ȳ��ϼ��� ��Ƽ �����̽��Դϴ�. ������ ������ ��� "+ ovo.getO2o_type() +" ���׿� ���� ������ ���� ���׿� ���� �亯�Դϴ�.";
        String message = "������ ���� ������ "+created_time+ " �� �ۼ����ֽ� \""+customer_content+"\" �����ϴ�.\n\n"
        				+ admin_reply +"\n\n\n\n �׻� ��Ƽ �����̽��� �̿��� �ּż� �����մϴ�.\n"
        				+ "\n�������� �߽� �����Դϴ�."
        				+ "\n���ǻ����� ���� �� ��Ƽ�����̽��� 1:1 ���Ƿ� ���� ��Ź�帳�ϴ�."
        				+ "\n\n�����մϴ�.";
        
        String result_message = null;
        try {
            EmailUtility.sendEmail(host, port, mailFrom, password, customer_email, subject,
            		message);
            result_message = "The e-mail was sent successfully";
            ovo.setRe_o2o_content(message);
        } catch (Exception e) {
            e.printStackTrace();
            result_message = "There were an error: " + e.getMessage();
        }
        
        mnv.setViewName("redirect:/admin_o2oQnA_list_reply_status.do?message="+result_message);
		return mnv;
	}
	
	@RequestMapping("/admin_o2oQnA_list_reply_status.do")
	public ModelAndView admin_o2oQnA_list_reply_status( @RequestParam("message")String message  ) throws Exception {
		ModelAndView mnv = new ModelAndView("admin_o2oQnA_list_reply_status");
		mnv.addObject("message", message);
		return mnv;
	}
	
}
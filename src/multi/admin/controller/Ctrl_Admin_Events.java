package multi.admin.controller;

import main.Controller;
import main.ModelAndView;
import main.RequestMapping;

@Controller
public class Ctrl_Admin_Events {
	
	// �̺�Ʈ ���� ������
	@RequestMapping("/admin_event.do")
	public ModelAndView admin_event() throws Exception {
		ModelAndView mnv = new ModelAndView("admin_event");
			
		return mnv;
	}
	
}
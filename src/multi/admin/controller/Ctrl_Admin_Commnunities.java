package multi.admin.controller;

import main.Controller;
import main.ModelAndView;
import main.RequestMapping;

/* 
Ŀ�´�Ƽ ����

Ŀ�´�Ƽ ���� ������
 */

@Controller
public class Ctrl_Admin_Commnunities {
	
	// Ŀ�´�Ƽ ���� ������
	@RequestMapping("/admin_community.do")
	public ModelAndView admin_community() throws Exception {
		ModelAndView mnv = new ModelAndView("admin_community");
		
		return mnv;
	}
	
}
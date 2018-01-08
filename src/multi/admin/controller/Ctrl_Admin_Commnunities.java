package multi.admin.controller;

import main.Controller;
import main.ModelAndView;
import main.RequestMapping;

/* 
커뮤니티 관리

커뮤니티 관리 페이지
 */

@Controller
public class Ctrl_Admin_Commnunities {
	
	// 커뮤니티 관리 페이지
	@RequestMapping("/admin_community.do")
	public ModelAndView admin_community() throws Exception {
		ModelAndView mnv = new ModelAndView("admin_community");
		
		return mnv;
	}
	
}
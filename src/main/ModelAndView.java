package main;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public class ModelAndView {
	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	private String viewName = null;
	private Map<String,Object> objMap = null;
	
	public ModelAndView() {

	}
	
	public ModelAndView( String vn ) {
		this();
		viewName = vn;
	}	
	
	public void addObject( String key, Object val ){
		if( objMap == null ){
			objMap = new Hashtable<String,Object>();
		}
		if( key != null && val != null ){
			objMap.put(key, val);
		}
	}
	
	/*	addObject �� �̿��Ͽ� objMap �� ����� ������
	 * 	fill �� ȣ���ϰԵǸ� request �� �Ű����� �ȴ�.
	 */
	public void fill( HttpServletRequest request ){
		if( objMap.size() > 0 )
		{
			Set<String> ks = objMap.keySet();
			for( String key : ks ){
				Object val = objMap.get(key);
				request.setAttribute(key,val);
			}
		}
	}
}







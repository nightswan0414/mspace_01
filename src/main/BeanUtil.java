package main;

import java.lang.reflect.Method;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import static main.Single.*;

public class BeanUtil 
{
	public static String utf2kr( String l ){
		if( l == null || l.equals("") )
			return l;
		
		try{
			byte[] buf = l.getBytes("8859_1");
			l = new String( buf, "utf-8");
		}
		catch( Exception e ){}
		return l;
	}
	
	public static void populate( Object obj, HttpServletRequest request ){
		try {
			Class<?> cls = obj.getClass();
			Method[] mtds = cls.getMethods();
			for( Method mtd : mtds ){
				String fn = mtd.getName();
				if( fn.startsWith("set") )
				{
					String pn = BeanUtil.toPropName( fn );
					if( pn != null ){
						String val = request.getParameter( pn );
						if( val != null && !val.equals("") ){
							Class<?>[] ptypes = mtd.getParameterTypes();
							if( ptypes.length != 1 ){
								continue;
							}
							else if( ptypes[0] == String.class )
							{
								if( isPropertyNeedUTF(pn) )
								{
									val = utf2kr( val );
								} 
								mtd.invoke( obj, val );
							}
							else if( ptypes[0] == Integer.class ){
								mtd.invoke( obj, BeanUtil.pInt(val));
							}
						}
					}
				}
			}
		} catch (Exception e) {
			i(e);
		}
	}
	
	public static boolean isPropertyNeedUTF( String pn ){
		if( pn == null )
			return false;
		
		return (  pn.equals("title") || 
			pn.equals("content") || 
			pn.equals("repleBody") || 
			pn.equals("nickname") ||
			pn.equals("user_name") ||
			pn.equals("faq_title") ||
			pn.equals("faq_content") ||
			pn.equals("notice_title") ||
			pn.equals("notice_content") ||
			pn.equals("o2o_title") ||
			pn.equals("o2o_content") || 
			pn.equals("o2o_type")
			); 		
	}
	
	//	String l2 = BeanUtil.toPropName( l );
	public static String toPropName( String l )
	{
		if( l == null || l.equals("") )
			return null;
		
		if( l.startsWith("set") ){
			StringBuffer sb = new StringBuffer();
			sb.append( (char)(l.charAt(3)+32) );
			sb.append(l.substring(4));
			return sb.toString();
		}else{
			return null;
		}
	}
	
	
	
	//	byte < short = char < int < long < float < double
	public static String toSetterName( String l ){
		StringBuffer sb = new StringBuffer();
		sb.append("set");
		sb.append( (char)( l.charAt(0) - 32 ) );
		sb.append( l.substring(1) );
		return sb.toString();
	}
	
	
	public static Integer pInt(String l) {
		if( l == null || l.equals("") )
			return null;
		
		try{
			int r = Integer.parseInt(l);
			return new Integer(r);
		}
		catch( NumberFormatException e ){
			return null;
		}
	}
	
	public static Integer pInt(String l, int dv) {
		if( l == null || l.equals("") )
			return dv;
		
		try{
			int r = Integer.parseInt(l);
			return new Integer(r);
		}
		catch( NumberFormatException e ){
			return dv;
		}
	}	

	public static Double pDbl(String l) {
		if( l == null || l.equals("") )
			return null;
		
		try{
			double r = Double.parseDouble(l);
			return new Double(r);
		}
		catch( NumberFormatException e ){
			return null;
		}
	}

	public static Double pDbl(String l, double dv ) {
		if( l == null || l.equals("") )
			return dv;
		
		try{
			double r = Double.parseDouble(l);
			return new Double(r);
		}
		catch( NumberFormatException e ){
			return dv;
		}
	}

	public static String loginID( HttpServletRequest request ){
		Cookie[] cks = request.getCookies();
		String uid = null;
		if( cks != null ){
			for( int t = 0 ; t < cks.length ; t++ ){
				if( "UID".equals( cks[t].getName() ) ){
					uid = cks[t].getValue();
					break;
				}
			}
		}
		return uid;
	}
}

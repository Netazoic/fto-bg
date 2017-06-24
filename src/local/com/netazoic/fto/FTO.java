package com.netazoic.fto;


import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.netazoic.ent.RouteAction;
import com.netazoic.ent.ServENT;


public class FTO extends ServENT{
	
	RouteAction homeHdlr = new Home();
	
	public enum HOME_ROUTE{
		home
	}
	

	public  enum HOME_NTP{
		Home("/HOME/Home.hbs","FTO home page"),
		;
	
		String ntpPath;
		String desc;
		HOME_NTP(String t, String d){
			ntpPath = t;
			desc = d;
		}
	}
	
	

	
	@Override
	public void init(ServletConfig config) throws javax.servlet.ServletException {
			super.init(config);

			defaultRoute = HOME_ROUTE.home.name();

			routeMap.put(HOME_ROUTE.home.name(), homeHdlr);
	}
		
	public class Home extends RouteEO{

			@Override
			public void routeAction(HttpServletRequest request,
				HttpServletResponse response, Connection con, HttpSession session)
							throws IOException, Exception {
				String tPath = HOME_NTP.Home.ntpPath;
				Map<String,Object> map = new HashMap<String,Object>();
				//parser.parseOutput(map, tPath, response.getWriter());
				parser.parseTest(map,tPath,response.getWriter());

			}	
	}
}

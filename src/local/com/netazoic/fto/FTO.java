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
	
	RouteAction homeHdlr = new HomeHdlr();
	RouteAction router = new Router();
	
	public enum FTO_ROUTE{
		home("/", FTO_NTP.Home), 
		about("/about", FTO_NTP.About), 
		donate("/donate", FTO_NTP.Donate);
		
		String routeCode;
		String routeURL;
		FTO_NTP routeNTP;
		
		FTO_ROUTE(String url, FTO_NTP ntp){
			routeURL = url;
			routeCode = this.name();
			routeNTP = ntp;
		}
		
		static FTO_ROUTE getRoute(String url){
			for (FTO_ROUTE rte : FTO_ROUTE.values()){
				if(rte.routeURL.equals(url)){
					return rte;
				}
			}
			return null;
		}
	}
	

	public  enum FTO_NTP{
		Home("/HOME/Home.hbs","FTO home page"),
		About("/About.hbs","About FTO"),
		Donate("/Donate.hbs","Donate through FTO"),
		;
	
		String ntpPath;
		String desc;
		FTO_NTP(String t, String d){
			ntpPath = t;
			desc = d;
		}
	}
	
	

	
	@Override
	public void init(ServletConfig config) throws javax.servlet.ServletException {
			super.init(config);

			defaultRoute = FTO_ROUTE.home.name();

			routeMap.put(FTO_ROUTE.home.name(), router);
	}
		
	public class Router extends RouteEO{

		@Override
		public void routeAction(HttpServletRequest request,
			HttpServletResponse response, Connection con, HttpSession session)
						throws IOException, Exception {
			
			String url = request.getRequestURI();
			
			FTO_ROUTE route = FTO_ROUTE.getRoute(url);
			
			FTO_NTP tpl = FTO_NTP.Home;  //default
			if(route!=null) tpl = route.routeNTP;
			Map<String,Object> map = new HashMap<String,Object>();
			//TODO map = getRequestMap(request);
			parser.parseOutput(map,tpl.ntpPath,response.getWriter());

		}	
}
	
	public class HomeHdlr extends RouteEO{

			@Override
			public void routeAction(HttpServletRequest request,
				HttpServletResponse response, Connection con, HttpSession session)
							throws IOException, Exception {
				
				String url = request.getRequestURI();
				
				String route = getRoutePrimary(request);
				String tPath = FTO_NTP.Home.ntpPath;
				Map<String,Object> map = new HashMap<String,Object>();
				//parser.parseOutput(map, tPath, response.getWriter());
				parser.parseOutput(map,tPath,response.getWriter());

			}	
	}
}

package com.sofmit.fits.manage.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sofmit.fits.common.PortalBaseAction;
import com.sofmit.fits.manage.service.MNewsService;

@Controller
@RequestMapping("/manage")
public class MIndexAction extends PortalBaseAction {


	
	@RequestMapping("/index")
	public String index(HttpServletRequest rq,HttpServletResponse rp) {
		return "index/index";
	}
	
	@RequestMapping("/main")
	public String main(HttpServletRequest rq,HttpServletResponse rp) {
		
		HttpSession session = rq.getSession();
		session.setAttribute("username", "哈哈");
//		session.setAttribute("city_code", "510100");
		
		return "common/main";
	}
	@RequestMapping("/top")
	public String top(HttpServletRequest rq,HttpServletResponse rp) {
		return "common/top";
	}
	@RequestMapping("/left")
	public String left(HttpServletRequest rq,HttpServletResponse rp) {
		return "common/left";
	}
//	@RequestMapping("/index1")
//	public String index1(HttpServletRequest rq,HttpServletResponse rp) {
//		return "common/main";
//	}
	
//	public static void main(String[] args) {
//		int a = 22672;
//		int b = 19659;
//		int c = 24316;
//		System.out.println(22672+19659+24316-20000+4776);
//	}
}

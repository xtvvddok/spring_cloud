package com.sofmit.fits.manage.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sofmit.fits.common.PortalBaseAction;
import com.sofmit.fits.manage.service.MCityContentService;

@Controller
@RequestMapping("/manage/api")
public class MCityContentAction extends PortalBaseAction {

	@Resource
	private MCityContentService mcityContentService;

	
//	@RequestMapping("/findList")
//	public void findCityContentList(HttpServletRequest rq,HttpServletResponse rp) {
//		// TODO �˷�������ģ������չʾ
//	}
	
}

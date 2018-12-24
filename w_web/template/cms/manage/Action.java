package com.sofmit.fits.manage.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sofmit.fits.common.PortalBaseAction;
import com.sofmit.fits.manage.service.M${entity}Service;

@Controller
@RequestMapping("/manage/api")
public class M${entity}Action extends PortalBaseAction {

	@Resource
	private M${entity}Service m${lowerEntity}Service;

	
	@RequestMapping("/findList")
	public void find${entity}List(HttpServletRequest rq,HttpServletResponse rp) {
		// TODO 此方法仅作模版生成展示
	}
}

package com.sofmit.fits.Interface.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sofmit.fits.common.PortalBaseAction;
import com.sofmit.fits.Interface.service.I${entity}Service;
//import com.sofmit.sk.common.entity.${entity};

@Controller
@RequestMapping("/Interface/api")
public class I${entity}Action extends PortalBaseAction {

	@Resource
	private I${entity}Service i${lowerEntity}Service;

	
	@RequestMapping("/findList")
	public void find${entity}List(HttpServletRequest rq,HttpServletResponse rp) {
		// TODO 此方法仅作模版生成展示
	}
}

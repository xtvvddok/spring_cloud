package com.sofmit.fits.manage.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sofmit.fits.common.PortalBaseAction;
import com.sofmit.fits.common.SkParam;
import com.sofmit.fits.manage.service.MAreaService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/manage")
public class MAreaAction extends PortalBaseAction {

	@Resource
	private MAreaService mareaService;

	
	@RequestMapping("/getAreaCode")
	public void getAreaCode(SkParam param ,HttpServletRequest rq,HttpServletResponse rp) {
		// TODO �˷�������ģ������չ
		try {
			List<Map<String, Object>> araaCode = mareaService.getAraaCode(param);
			SuccessInfo(JSONArray.fromObject(araaCode), rp);
			return;
		} catch (Exception e) {
			e.printStackTrace();
			Error("异常", rp);
			return;
		}
	
	}
}

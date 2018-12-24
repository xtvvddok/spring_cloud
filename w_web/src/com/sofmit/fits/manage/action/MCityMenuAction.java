package com.sofmit.fits.manage.action;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sofmit.fits.bean.CityMenu;
import com.sofmit.fits.bean.News;
import com.sofmit.fits.common.PortalBaseAction;
import com.sofmit.fits.common.RunMsg;
import com.sofmit.fits.common.SkParam;
import com.sofmit.fits.common.utils.DataModel;
import com.sofmit.fits.manage.service.MCityMenuService;

@Controller
@RequestMapping("/manage")
public class MCityMenuAction extends PortalBaseAction {

	@Resource
	private MCityMenuService mcityMenuService;

	
	@RequestMapping("/menu_list")
	public String menu_list(SkParam param,HttpServletRequest rq,HttpServletResponse rp) {
		rq.setAttribute("city_code", param.getCity());
		return "city/menu_list";
	}
	
	@RequestMapping("/menu_view")
	public String news_view(SkParam param,HttpServletRequest rq,HttpServletResponse rp) {
		if(param.getId() != null){
			CityMenu menu = mcityMenuService.get(param.getId());
			rq.setAttribute("menu", menu);
		}
		if(param.getCity() != null && !"".equals(param.getCity())){
			rq.setAttribute("city_code", param.getCity());
		}
		return "city/menu_view";
	}
	
	@RequestMapping("/menu_del")
	public void menu_del(SkParam param,HttpServletRequest rq,HttpServletResponse rp) {
		try {
			if(param.getId() != null){
				CityMenu menu = mcityMenuService.get(param.getId());
				menu.setStatus(-1);
				mcityMenuService.update(menu);
				SuccessMsg("删除成功", rp);
				return;
			} else {
				Error("参数异常", rp);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			Error("系统异常", rp);
			return;
		}
		
	}
	@RequestMapping("/pubMenuOrDown")
	public void pubNewOrDown(SkParam param,Integer status,HttpServletRequest rq,HttpServletResponse rp) {
		try {
			if(param.getId() != null && status != null){
				CityMenu menu  = mcityMenuService.get(param.getId());
				menu.setStatus(status);
				mcityMenuService.update(menu);
				SuccessMsg("操作成功", rp);
				return;
			} else {
				Error("参数异常", rp);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			Error("系统异常", rp);
			return;
		}
		
	}
	
	
	@RequestMapping("/menu_page")
	public void menu_page(SkParam param,HttpServletRequest rq,HttpServletResponse rp) {
		DataModel page = mcityMenuService.getPage(param);
		writeText(net.sf.json.JSONObject.fromObject(page).toString(),  rp);
	}
	@RequestMapping("/saveMenu")
	public void saveMenu(CityMenu menu,HttpServletRequest rq,HttpServletResponse rp) {
		try {
			RunMsg msg = new RunMsg();
			HttpSession session = rq.getSession();
			if(menu == null){
				Error("参数异常", rp);
				return;
			}
			if(menu.getId() == null || "".equals(menu.getId())){
				menu.setCreate_time(new Date());
				menu.setCreate_user(session.getAttribute("username").toString());
				menu.setStatus(0);
				msg = mcityMenuService.addCityMenu(menu);
			} else {
				CityMenu menu2 = mcityMenuService.get(menu.getId());
				menu2.setIcon_value(menu.getIcon_value());
				menu2.setIcon(menu.getIcon());
				menu2.setImage(menu.getImage());
				menu2.setUpdate_time(new Date());
				menu2.setStatus(0);
				msg = mcityMenuService.addCityMenu(menu2);
			}
			if(msg.isState()){
				SuccessMsg("操作成功", rp);
				return;
			} else {
				Error("操作异常", rp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Error("系统异常", rp);
		}
	}
	
}

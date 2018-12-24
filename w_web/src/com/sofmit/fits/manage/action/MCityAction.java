package com.sofmit.fits.manage.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sofmit.fits.bean.City;
import com.sofmit.fits.bean.News;
import com.sofmit.fits.common.PortalBaseAction;
import com.sofmit.fits.common.RunMsg;
import com.sofmit.fits.common.SkParam;
import com.sofmit.fits.common.utils.DataModel;
import com.sofmit.fits.manage.service.MCityService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/manage")
public class MCityAction extends PortalBaseAction {

	@Resource
	private MCityService mcityService;

	
	@RequestMapping("/console")
	public String console(SkParam param,HttpServletRequest rq,HttpServletResponse rp) {
		rq.setAttribute("city_code", param.getCity());
		rq.setAttribute("id",param.getId());
		return "index/console";
	}
	
	@RequestMapping("/getCityView")
	public void getCityView(SkParam param,HttpServletRequest rq,HttpServletResponse rp) {
		try {
			if(param.getCity() != null && !"".equals(param.getCity())){
				City c = new City();
				c.setCity_code(param.getCity());
				List<City> list = mcityService.get(c);
				if(list != null && list.size() > 0){
					SuccessInfo(JSONObject.fromObject(list.get(0)), rp);
					return;
				} else {
					Warning(null, rp);
					return;
				}
			} else {
				Error("参数异常", rp);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			Error("异常", rp);
			return;
		}
		
	}

	@RequestMapping("/city_list")
	public String city_list(SkParam param,HttpServletRequest rq,HttpServletResponse rp) {
//		DataModel page = mnewsService.getPage(param);
		return "city/city_list";
	}
	
	@RequestMapping("/city_view")
	public String city_view(SkParam param,HttpServletRequest rq,HttpServletResponse rp) {
//		DataModel page = mnewsService.getPage(param);
		if(param.getId() != null){
			City city = mcityService.get(param.getId());
			rq.setAttribute("city", city);
		}
		return "city/city_view";
	}
	
	@RequestMapping("/city_del")
	public void city_del(SkParam param,HttpServletRequest rq,HttpServletResponse rp) {
		try {
			if(param.getId() != null){
				City city = mcityService.get(param.getId());
				city.setStatus(-1);
				mcityService.update(city);
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
	@RequestMapping("/pubCityOrDown")
	public void pubCityOrDown(SkParam param,Integer status,HttpServletRequest rq,HttpServletResponse rp) {
		try {
			if(param.getId() != null && status != null){
				City city = mcityService.get(param.getId());
				city.setStatus(status);
				mcityService.update(city);
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
	
	
	@RequestMapping("/city_page")
	public void city_page(SkParam param,HttpServletRequest rq,HttpServletResponse rp) {
		DataModel page = mcityService.getPage(param);
		writeText(net.sf.json.JSONObject.fromObject(page).toString(),  rp);
	}
	@RequestMapping("/city_index_page")
	public void city_index_page(SkParam param,HttpServletRequest rq,HttpServletResponse rp) {
		DataModel page = mcityService.getCityPage(param);
		writeText(net.sf.json.JSONObject.fromObject(page).toString(),  rp);
	}
	@RequestMapping("/saveCity")
	public void saveCity(City city,HttpServletRequest rq,HttpServletResponse rp) {
		try {
			RunMsg msg = new RunMsg();
			HttpSession session = rq.getSession();
			if(city == null){
				Error("参数异常", rp);
				return;
			}
			if(city.getId() == null || "".equals(city.getId())){
				city.setCreate_time(new Date());
				city.setCreate_user(session.getAttribute("username").toString());
//				city.setCity_code(session.getAttribute("city_code").toString());
				city.setStatus(0);
				msg = mcityService.addCity(city);
			} else {
				City city2 = mcityService.get(city.getId());
				city2.setCity_name(city.getCity_name());
				city2.setCity_code(city.getCity_code());
				city2.setSummary(city.getSummary());
				city2.setTopimage(city.getTopimage());
				city2.setUpdate_time(new Date());
				city2.setStatus(0);
				msg = mcityService.addCity(city2);
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

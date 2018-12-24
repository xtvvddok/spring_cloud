package com.sofmit.fits.manage.action;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sofmit.fits.bean.Activity;
import com.sofmit.fits.bean.News;
import com.sofmit.fits.common.PortalBaseAction;
import com.sofmit.fits.common.RunMsg;
import com.sofmit.fits.common.SkParam;
import com.sofmit.fits.common.utils.DataModel;
import com.sofmit.fits.manage.service.MActivityService;

@Controller
@RequestMapping("/manage")
public class MActivityAction extends PortalBaseAction {

	@Resource
	private MActivityService mactivityService;

	
	@RequestMapping("/activity_list")
	public String activity_list(SkParam param,HttpServletRequest rq,HttpServletResponse rp) {
		rq.setAttribute("city_code", param.getCity());
		return "activity/activity_list";
	}
	
	@RequestMapping("/activity_view")
	public String activity_view(SkParam param,HttpServletRequest rq,HttpServletResponse rp) {
		if(param.getId() != null && !"".equals(param.getId())){
			Activity activity = mactivityService.get(param.getId());
			rq.setAttribute("activity", activity);
		}
		if(param.getCity() != null && !"".equals(param.getCity())){
			rq.setAttribute("city_code", param.getCity());
		}
		return "activity/activity_view";
	}
	
	@RequestMapping("/activity_page")
	public void activity_page(SkParam param,HttpServletRequest rq,HttpServletResponse rp) {
		DataModel page = mactivityService.getPage(param);
		writeText(net.sf.json.JSONObject.fromObject(page).toString(),  rp);
	}
	@RequestMapping("/saveActivity")
	public void saveActivity(Activity activity,HttpServletRequest rq,HttpServletResponse rp) {
		try {
			RunMsg msg = new RunMsg();
			HttpSession session = rq.getSession();
			if(activity == null){
				Error("参数异常", rp);
				return;
			}
			if(activity.getId() == null || "".equals(activity.getId())){
				activity.setCreate_time(new Date());
				activity.setCreate_user(session.getAttribute("username").toString());
//				activity.setCity_code(session.getAttribute("city_code").toString());
				activity.setStatus(0);
				msg = mactivityService.addActivity(activity);
			} else {
				Activity a = mactivityService.get(activity.getId());
				a.setSummary(activity.getSummary());
				a.setTitle(activity.getTitle());
				a.setTopimage(activity.getTopimage());
				msg = mactivityService.addActivity(a);
			}
			if(msg.isState()){
				SuccessMsg("成功", rp);
				return;
			} else {
				Error("数据异常", rp);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			Error("系统异常", rp);
			return;
		}
		
	}
	@RequestMapping("/activity_del")
	public void activity_del(SkParam param,HttpServletRequest rq,HttpServletResponse rp) {
		try {
			if(param.getId() != null){
//				News news = mnewsService.get(param.getId());
				Activity a = mactivityService.get(param.getId());
				a.setStatus(-1);
				mactivityService.update(a);
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
	@RequestMapping("/pubActivityOrDown")
	public void pubActivityOrDown(SkParam param,Integer status,HttpServletRequest rq,HttpServletResponse rp) {
		try {
			if(param.getId() != null && status != null){
				Activity a = mactivityService.get(param.getId());
				a.setStatus(status);
				mactivityService.update(a);
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
}

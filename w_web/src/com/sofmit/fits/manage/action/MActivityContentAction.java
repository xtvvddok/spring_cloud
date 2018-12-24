package com.sofmit.fits.manage.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sofmit.fits.bean.Activity;
import com.sofmit.fits.bean.News;
import com.sofmit.fits.common.PortalBaseAction;
import com.sofmit.fits.common.SkParam;
import com.sofmit.fits.manage.service.MActivityContentService;
import com.sofmit.fits.manage.service.MActivityService;
import com.sofmit.fits.vo.NewsContentVo;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/manage")
public class MActivityContentAction extends PortalBaseAction {

	@Resource
	private MActivityContentService mactivityContentService;
	@Resource
	private MActivityService mactivityService;

	
	@RequestMapping("/activity_content_list")
	public String activity_content_list(String n_id,HttpServletRequest rq,HttpServletResponse rp) {
		Activity activity = mactivityService.get(n_id);
		SkParam param = new SkParam();
		param.setId(n_id);
		List<Map<String, Object>> contents = mactivityContentService.getContents(param);
		rq.setAttribute("activity", activity);
		rq.setAttribute("contents", contents);
		return "activity/activity_content_list";
	}
	
	@RequestMapping("/saveActivityContent")
	public void saveActivityContent(String json, String n_id,HttpServletRequest rq,HttpServletResponse rp) {
		List<NewsContentVo> vos = JSONArray.toList(JSONArray.fromObject(json), NewsContentVo.class);
		if(mactivityContentService.addContent(vos, n_id)){
			SuccessMsg("保存成功", rp);
			return;
		} else {
			Error("异常", rp);
			return;
		}
	}
}

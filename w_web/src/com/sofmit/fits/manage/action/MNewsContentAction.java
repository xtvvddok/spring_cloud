package com.sofmit.fits.manage.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sofmit.fits.bean.News;
import com.sofmit.fits.bean.NewsContent;
import com.sofmit.fits.common.PortalBaseAction;
import com.sofmit.fits.common.SkParam;
import com.sofmit.fits.manage.service.MNewsContentService;
import com.sofmit.fits.manage.service.MNewsService;
import com.sofmit.fits.vo.NewsContentVo;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/manage")
public class MNewsContentAction extends PortalBaseAction {

	@Resource
	private MNewsContentService mnewsContentService;
	@Resource
	private MNewsService mnewsService;

	

	
	@RequestMapping("/news_content_list")
	public String news_content_list(String n_id,HttpServletRequest rq,HttpServletResponse rp) {
		News news = mnewsService.get(n_id);
		SkParam param = new SkParam();
		param.setId(n_id);
		List<Map<String, Object>> contents = mnewsContentService.getContents(param);
		rq.setAttribute("news", news);
		rq.setAttribute("contents", contents);
		return "news/news_content_list";
	}
	
	
	@RequestMapping("/saveNewsContent")
//	public void saveContent(@RequestBody List<NewsContentVo> vos,@RequestBody String n_id,HttpServletRequest rq,HttpServletResponse rp) {
	public void saveContent(String json, String n_id,HttpServletRequest rq,HttpServletResponse rp) {
//		JSONArray.
		List<NewsContentVo> vos = JSONArray.toList(JSONArray.fromObject(json), NewsContentVo.class);
		if(mnewsContentService.addContent(vos, n_id)){
			SuccessMsg("保存成功", rp);
			return;
		} else {
			Error("异常", rp);
			return;
		}
//		System.out.println(json);
//		System.out.println(n_id);
//		SuccessMsg("保存成功", rp);
	}
	
//	@RequestMapping("/getNewsContent")
////	public void saveContent(@RequestBody List<NewsContentVo> vos,@RequestBody String n_id,HttpServletRequest rq,HttpServletResponse rp) {
//	public void getNewsContent( String n_id,HttpServletRequest rq,HttpServletResponse rp) {
////		JSONArray.
//		List<NewsContentVo> vos = JSONArray.toList(JSONArray.fromObject(json), NewsContentVo.class);
//		if(mnewsContentService.addContent(vos, n_id)){
//			SuccessMsg("保存成功", rp);
//			return;
//		} else {
//			Error("异常", rp);
//			return;
//		}
////		System.out.println(json);
////		System.out.println(n_id);
////		SuccessMsg("保存成功", rp);
//	}
//	
//	public 
}

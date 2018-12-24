package com.sofmit.fits.manage.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.sofmit.fits.bean.News;
import com.sofmit.fits.bean.NewsContent;
import com.sofmit.fits.common.PortalBaseAction;
import com.sofmit.fits.common.RunMsg;
import com.sofmit.fits.common.SkParam;
import com.sofmit.fits.common.utils.DataModel;
import com.sofmit.fits.manage.service.MNewsService;
import com.sofmit.fits.vo.NewsContentListVo;
import com.sofmit.fits.vo.NewsContentVo;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/manage")
public class MNewsAction extends PortalBaseAction {

	@Resource
	private MNewsService mnewsService;


	@RequestMapping("/news_list")
	public String news_list(SkParam param,HttpServletRequest rq,HttpServletResponse rp) {
		rq.setAttribute("city_code", param.getCity());
		return "news/news_list";
	}
	
	@RequestMapping("/news_view")
	public String news_view(SkParam param,HttpServletRequest rq,HttpServletResponse rp) {
		if(param.getId() != null){
			News news = mnewsService.get(param.getId());
			rq.setAttribute("news", news);
		}
		if(param.getCity() != null && !"".equals(param.getCity())){
			rq.setAttribute("city_code", param.getCity());
		}
		return "news/news_view";
	}
	
	@RequestMapping("/news_del")
	public void news_del(SkParam param,HttpServletRequest rq,HttpServletResponse rp) {
		try {
			if(param.getId() != null){
				News news = mnewsService.get(param.getId());
				news.setStatus(-1);
				mnewsService.update(news);
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
	@RequestMapping("/pubNewOrDown")
	public void pubNewOrDown(SkParam param,Integer status,HttpServletRequest rq,HttpServletResponse rp) {
		try {
			if(param.getId() != null && status != null){
				News news = mnewsService.get(param.getId());
				news.setStatus(status);
				mnewsService.update(news);
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
	
	
	@RequestMapping("/news_page")
	public void news_page(SkParam param,HttpServletRequest rq,HttpServletResponse rp) {
		DataModel page = mnewsService.getPage(param);
		writeText(net.sf.json.JSONObject.fromObject(page).toString(),  rp);
	}
	@RequestMapping("/saveNews")
	public void saveNews(News news,HttpServletRequest rq,HttpServletResponse rp) {
		try {
			RunMsg msg = new RunMsg();
			HttpSession session = rq.getSession();
			if(news == null){
				Error("参数异常", rp);
				return;
			}
			if(news.getId() == null || "".equals(news.getId())){
				news.setCreate_time(new Date());
				news.setCreate_user(session.getAttribute("username").toString());
//				news.setCity_code(session.getAttribute("city_code").toString());
				news.setStatus(0);
				msg = mnewsService.addNews(news);
			} else {
				News news2 = mnewsService.get(news.getId());
				news2.setTitle(news.getTitle());
				news2.setNavigational(news.getNavigational());
				news2.setTopimage(news.getTopimage());
				news2.setUpdate_time(new Date());
				news2.setStatus(0);
				msg = mnewsService.addNews(news2);
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
	

	
	
	
	
//	
//	public static void main(String[] args) {
//		double a = 185.53;
//		double b = a+120.00+350.00+190.00+285.00+1238.50+75.50+57.00+36.91+68.34+486.00;
//		
//		
//		System.out.println(b);
//	}
}

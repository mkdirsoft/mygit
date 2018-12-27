package com.flx.flxoa.info.market.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flx.flxoa.common.util.Msg;
import com.flx.flxoa.info.market.entity.HxCropcategory;
import com.flx.flxoa.info.market.entity.HxFavorite;
import com.flx.flxoa.info.market.entity.HxFollow;
import com.flx.flxoa.info.market.entity.HxNews;
import com.flx.flxoa.info.market.entity.HxPersonalsubscriptionsdel;
import com.flx.flxoa.info.market.entity.HxRegion;
import com.flx.flxoa.info.market.entity.HxSource;
import com.flx.flxoa.info.market.entity.HxSubscribe;
import com.flx.flxoa.info.market.entity.HxUser;
import com.flx.flxoa.info.market.manager.HxCropcategoryService;
import com.flx.flxoa.info.market.manager.HxFavoriteService;
import com.flx.flxoa.info.market.manager.HxFollowService;
import com.flx.flxoa.info.market.manager.HxNewsService;
import com.flx.flxoa.info.market.manager.HxPersonalsubscriptionsdelService;
import com.flx.flxoa.info.market.manager.HxRegionService;
import com.flx.flxoa.info.market.manager.HxSourceService;
import com.flx.flxoa.info.market.manager.HxSubscribeService;
import com.flx.flxoa.info.market.manager.HxUserService;
import com.flx.flxoa.info.system.entity.FlxoaSystemDepartment;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class XxcsMyMessageController {
	protected HxSubscribeService hxSubscribeService;
	@Autowired
	public void setHxSubscribeService(
			HxSubscribeService hxSubscribeService) {
		this.hxSubscribeService = hxSubscribeService;
	}
	
	
	
	protected HxFollowService hxFollowService;
	@Autowired
	public void setHxFollowService(
			HxFollowService hxFollowService) {
		this.hxFollowService = hxFollowService;
	}
	
	
	
	protected HxFavoriteService hxFavoriteService;
	@Autowired
	public void setHxFavoriteService(
			HxFavoriteService hxFavoriteService) {
		this.hxFavoriteService = hxFavoriteService;
	}
	
	
	protected HxRegionService hxRegionService;
	@Autowired
	public void setHxRegionService(
			HxRegionService hxRegionService) {
		this.hxRegionService = hxRegionService;
	}
	
	
	protected HxCropcategoryService hxCropcategoryService;
	@Autowired
	public void setHxCropcategoryService(
			HxCropcategoryService hxCropcategoryService) {
		this.hxCropcategoryService = hxCropcategoryService;
	}
	
	
	protected HxSourceService hxSourceService;
	@Autowired
	public void setHxSourceService(
			HxSourceService hxSourceService) {
		this.hxSourceService = hxSourceService;
	}
	
	protected HxNewsService hxNewsService;
	@Autowired
	public void setHxNewsService(
			HxNewsService hxNewsService) {
		this.hxNewsService = hxNewsService;
	}
	
	protected HxUserService hxUserService;
	@Autowired
	public void setHxUserService(
			HxUserService hxUserService) {
		this.hxUserService = hxUserService;
	}
	
	protected HxPersonalsubscriptionsdelService hxPersonalsubscriptionsdelService;
	@Autowired
	public void setHxPersonalsubscriptionsdelService(
			HxPersonalsubscriptionsdelService hxPersonalsubscriptionsdelService) {
		this.hxPersonalsubscriptionsdelService = hxPersonalsubscriptionsdelService;
	}
	//Msg msg = new Msg();
	/**
	 * 我的订阅
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "Subscribe", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String Subscribe(HttpServletRequest request,HttpServletResponse response) {
		HttpServletRequest req = (HttpServletRequest)request;
		String start = request.getParameter("PageNum"); 
		String length = request.getParameter("PerPageNum");
		
		String OfferDate = request.getParameter("OfferDate");
		if (start==""||start==null){
			start="0";
		}
		if(length==""||length==null){
			length="100";
		}
		//用户id
		String UserID =request.getParameter("tokenid");
		//个人订阅-显示最新一天订阅数据1
		String PersonalSubscriptions = request.getParameter("PersonalSubscriptions");
		//每页条数
		String PerPageNum =start;
		//页码
		String PageNum =length;
		//将前台请求参数统一放入map中
		Map<String,String> map  = new HashMap<>();
		map.put("UserID", UserID);
		map.put("length", PageNum);
		map.put("start", PerPageNum);
		map.put("PersonalSubscriptions", PersonalSubscriptions);
		return hxSubscribeService.queryForPage(map);
	}
	
	/**
	 * 我的订阅-新增订阅
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "SubscribeAdd",  produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String SubscribeAdd(HttpServletRequest request,HttpServletResponse response,HxSubscribe model) throws UnsupportedEncodingException {
		HttpServletRequest req = (HttpServletRequest)request;
		Map map = new HashMap<>();
		//地区表
		HxRegion hxRegion = new HxRegion();
		//品类表
		HxCropcategory hxCropcategory = new HxCropcategory();
		
		//地id
		String RegionCode = request.getParameter("RegionCode"); 
		//品类id
		String CropCategoryCode = request.getParameter("CropCategoryCode");
		//价格
		String Price = request.getParameter("Price"); 
		//字符串
		String CropOfferStr = request.getParameter("CropOfferStr");
		String new_str = new String(CropOfferStr.getBytes("iso-8859-1"), "utf-8");
		//用户id
		String UserID =request.getParameter("tokenid");
		//String UserID ="16";
		//判断是否重复订阅
		boolean Subscribe =hxSubscribeService.isExist(UserID, RegionCode, CropCategoryCode);
		if(Subscribe) {
			hxRegion.setRegionCode(RegionCode);
			HxRegion hxRegions = hxRegionService.queryById(hxRegion);
			
			hxCropcategory.setCropCategoryCode(CropCategoryCode);
			HxCropcategory hxCropcategorys = hxCropcategoryService.queryById(hxCropcategory);
			
			//地区名称
			model.setRegionCode(RegionCode);
			//品类名称
			model.setCropCategoryName(hxCropcategorys.getCropCategoryName());
			//地区id
			model.setRegion(hxRegions.getRegion());
			//品类id
			model.setCropCategoryCode(CropCategoryCode);
			//价格
			model.setPrice(Long.parseLong(Price));
			//字符串
			model.setCropOfferStr(new_str);
			model.setUserId(Integer.valueOf(UserID));
			boolean subscribe = hxSubscribeService.add(model);
			if(subscribe) {
				map.put("code", 200);
				map.put("Msg","成功");
			}else {
				map.put("code", 500);
				map.put("Msg","服务错误");
			}
		}else {
			map.put("code", 500);
			map.put("Msg","请不要重复订阅");
		}
		JSONObject json = JSONObject.fromObject(map);
		return json.toString();
	}
	
	/**
	 * 我的订阅-根据ID删除
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "SubscribeDel",  produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String SubscribeDelete(HttpServletRequest request,HttpServletResponse response,HxSubscribe model) {
		HttpServletRequest req = (HttpServletRequest)request;
		//个人订阅记录表
		HxPersonalsubscriptionsdel  hxPersonalsubscriptionsdel = new HxPersonalsubscriptionsdel();
		//订阅表id，先查后删
		String delete = request.getParameter("SubscribeID");
		//用户id
		String UserID =request.getParameter("tokenid");
		//个人订阅记录表id
		String SubscribeCode = request.getParameter("SubscribeID");
		model.setSubscribeId(Integer.valueOf(delete));
		//订阅表id，先查后删
		hxPersonalsubscriptionsdel.setSubscribeCode(delete);
		hxPersonalsubscriptionsdel.setUserId(UserID);
		
		boolean personalsubscriptionsdel = hxPersonalsubscriptionsdelService.delete(hxPersonalsubscriptionsdel);
		boolean subscribe = hxSubscribeService.delete(model);
		
		Map map = new HashMap<>();
		if(subscribe) {
			map.put("code", 200);
			map.put("Msg","成功");
		}else {
			map.put("code", 500);
			map.put("Msg","服务错误");
		}
		
		JSONObject json = JSONObject.fromObject(map);
		return json.toString();
	}
	
	/**
	 * 个人订阅-删除(添加)
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "PersonalSubscriptionsDelete",  produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String PersonalSubscriptionsDelete(HttpServletRequest request,HttpServletResponse response,HxPersonalsubscriptionsdel model) {
		HttpServletRequest req = (HttpServletRequest)request;
		//报价表id
		String CropOfferID = request.getParameter("CropOfferID");
		//报价表id
		String SubscribeID = request.getParameter("SubscribeID");
		//用户id
		String UserID =request.getParameter("tokenid");
		model.setCropOfferCode(CropOfferID);
		model.setSubscribeCode(SubscribeID);
		model.setUserId(UserID);
		boolean personalsu = hxPersonalsubscriptionsdelService.add(model);
		
		Map map = new HashMap<>();
		if(personalsu) {
			map.put("code", 200);
			map.put("Msg","成功");
		}else {
			map.put("code", 500);
			map.put("Msg","服务错误");
		}
		
		JSONObject json = JSONObject.fromObject(map);
		return json.toString();
	}
	
	
	
	
	/**
	 * 我的关注
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "Follow",  produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String Follow(HttpServletRequest request,HttpServletResponse response) {
		HttpServletRequest req = (HttpServletRequest)request;
		String start = request.getParameter("PageNum"); 
		String length = request.getParameter("PerPageNum");
		if (start==""||start==null){
			start="0";
		}
		if(length==""||length==null){
			length="10";
		}
		//用户id
		String UserID =request.getParameter("tokenid");
		//每页条数
		String PerPageNum =start;
		//页码
		String PageNum =length;
		//将前台请求参数统一放入map中
		Map<String,String> map  = new HashMap<>();
		map.put("UserID", UserID);
		map.put("length", PageNum);
		map.put("start", PerPageNum);
		return hxFollowService.queryForPage(map);
	}
	/**
	 * 添加更多-关注
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "FollowMore",  produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String FollowMore(HttpServletRequest request,HttpServletResponse response) {
		HttpServletRequest req = (HttpServletRequest)request;
		String start = request.getParameter("PageNum"); 
		String length = request.getParameter("PerPageNum");
		if (start==""||start==null){
			start="0";
		}
		if(length==""||length==null){
			length="100";
		}
		//每页条数
		String PerPageNum =start;
		//页码
		String PageNum =length;
		//用户id
		String UserID =request.getParameter("tokenid");
		//将前台请求参数统一放入map中
		Map<String,String> map  = new HashMap<>();
		map.put("UserID", UserID);
		map.put("length", PageNum);
		map.put("start", PerPageNum);
		return hxFollowService.queryForPageMore(map);
	}
	
	
	/**
	 * 我的关注-新增关注
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/FollowAdd", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String FollowAdd(HttpServletRequest request,HttpServletResponse response,HxFollow model) {
		HttpServletRequest req = (HttpServletRequest)request;
		//来源表
		HxSource hxSource = new HxSource();
		Map map = new HashMap<>();
		//用户id
		String UserID =request.getParameter("tokenid");
		//来源id
		String SourceCode = request.getParameter("SourceCode");
		boolean hxFollowTrue = hxFollowService.isExist(SourceCode,UserID);
		if(hxFollowTrue) {
			hxSource.setSourceCode(SourceCode);
			HxSource hxSources = hxSourceService.queryById(hxSource);
			model.setHxSource(hxSources);
			model.setSourceName(hxSources.getSourceName());
			
			HxUser hxUser = new HxUser();
			hxUser.setUserId(Integer.valueOf(UserID));
			model.setHxUser(hxUser);
			boolean hxFollow = hxFollowService.add(model);
		
			if(hxFollow) {
				map.put("code", 200);
				map.put("Msg","成功");
			}else {
				map.put("code", 500);
				map.put("Msg","服务错误");
			}
		}else {
			map.put("code", 200);
			map.put("Msg","已关注该来源，不能重复关注");
		}
		JSONObject json = JSONObject.fromObject(map);
		return json.toString();
	}
	
	/**
	 * 我的关注-根据ID删除
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/FollowDel", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String FollowDelete(HttpServletRequest request,HttpServletResponse response,HxFollow model) {
		HttpServletRequest req = (HttpServletRequest)request;
		//关注表id
		String delete = request.getParameter("SourceCode");
		model.setFollowId(Integer.valueOf(delete));
		boolean hxFollow = hxFollowService.delete(model);
		Map map = new HashMap<>();
		if(hxFollow) {
			map.put("code", 200);
			map.put("Msg","成功");
		}else {
			map.put("code", 500);
			map.put("Msg","服务错误");
		}
		JSONObject json = JSONObject.fromObject(map);
		return json.toString();
	}
	
	/**
	 * 我的收藏
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/Favorite", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String Favorite(HttpServletRequest request,HttpServletResponse response) {
		HttpServletRequest req = (HttpServletRequest)request;
		String start = request.getParameter("PageNum"); 
		String length = request.getParameter("PerPageNum");
		if (start==""||start==null){
			start="0";
		}
		if(length==""||length==null){
			length="100";
		}
		//用户id
		String UserID =request.getParameter("tokenid");
		//每页条数
		String PerPageNum =start;
		//页码
		String PageNum =length;
		//将前台请求参数统一放入map中
		Map<String,String> map  = new HashMap<>();
		map.put("UserID", UserID);
		map.put("length", PageNum);
		map.put("start", PerPageNum);
		return hxFavoriteService.queryForPage(map);
	}
	
	/**
	 * 我的收藏-添加
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/FavoriteAdd", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String FavoriteAdd(HttpServletRequest request,HttpServletResponse response,HxFavorite model) {
		HttpServletRequest req = (HttpServletRequest)request;
		HxNews hxNews = new HxNews();
		//来源表
		HxSource hxSource = new HxSource();
		//用户id
		String UserID =request.getParameter("tokenid");
		Map map = new HashMap<>();
		//咨询信息id
		String NewsID = request.getParameter("NewsID");
		boolean HxFavoriteTrue = hxFavoriteService.isExist(NewsID,UserID);
		if(HxFavoriteTrue) {
			hxNews.setNewsId(Integer.valueOf(NewsID));
			HxNews hxNewss = hxNewsService.queryById(hxNews);
			//咨询标题
			model.setTitle(hxNewss.getTitle());
			//咨询id
			model.setHxNews(hxNewss);
			HxUser hxUser = new HxUser();
			hxUser.setUserId(Integer.valueOf(UserID));
			HxUser hxUsers = hxUserService.queryById(hxUser);
			model.setHxUser(hxUser);
			boolean HxFavorite = hxFavoriteService.add(model);
			if(HxFavorite) {
				map.put("code", 200);
				map.put("Msg","成功");
			}else {
				map.put("code", 500);
				map.put("Msg","服务错误");
			}
		}else {
			map.put("code", 200);
			map.put("Msg","已收藏该新闻，不能重复收藏");
		}
		JSONObject json = JSONObject.fromObject(map);
		return json.toString();
	}
	
	/**
	 * 我的收藏-删除
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/FavoriteDel", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String FavoriteDelete(HttpServletRequest request,HttpServletResponse response,HxFavorite model) {
		HttpServletRequest req = (HttpServletRequest)request;
		HxNews hxNews = new HxNews();
		
		//咨询信息id
		String NewsID = request.getParameter("NewsID");
		model.setFavoriteId(Integer.valueOf(NewsID));
		boolean News = hxFavoriteService.delete(model);
		Map map = new HashMap<>();
		if(News) {
			map.put("code", 200);
			map.put("Msg","成功");
		}else {
			map.put("code", 500);
			map.put("Msg","服务错误");
		}
		
		JSONObject json = JSONObject.fromObject(map);
		return json.toString();
	}
}

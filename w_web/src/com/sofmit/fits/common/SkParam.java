package com.sofmit.fits.common;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class SkParam {
	
	//微信交易号
	private String transaction_id;
	//支付宝交易号
	private String trade_no;
	
	private String source;
	
	private String appversion;
	private String platform;
	
	
	
	
	
	
	
	private String ishave;
	private String id_county;
	private String seatchprice;
	private String business;
	private String trip_theme;
	private String g_id;//规格ID
	private String city;
	private String day_id;
	private Long dds_s_id;
	private String comment_id;
	
	// 商户ID
	private String m_id;
	// 排序字段；
	private String score;
	private String user_id;

	
	private String price;
	private String range;
	private String sold;
	private String hId;

	private String account_no;
	private String openid;
	private String clicktime;
	
	private String checkdays;
	private int ordercount;
	private int children_count;
	private Long sell_id;
	private String travelshareid;

	private String grade_low;
	private String sAreaId;
	
	private String needpic;

	private String tag;

	private String pro_type;
	
	private String iscomment;
	private String batch_id;
	private String coupon_id;
	private String searchby;
	private String pro_id;
	private String s_id;
	/** 手机请求标识 */
	private String phoneid;
	/** 手机请求参数签名 */
	private String sign;
	/** 请求时间戳 */
	private long timestamp;

	private String type;

	private String searchtime;
	private String searchstatus;

	// 资讯类型ID
	private String datatype;

	// 出行风向标类型ID
	private String tsid;

	// 特色产品ID
	private String featureproid;

	public String gethId() {
		return hId;
	}

	public void sethId(String hId) {
		this.hId = hId;
	}

	// ID
	private String id;
	/** 查询类型 1：景区，2：酒店，3：农家乐，4：餐厅，5：旅行社，6：特产，7：娱乐 **/
	private String searchtype;

	// 查询主题
	private String searchtheme;

	private String searchplanday;
	// 地区
	private String[] searcharea;
	/** 距离 */
	private String distance;
	/** 经度 **/
	private double lng = 0.0;
	/** 纬度 **/
	private double lat = 0.0;
	/** 当前页码 **/
	private int pid = 1;
	/** 分页大小 **/
	private int psize = 20;
	/** 排序字段 **/
	private String sort;
	/** 排序方式 **/
	private String sortd;
	/** 景区ID **/
	private String id_view;
	/** 星级 **/
	private float star;
	/** 所属区县 **/
	private String id_area;
	/** 景区热度 **/
	private Integer hot;
	/** 最低门票价格 **/
	private Double minprice;
	/** 最高门票价格 **/
	private Double maxprice;
	/**
	 * 关键字搜索
	 */
	private String keyword;

	private String userphone;
	private String password;
	/** 短信验证码 **/
	private String msgver;

	/** APP游客ID **/
	private String id_user;
	
	private String newpassword;
	private String username;

	private String usericon;
	private String mail;

	/** 攻略ID **/
	private String id_strategy;
	/** 评论内容 **/
	private String comm;
	/** 攻略内容 **/
	private String stragedy;
	private String stracontent;
	private String stratitle;// 攻略标题
	private String straicon;// 攻略图标
	private String id_travinfo;

	private String id_comment;// 评论id
	private String commentcont;
	private Double comlvl;

	/** 收藏id **/
	private String id_fav;
	private String id_view_im;
	/** 收藏商品id **/
	private String id_product;
	/** 收藏类型(景区、酒店） **/
	private String favtype;
	/** 收藏名称 **/
	private String favname;
	/** 图片 **/
	private MultipartFile pic;
	/** 图片描述 **/
	private String imgdesc;

	private String id_country;
	private String id_act;
	/** 农家乐id **/
	private String id_happy;
	/** 是否显示在前台页面上 **/
	private String display;
	/** 是否已经审核 该评论是否已经经过审核 2 表示审核未通过 1 表示经过审核 0 表示未审核 **/
	private String isaudit;
	private String stratype;
	/** 反馈内容 **/
	private String content;
	/** 当前APp版本信息 **/
	private String verinfo;

	/************************************ dds *********************************************/
	/**
	 * 订单状态
	 */
	private String order_status;
	private String id_order;
	private String producttype;
	/**
	 * DDS景区id
	 */
	private String dds_views_id;

	/**
	 * 产品ID
	 */
	private String productid;

	/**
	 * 订单购买数量
	 */
	private Integer productnum = 0;
	/**
	 * 产品价格
	 */
	private Double productprice;

	/**
	 * 支付方式
	 */
	private String apliytype;
	/**
	 * 取票人姓名
	 */
	private String ticketholdername;
	/**
	 * 取票人联系电话
	 */
	private String ticketholderphone;
	/**
	 * 游玩人姓名
	 */
	private String contanctname;
	/**
	 * 游玩人联系电话
	 */

	private String contanctphone;
	/**
	 * 证件类型
	 */
	private String idcardtype;
	/**
	 * 证件号码
	 */
	private String idcardcode;
	/**
	 * 产品使用时间
	 */
	private Date productusetime;

	private int refundnum;
	public String product_time;
	/**
	 * 订单编号
	 */
	private String orderno;
	private Double orderprice = 0.0d;

	private String county;

	public Long getDds_s_id() {
		return dds_s_id;
	}

	public void setDds_s_id(Long dds_s_id) {
		this.dds_s_id = dds_s_id;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public String getSold() {
		return sold;
	}

	public void setSold(String sold) {
		this.sold = sold;
	}

	public String getAccount_no() {
		return account_no;
	}

	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getClicktime() {
		return clicktime;
	}

	public void setClicktime(String clicktime) {
		this.clicktime = clicktime;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getCheckdays() {
		return checkdays;
	}

	public void setCheckdays(String checkdays) {
		this.checkdays = checkdays;
	}

	public int getOrdercount() {
		return ordercount;
	}

	public void setOrdercount(int ordercount) {
		this.ordercount = ordercount;
	}

	public int getChildren_count() {
		return children_count;
	}

	public void setChildren_count(int children_count) {
		this.children_count = children_count;
	}

	public Long getSell_id() {
		return sell_id;
	}

	public void setSell_id(Long sell_id) {
		this.sell_id = sell_id;
	}

	public String getTravelshareid() {
		return travelshareid;
	}

	public void setTravelshareid(String travelshareid) {
		this.travelshareid = travelshareid;
	}

	public String getGrade_low() {
		return grade_low;
	}

	public void setGrade_low(String grade_low) {
		this.grade_low = grade_low;
	}

	public String getNeedpic() {
		return needpic;
	}

	public void setNeedpic(String needpic) {
		this.needpic = needpic;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getIscomment() {
		return iscomment;
	}

	public void setIscomment(String iscomment) {
		this.iscomment = iscomment;
	}

	public String getBatch_id() {
		return batch_id;
	}

	public void setBatch_id(String batch_id) {
		this.batch_id = batch_id;
	}

	public String getCoupon_id() {
		return coupon_id;
	}

	public void setCoupon_id(String coupon_id) {
		this.coupon_id = coupon_id;
	}

	public String getSearchby() {
		return searchby;
	}

	public void setSearchby(String searchby) {
		this.searchby = searchby;
	}

	public String getPro_id() {
		return pro_id;
	}

	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}

	public String getS_id() {
		return s_id;
	}

	public void setS_id(String s_id) {
		this.s_id = s_id;
	}

	public String getPhoneid() {
		return phoneid;
	}

	public void setPhoneid(String phoneid) {
		this.phoneid = phoneid;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSearchtime() {
		return searchtime;
	}

	public void setSearchtime(String searchtime) {
		this.searchtime = searchtime;
	}

	public String getSearchstatus() {
		return searchstatus;
	}

	public void setSearchstatus(String searchstatus) {
		this.searchstatus = searchstatus;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSearchtype() {
		return searchtype;
	}

	public void setSearchtype(String searchtype) {
		this.searchtype = searchtype;
	}

	public String getSearchtheme() {
		return searchtheme;
	}

	public void setSearchtheme(String searchtheme) {
		this.searchtheme = searchtheme;
	}

	public String getSearchplanday() {
		return searchplanday;
	}

	public void setSearchplanday(String searchplanday) {
		this.searchplanday = searchplanday;
	}

	public String[] getSearcharea() {
		return searcharea;
	}

	public void setSearcharea(String[] searcharea) {
		this.searcharea = searcharea;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getPsize() {
		return psize;
	}

	public void setPsize(int psize) {
		this.psize = psize;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getSortd() {
		return sortd;
	}

	public void setSortd(String sortd) {
		this.sortd = sortd;
	}

	public String getId_view() {
		return id_view;
	}

	public void setId_view(String id_view) {
		this.id_view = id_view;
	}

	public float getStar() {
		return star;
	}

	public void setStar(float star) {
		this.star = star;
	}

	public String getId_area() {
		return id_area;
	}

	public void setId_area(String id_area) {
		this.id_area = id_area;
	}

	public Integer getHot() {
		return hot;
	}

	public void setHot(Integer hot) {
		this.hot = hot;
	}

	public Double getMinprice() {
		return minprice;
	}

	public void setMinprice(Double minprice) {
		this.minprice = minprice;
	}

	public Double getMaxprice() {
		return maxprice;
	}

	public void setMaxprice(Double maxprice) {
		this.maxprice = maxprice;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMsgver() {
		return msgver;
	}

	public void setMsgver(String msgver) {
		this.msgver = msgver;
	}

	public String getId_user() {
		return id_user;
	}

	public void setId_user(String id_user) {
		this.id_user = id_user;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsericon() {
		return usericon;
	}

	public void setUsericon(String usericon) {
		this.usericon = usericon;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getId_strategy() {
		return id_strategy;
	}

	public void setId_strategy(String id_strategy) {
		this.id_strategy = id_strategy;
	}

	public String getComm() {
		return comm;
	}

	public void setComm(String comm) {
		this.comm = comm;
	}

	public String getStragedy() {
		return stragedy;
	}

	public void setStragedy(String stragedy) {
		this.stragedy = stragedy;
	}

	public String getStracontent() {
		return stracontent;
	}

	public void setStracontent(String stracontent) {
		this.stracontent = stracontent;
	}

	public String getStratitle() {
		return stratitle;
	}

	public void setStratitle(String stratitle) {
		this.stratitle = stratitle;
	}

	public String getStraicon() {
		return straicon;
	}

	public void setStraicon(String straicon) {
		this.straicon = straicon;
	}

	public String getId_travinfo() {
		return id_travinfo;
	}

	public void setId_travinfo(String id_travinfo) {
		this.id_travinfo = id_travinfo;
	}

	public String getId_comment() {
		return id_comment;
	}

	public void setId_comment(String id_comment) {
		this.id_comment = id_comment;
	}

	public String getCommentcont() {
		return commentcont;
	}

	public void setCommentcont(String commentcont) {
		this.commentcont = commentcont;
	}

	public Double getComlvl() {
		return comlvl;
	}

	public void setComlvl(Double comlvl) {
		this.comlvl = comlvl;
	}

	public String getId_fav() {
		return id_fav;
	}

	public void setId_fav(String id_fav) {
		this.id_fav = id_fav;
	}

	public String getId_view_im() {
		return id_view_im;
	}

	public void setId_view_im(String id_view_im) {
		this.id_view_im = id_view_im;
	}

	public String getId_product() {
		return id_product;
	}

	public void setId_product(String id_product) {
		this.id_product = id_product;
	}

	public String getFavtype() {
		return favtype;
	}

	public void setFavtype(String favtype) {
		this.favtype = favtype;
	}

	public String getFavname() {
		return favname;
	}

	public void setFavname(String favname) {
		this.favname = favname;
	}

	public MultipartFile getPic() {
		return pic;
	}

	public void setPic(MultipartFile pic) {
		this.pic = pic;
	}

	public String getImgdesc() {
		return imgdesc;
	}

	public void setImgdesc(String imgdesc) {
		this.imgdesc = imgdesc;
	}

	public String getId_country() {
		return id_country;
	}

	public void setId_country(String id_country) {
		this.id_country = id_country;
	}

	public String getId_act() {
		return id_act;
	}

	public void setId_act(String id_act) {
		this.id_act = id_act;
	}

	public String getId_happy() {
		return id_happy;
	}

	public void setId_happy(String id_happy) {
		this.id_happy = id_happy;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getIsaudit() {
		return isaudit;
	}

	public void setIsaudit(String isaudit) {
		this.isaudit = isaudit;
	}

	public String getStratype() {
		return stratype;
	}

	public void setStratype(String stratype) {
		this.stratype = stratype;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getVerinfo() {
		return verinfo;
	}

	public void setVerinfo(String verinfo) {
		this.verinfo = verinfo;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public String getId_order() {
		return id_order;
	}

	public void setId_order(String id_order) {
		this.id_order = id_order;
	}

	public String getProducttype() {
		return producttype;
	}

	public void setProducttype(String producttype) {
		this.producttype = producttype;
	}

	public String getDds_views_id() {
		return dds_views_id;
	}

	public void setDds_views_id(String dds_views_id) {
		this.dds_views_id = dds_views_id;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public Integer getProductnum() {
		return productnum;
	}

	public void setProductnum(Integer productnum) {
		this.productnum = productnum;
	}

	public Double getProductprice() {
		return productprice;
	}

	public void setProductprice(Double productprice) {
		this.productprice = productprice;
	}

	public String getApliytype() {
		return apliytype;
	}

	public void setApliytype(String apliytype) {
		this.apliytype = apliytype;
	}

	public String getTicketholdername() {
		return ticketholdername;
	}

	public void setTicketholdername(String ticketholdername) {
		this.ticketholdername = ticketholdername;
	}

	public String getTicketholderphone() {
		return ticketholderphone;
	}

	public void setTicketholderphone(String ticketholderphone) {
		this.ticketholderphone = ticketholderphone;
	}

	public String getContanctname() {
		return contanctname;
	}

	public void setContanctname(String contanctname) {
		this.contanctname = contanctname;
	}

	public String getContanctphone() {
		return contanctphone;
	}

	public void setContanctphone(String contanctphone) {
		this.contanctphone = contanctphone;
	}

	public String getIdcardtype() {
		return idcardtype;
	}

	public void setIdcardtype(String idcardtype) {
		this.idcardtype = idcardtype;
	}

	public String getIdcardcode() {
		return idcardcode;
	}

	public void setIdcardcode(String idcardcode) {
		this.idcardcode = idcardcode;
	}

	public Date getProductusetime() {
		return productusetime;
	}

	public void setProductusetime(Date productusetime) {
		this.productusetime = productusetime;
	}

	public int getRefundnum() {
		return refundnum;
	}

	public void setRefundnum(int refundnum) {
		this.refundnum = refundnum;
	}

	public String getProduct_time() {
		return product_time;
	}

	public void setProduct_time(String product_time) {
		this.product_time = product_time;
	}

	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public Double getOrderprice() {
		return orderprice;
	}

	public void setOrderprice(Double orderprice) {
		this.orderprice = orderprice;
	}

	public String getM_id() {
		return m_id;
	}

	public String getDatatype() {
		return datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getDay_id() {
		return day_id;
	}

	public void setDay_id(String day_id) {
		this.day_id = day_id;
	}

	public String getTsid() {
		return tsid;
	}

	public void setTsid(String tsid) {
		this.tsid = tsid;
	}

	public String getFeatureproid() {
		return featureproid;
	}

	public void setFeatureproid(String featureproid) {
		this.featureproid = featureproid;
	}
	
	public String getPro_type() {
		return pro_type;
	}
	public void setPro_type(String pro_type) {
		this.pro_type = pro_type;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public String getsAreaId() {
		return sAreaId;
	}

	public void setsAreaId(String sAreaId) {
		this.sAreaId = sAreaId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getG_id() {
		return g_id;
	}

	public void setG_id(String g_id) {
		this.g_id = g_id;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public String getTrip_theme() {
		return trip_theme;
	}

	public void setTrip_theme(String trip_theme) {
		this.trip_theme = trip_theme;
	}

	public String getSeatchprice() {
		return seatchprice;
	}

	public void setSeatchprice(String seatchprice) {
		this.seatchprice = seatchprice;
	}
	public String getComment_id() {
		return comment_id;
	}

	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}

	public String getId_county() {
		return id_county;
	}

	public void setId_county(String id_county) {
		this.id_county = id_county;
	}

	public String getIshave() {
		return ishave;
	}

	public void setIshave(String ishave) {
		this.ishave = ishave;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getAppversion() {
		return appversion;
	}

	public void setAppversion(String appversion) {
		this.appversion = appversion;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getTrade_no() {
		return trade_no;
	}

	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	
	
}

package com.sofmit.fits.common.utils;

import java.util.Date;


public class Texting {

	private String sname;//商户名称
	private String proname;//产品名称
	private String usetime;//使用时间
	private String tel;//电话
	private String msv;//验证码
	private String key;
	private String money;//金额
	private String call;//商家电话
	private String proType;//产品类型，(SCENIC:门票,HOTEL：酒店,PRODUCTRRESTAURANT：餐饮,PRODUCTDET：旅行社,PRODUCTSPECIAL：特产,PRODUCTDISPORT：娱乐)
	private String payType;//支付类型，(CASH：现付,PAY：在线支付)
	private String checkType;//审核类型,(UNWANTED：不需要,NEED：需要)
	private String checkResult;//审核结果,(CHECKSUCCCESS:审核通过,CHECKFAIL:审核失败)
	private String payResult;//支付结果,(PAYSUCCESS:支付成功,PAYFAIL:支付失败)
	private String moreMsv;//验证码是否过多
	private String useSuccess;
	private String useNumber;
	
	
	private Long sourceid;//供应商id
	
	public static final String MORE = "MORE";
	
	public static final String USESUCCESS = "USESUCCESS";
	
	//产品类型
	public static final String PROTYPE_1 = "SCENIC";
	public static final String PROTYPE_2 = "HOTEL";
	public static final String PROTYPE_4 = "PRODUCTRRESTAURANT";
	public static final String PROTYPE_5 = "PRODUCTDET";
	public static final String PROTYPE_6 = "PRODUCTSPECIAL";
	public static final String PROTYPE_7 = "PRODUCTDISPORT";
	public static final String PROTYPE_OTHER="OTHER";
	
	
	
	//支付类型
	public static final String PAYTYPE_PAY = "PAY";
	public static final String PAYTYPE_CASH = "CASH";
	
	//审核类型
	public static final String CHECKTYPE_NEED = "NEED";
	public static final String CHECKTYPE_UNWANTED = "UNWANTED";
	
	//审核结果
	public static final String CHECKRESULT_CHECKSUCCCESS = "CHECKSUCCCESS";
	public static final String CHECKRESULT_CHECKFAIL = "CHECKFAIL";
	
	//支付结果
	public static final String PAYRESULT_PAYSUCCESS = "PAYSUCCESS";
	public static final String PAYRESULT_PAYFAIL = "PAYFAIL";
	
	//获取短信模版配置标题
	public String toTitle(){
		System.out.println("短信参数："+this.toString());
		StringBuffer title = new StringBuffer();
		title.append(this.proType);
		if(this.useSuccess != null && !"".equals(this.useSuccess)){
			title.append("_").append(this.useSuccess);
			return title.toString();
		}
		title.append("_").append(this.payType); 
		if(this.PAYTYPE_CASH.equals(this.payType)){
			title.append("_").append(this.checkType);
			if(this.CHECKTYPE_NEED.equals(this.checkType)){
				if(this.checkResult != null && !"".equals(this.checkResult)){
					title.append("_").append(this.checkResult);
				}
			}
			return title.toString();
		} else {
			if(this.payResult != null && !"".equals(this.payResult)){
				title.append("_").append(this.payResult);
				if(this.moreMsv != null && !"".equals(this.moreMsv)){
					title.append("_").append(this.moreMsv);
				}
				return title.toString();
			}
			title.append("_").append(this.checkType);
			if(this.CHECKTYPE_NEED.equals(this.checkType)){
				title.append("_").append(this.checkResult);
				return title.toString();
			} 
			return title.toString();
//			return null;
			
		}
	}
	@Override
	public String toString(){
		StringBuilder st = new StringBuilder();
		st.append("|商户名称:").append(this.sname);
		st.append("|产品名称:").append(this.proname);
		st.append("|电话:").append(this.tel);
		st.append("|验证码:").append(this.msv);
		st.append("|金额:").append(this.money);
		st.append("|商家电话:").append(this.call);
		st.append("|产品类型:").append(this.proType);
		st.append("|支付类型:").append(this.payType);
		st.append("|审核类型:").append(this.checkType);
		st.append("|审核结果:").append(this.checkResult);
		st.append("|支付结果:").append(this.payResult);
		st.append("|是否使用:").append(this.useSuccess);
		return st.toString();
	}
	
	public static void main(String[] args) {
		Texting a = new Texting();
		a.setProType(Texting.PROTYPE_2);
		a.setPayType(Texting.PAYTYPE_PAY);
		a.setCheckType(Texting.CHECKTYPE_NEED);
		a.setCheckResult(Texting.CHECKRESULT_CHECKSUCCCESS);
//		a.setPayResult(Texting.PAYRESULT_PAYSUCCESS);
		
		System.out.println(a.toTitle());
	}
	public Texting() {
	}
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMsv() {
		return msv;
	}
	public void setMsv(String msv) {
		this.msv = msv;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getProType() {
		return proType;
	}

	public void setProType(String proType) {
		this.proType = proType;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getCheckType() {
		return checkType;
	}

	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}

	public String getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}

	public String getPayResult() {
		return payResult;
	}

	public void setPayResult(String payResult) {
		this.payResult = payResult;
	}


	public String getCall() {
		return call;
	}


	public void setCall(String call) {
		this.call = call;
	}
	public String getUseSuccess() {
		return useSuccess;
	}
	public void setUseSuccess(String useSuccess) {
		this.useSuccess = useSuccess;
	}
	public String getUsetime() {
		return usetime;
	}
	public void setUsetime(String usetime) {
		this.usetime = usetime;
	}
	public void setUsetime(Date usetime) {
		this.usetime = usetime == null ? null :DateUtil.format(usetime, DateUtil.SHORT_DATE_PATTERN);
	}
	public Long getSourceid() {
		return sourceid;
	}
	public void setSourceid(Long sourceid) {
		this.sourceid = sourceid;
	}
	public String getUseNumber() {
		return useNumber;
	}
	public void setUseNumber(String useNumber) {
		this.useNumber = useNumber;
	}
	public String getMoreMsv() {
		return moreMsv;
	}
	public void setMoreMsv(String moreMsv) {
		this.moreMsv = moreMsv;
	}
	
}

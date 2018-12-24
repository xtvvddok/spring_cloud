package com.sofmit.fits.common.utils;

import java.util.Date;


public class Texting {

	private String sname;//�̻�����
	private String proname;//��Ʒ����
	private String usetime;//ʹ��ʱ��
	private String tel;//�绰
	private String msv;//��֤��
	private String key;
	private String money;//���
	private String call;//�̼ҵ绰
	private String proType;//��Ʒ���ͣ�(SCENIC:��Ʊ,HOTEL���Ƶ�,PRODUCTRRESTAURANT������,PRODUCTDET��������,PRODUCTSPECIAL���ز�,PRODUCTDISPORT������)
	private String payType;//֧�����ͣ�(CASH���ָ�,PAY������֧��)
	private String checkType;//�������,(UNWANTED������Ҫ,NEED����Ҫ)
	private String checkResult;//��˽��,(CHECKSUCCCESS:���ͨ��,CHECKFAIL:���ʧ��)
	private String payResult;//֧�����,(PAYSUCCESS:֧���ɹ�,PAYFAIL:֧��ʧ��)
	private String moreMsv;//��֤���Ƿ����
	private String useSuccess;
	private String useNumber;
	
	
	private Long sourceid;//��Ӧ��id
	
	public static final String MORE = "MORE";
	
	public static final String USESUCCESS = "USESUCCESS";
	
	//��Ʒ����
	public static final String PROTYPE_1 = "SCENIC";
	public static final String PROTYPE_2 = "HOTEL";
	public static final String PROTYPE_4 = "PRODUCTRRESTAURANT";
	public static final String PROTYPE_5 = "PRODUCTDET";
	public static final String PROTYPE_6 = "PRODUCTSPECIAL";
	public static final String PROTYPE_7 = "PRODUCTDISPORT";
	public static final String PROTYPE_OTHER="OTHER";
	
	
	
	//֧������
	public static final String PAYTYPE_PAY = "PAY";
	public static final String PAYTYPE_CASH = "CASH";
	
	//�������
	public static final String CHECKTYPE_NEED = "NEED";
	public static final String CHECKTYPE_UNWANTED = "UNWANTED";
	
	//��˽��
	public static final String CHECKRESULT_CHECKSUCCCESS = "CHECKSUCCCESS";
	public static final String CHECKRESULT_CHECKFAIL = "CHECKFAIL";
	
	//֧�����
	public static final String PAYRESULT_PAYSUCCESS = "PAYSUCCESS";
	public static final String PAYRESULT_PAYFAIL = "PAYFAIL";
	
	//��ȡ����ģ�����ñ���
	public String toTitle(){
		System.out.println("���Ų�����"+this.toString());
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
		st.append("|�̻�����:").append(this.sname);
		st.append("|��Ʒ����:").append(this.proname);
		st.append("|�绰:").append(this.tel);
		st.append("|��֤��:").append(this.msv);
		st.append("|���:").append(this.money);
		st.append("|�̼ҵ绰:").append(this.call);
		st.append("|��Ʒ����:").append(this.proType);
		st.append("|֧������:").append(this.payType);
		st.append("|�������:").append(this.checkType);
		st.append("|��˽��:").append(this.checkResult);
		st.append("|֧�����:").append(this.payResult);
		st.append("|�Ƿ�ʹ��:").append(this.useSuccess);
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

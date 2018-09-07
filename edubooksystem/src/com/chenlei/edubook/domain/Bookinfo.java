package com.chenlei.edubook.domain;

public class Bookinfo {
	private String bookid;//-- 主键
	private String bookname;//-- 书名
	private float bookprice;//-- 价格
	private float discountprice;//-- 折扣价
	private String bookimg;//-- 图片
	private String bookdetails;//-- 详情
	private float discount;//-- 折扣（0.8就是8折）
	private int state;//-- 审核状态（0，1 没审核过的不能买，在后台审核）
	private String btype;//-- 书籍类型
	private String qixian;//-- 
	private String shihezhuanye;//-- 适合专业
	private String shihenianji;//-- 适合年级
	private String auth;//-- 作者
	private String chubanshe;//-- 出版社
	private String shijian;//-- 出版时间
	private String isbn;//-- ISBN号
	private int grade; // --年级
	private int jifen;//-- 购买后可得多少积分
	private Assorter assorter;//-- 上传书籍商家名字（后台assorter_right表主键）
	private String sendBookTime;//-- 上传时间
	private String homeImage;//-- 显示的大图片（在书籍详细页面上鼠标放上去时显示的图片）
	private int duihuan;// -- 是不是可兑换的商品（是，不是）
	private int free_shipping_num;  // --免运费的最低购买量
	private float freight;		// --基础运费
	
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public float getBookprice() {
		return bookprice;
	}
	public void setBookprice(float bookprice) {
		this.bookprice = bookprice;
	}
	public float getDiscountprice() {
		return discountprice;
	}
	public void setDiscountprice(float discountprice) {
		this.discountprice = discountprice;
	}
	public String getBookimg() {
		return bookimg;
	}
	public void setBookimg(String bookimg) {
		this.bookimg = bookimg;
	}
	public String getBookdetails() {
		return bookdetails;
	}
	public void setBookdetails(String bookdetails) {
		this.bookdetails = bookdetails;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getBtype() {
		return btype;
	}
	public void setBtype(String btype) {
		this.btype = btype;
	}
	public String getQixian() {
		return qixian;
	}
	public void setQixian(String qixian) {
		this.qixian = qixian;
	}
	public String getShihezhuanye() {
		return shihezhuanye;
	}
	public void setShihezhuanye(String shihezhuanye) {
		this.shihezhuanye = shihezhuanye;
	}
	public String getShihenianji() {
		return shihenianji;
	}
	public void setShihenianji(String shihenianji) {
		this.shihenianji = shihenianji;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getChubanshe() {
		return chubanshe;
	}
	public void setChubanshe(String chubanshe) {
		this.chubanshe = chubanshe;
	}
	public String getShijian() {
		return shijian;
	}
	public void setShijian(String shijian) {
		this.shijian = shijian;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getJifen() {
		return jifen;
	}
	public void setJifen(int jifen) {
		this.jifen = jifen;
	}
	public Assorter getAssorter() {
		return assorter;
	}
	public void setAssorter(Assorter assorter) {
		this.assorter = assorter;
	}
	public String getSendBookTime() {
		return sendBookTime;
	}
	public void setSendBookTime(String sendBookTime) {
		this.sendBookTime = sendBookTime;
	}
	public String getHomeImage() {
		return homeImage;
	}
	public void setHomeImage(String homeImage) {
		this.homeImage = homeImage;
	}
	public int getDuihuan() {
		return duihuan;
	}
	public void setDuihuan(int duihuan) {
		this.duihuan = duihuan;
	}
	public int getFree_shipping_num() {
		return free_shipping_num;
	}
	public void setFree_shipping_num(int free_shipping_num) {
		this.free_shipping_num = free_shipping_num;
	}
	public float getFreight() {
		return freight;
	}
	public void setFreight(float freight) {
		this.freight = freight;
	}
	
	
}

package com.bx.card.common.util.qrcode;

public class MatrixToBgImageConfig {
	public MatrixToBgImageConfig(int qrcode_height, int qrcode_x, int qrcode_y) {
		this();
		this.qrcode_height = qrcode_height;
		this.qrcode_x = qrcode_x;
		this.qrcode_y = qrcode_y;
	}

	public MatrixToBgImageConfig() {
	}

	// logo默认边框颜色
	public static final String DEFAULT_HEADIMGURL = "head.png";

	private int qrcode_height = 200;// 二维码的高度
	private int qrcode_x = 776;// 二维码的X
	private int qrcode_y = 30;// 二维码的y

	private String headimgUrl;// 头像
	private int headimg_height = 170;// 头像的高度
	private int headimg_x = 126;// 头像的X
	private int headimg_y = 254;// 头像的y

	private String bgFile = "bg.jpg";// 背景图片
	private String qrcode_url; // 二维码url
	private String realname;// 用户名
	private int realname_x = 365;// 名字的x
	private int realname_y = 318;// 名字的y


	private String phone;
	private int phone_x = 420;
	private int phone_y = 451;

	private String job;
	private int job_x = 365;
	private int job_y = 380;

	private String add;
	private int add_x = 420;
	private int add_y = 422;

	private String tel;
	private int tel_x = 420;
	private int tel_y = 479;

	private String fax;
	private int fax_x = 640;
	private int fax_y = 450;

	private String org;

	public int getQrcode_height() {
		return qrcode_height;
	}

	public void setQrcode_height(int qrcode_height) {
		this.qrcode_height = qrcode_height;
	}

	public int getQrcode_x() {
		return qrcode_x;
	}

	public void setQrcode_x(int qrcode_x) {
		this.qrcode_x = qrcode_x;
	}

	public int getQrcode_y() {
		return qrcode_y;
	}

	public void setQrcode_y(int qrcode_y) {
		this.qrcode_y = qrcode_y;
	}

	public String getBgFile() {
		return bgFile;
	}

	public void setBgFile(String bgFile) {
		this.bgFile = bgFile;
	}

	public String getQrcode_url() {
		return qrcode_url;
	}

	public void setQrcode_url(String qrcode_url) {
		this.qrcode_url = qrcode_url;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getHeadimgUrl() {
		return headimgUrl;
	}

	public void setHeadimgUrl(String headimgUrl) {
		this.headimgUrl = headimgUrl;
	}

	public int getHeadimg_height() {
		return headimg_height;
	}

	public void setHeadimg_height(int headimg_height) {
		this.headimg_height = headimg_height;
	}

	public int getHeadimg_x() {
		return headimg_x;
	}

	public void setHeadimg_x(int headimg_x) {
		this.headimg_x = headimg_x;
	}

	public int getHeadimg_y() {
		return headimg_y;
	}

	public void setHeadimg_y(int headimg_y) {
		this.headimg_y = headimg_y;
	}

	public int getRealname_x() {
		return realname_x;
	}

	public void setRealname_x(int realname_x) {
		this.realname_x = realname_x;
	}

	public int getRealname_y() {
		return realname_y;
	}

	public void setRealname_y(int realname_y) {
		this.realname_y = realname_y;
	}

	public String getPhone() {
		return phone;
	}

	public int getPhone_x() {
		return phone_x;
	}

	public int getPhone_y() {
		return phone_y;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPhone_x(int phone_x) {
		this.phone_x = phone_x;
	}

	public void setPhone_y(int phone_y) {
		this.phone_y = phone_y;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getJob_x() {
		return job_x;
	}

	public int getJob_y() {
		return job_y;
	}

	public void setJob_x(int job_x) {
		this.job_x = job_x;
	}

	public void setJob_y(int job_y) {
		this.job_y = job_y;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public int getAdd_x() {
		return add_x;
	}

	public void setAdd_x(int add_x) {
		this.add_x = add_x;
	}

	public int getAdd_y() {
		return add_y;
	}

	public void setAdd_y(int add_y) {
		this.add_y = add_y;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getTel_x() {
		return tel_x;
	}

	public void setTel_x(int tel_x) {
		this.tel_x = tel_x;
	}

	public int getTel_y() {
		return tel_y;
	}

	public void setTel_y(int tel_y) {
		this.tel_y = tel_y;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public int getFax_x() {
		return fax_x;
	}

	public void setFax_x(int fax_x) {
		this.fax_x = fax_x;
	}

	public int getFax_y() {
		return fax_y;
	}

	public void setFax_y(int fax_y) {
		this.fax_y = fax_y;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}
}

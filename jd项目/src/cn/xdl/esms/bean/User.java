package cn.xdl.esms.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class User implements Serializable{

	/**
	 * user_id         主键
	 */
	private int user_id;
	/**
	 * login_name      登录名
	 */
	private String login_name;
	/**
	 *nick_name       昵称
	 */
	private String nick_name;
	/**
	 * real_name	         真实名
	 */
	private String real_name;
	/**
	 * grade_id        会员等级ID
	 */
	private int grade_id;
	/**
	 * password 	        密码
	 */
	private String password;
	/**
	 * email		       邮箱地址
	 */
	private String email;
	/**
	 * province        省份
	 */
	private String province;
	/**
	 * recommender     推荐人
	 */
	private String recommender;
	/**
	 * sex    			性别
	 */
	private String sex;
	/**
	 * birth           生日
	 */
	private Timestamp birth;
	/**
	 * location        所属地
	 */
	private String location;
	/**
	 * school          学校信息
	 */
	private String school;
	/**
	 * company         公司信息
	 */
	private String company;
	/**
	 * card_number     身份证号码
	 */
	private String card_number;
	/**
	 * mobile			电话
	 */
	private String mobile;
	/**
	 * phone 			手机号
	 */
	private String phone;
	/**
	 * msn				MSN
	 */
	private String msn;
	/**
	 * qq 				QQ
	 */
	private String qq;
	/**
	 * website			个人网站
	 */
	private String website;
	/**
	 * send_address     发货地址
	 */
	private String send_address;
	/**
	 * zipcode          邮编
	 */
	private String zipcode;
	/**
	 * hobby			兴趣爱好
	 */
	private String hobby;
	/**
	 * verify_flag		Email是否通过
	 */
	private String verify_flag;
	/**
	 * verify_code		Email验证码
	 */
	private String verify_code;
	/**
	 * last_login_time   最后一次登录时间
	 */
	private Timestamp last_login_time;
	/**
	 * last_login_ip    最后一次登录IP
	 */
	private String last_login_ip;
	/**
	 * area 			区
	 */
	private String area;
	/**
	 * head_pic        头像图片
	 */
	private String head_pic;

	public User() {
		super();
	}


	public User(int user_id, String login_name, String password, String email, String recommender) {
		super();
		this.user_id = user_id;
		this.login_name = login_name;
		this.password = password;
		this.email = email;
		this.recommender = recommender;
	}


	public User(String login_name, String password, String email, String recommender) {
		super();
		this.login_name = login_name;
		this.password = password;
		this.email = email;
		this.recommender = recommender;
	}



	public User(int user_id, String login_name, String nick_name, String real_name, int grade_id, String password,
				String email, String province, String recommender, String sex, Timestamp birth, String location,
				String school, String company, String card_number, String mobile, String phone, String msn, String qq,
				String website, String send_address, String zipcode, String hobby, String verify_flag, String verify_code,
				Timestamp last_login_time, String last_login_ip, String area, String head_pic) {
		super();
		this.user_id = user_id;
		this.login_name = login_name;
		this.nick_name = nick_name;
		this.real_name = real_name;
		this.grade_id = grade_id;
		this.password = password;
		this.email = email;
		this.province = province;
		this.recommender = recommender;
		this.sex = sex;
		this.birth = birth;
		this.location = location;
		this.school = school;
		this.company = company;
		this.card_number = card_number;
		this.mobile = mobile;
		this.phone = phone;
		this.msn = msn;
		this.qq = qq;
		this.website = website;
		this.send_address = send_address;
		this.zipcode = zipcode;
		this.hobby = hobby;
		this.verify_flag = verify_flag;
		this.verify_code = verify_code;
		this.last_login_time = last_login_time;
		this.last_login_ip = last_login_ip;
		this.area = area;
		this.head_pic = head_pic;
	}


	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getLogin_name() {
		return login_name;
	}

	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public String getReal_name() {
		return real_name;
	}

	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}

	public int getGrade_id() {
		return grade_id;
	}

	public void setGrade_id(int grade_id) {
		this.grade_id = grade_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getRecommender() {
		return recommender;
	}

	public void setRecommender(String recommender) {
		this.recommender = recommender;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Timestamp getBirth() {
		return birth;
	}

	public void setBirth(Timestamp birth) {
		this.birth = birth;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCard_number() {
		return card_number;
	}

	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMsn() {
		return msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getSend_address() {
		return send_address;
	}

	public void setSend_address(String send_address) {
		this.send_address = send_address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getVerify_flag() {
		return verify_flag;
	}

	public void setVerify_flag(String verify_flag) {
		this.verify_flag = verify_flag;
	}

	public String getVerify_code() {
		return verify_code;
	}

	public void setVerify_code(String verify_code) {
		this.verify_code = verify_code;
	}

	public Timestamp getLast_login_time() {
		return last_login_time;
	}

	public void setLast_login_time(Timestamp last_login_time) {
		this.last_login_time = last_login_time;
	}

	public String getLast_login_ip() {
		return last_login_ip;
	}

	public void setLast_login_ip(String last_login_ip) {
		this.last_login_ip = last_login_ip;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getHead_pic() {
		return head_pic;
	}

	public void setHead_pic(String head_pic) {
		this.head_pic = head_pic;
	}


}

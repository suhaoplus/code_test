package cn.xdl.esms.bean;

public class Address {

	/**
	 * 主键，编号
	 */
	private int reveive_address_id;
	/**
	 * 用户ID
	 */
	private int user_id;
	/**
	 * 收件人姓名
	 */
	private String receive_name;
	/**
	 * 省份
	 */
	private String province;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 邮编
	 */
	private String zipcode;
	/**
	 * 联系电话
	 */
	private String mobile;
	/**
	 * 手机
	 */
	private String telephone;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 区
	 */
	private String area;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(int reveive_address_id, int user_id, String receive_name, String province, String address,
				   String zipcode, String mobile, String telephone, String email, String area) {
		super();
		this.reveive_address_id = reveive_address_id;
		this.user_id = user_id;
		this.receive_name = receive_name;
		this.province = province;
		this.address = address;
		this.zipcode = zipcode;
		this.mobile = mobile;
		this.telephone = telephone;
		this.email = email;
		this.area = area;
	}


	public Address(String receive_name, String province, String address, String zipcode, String mobile,
				   String telephone, String email, String area) {
		super();
		this.receive_name = receive_name;
		this.province = province;
		this.address = address;
		this.zipcode = zipcode;
		this.mobile = mobile;
		this.telephone = telephone;
		this.email = email;
		this.area = area;
	}
	public int getReveive_address_id() {
		return reveive_address_id;
	}
	public void setReveive_address_id(int reveive_address_id) {
		this.reveive_address_id = reveive_address_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getReceive_name() {
		return receive_name;
	}
	public void setReceive_name(String receive_name) {
		this.receive_name = receive_name;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	@Override
	public String toString() {
		return "Address [reveive_address_id=" + reveive_address_id + ", user_id=" + user_id + ", receive_name="
				+ receive_name + ", province=" + province + ", address=" + address + ", zipcode=" + zipcode
				+ ", mobile=" + mobile + ", telephone=" + telephone + ", email=" + email + ", area=" + area + "]";
	}


}

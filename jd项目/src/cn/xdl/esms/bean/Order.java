package cn.xdl.esms.bean;

import java.sql.Timestamp;

public class Order {

	private int order_id;//主键
	private int user_id;//用户ID
	private String status;//订单状态
	private Timestamp order_time;//创建订单时间
	private int total_price;//订单总价
	private int payment_id;//支付和配送方式
	private int invoice_id;//发票信息
	private int reveive_address_id;//收货人信息
	private String bak;//订单备注
	public Order() {
	}
	public Order(int order_id, int user_id, String status, Timestamp order_time, int total_price, int payment_id,
				 int invoice_id, int reveive_address_id, String bak) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.status = status;
		this.order_time = order_time;
		this.total_price = total_price;
		this.payment_id = payment_id;
		this.invoice_id = invoice_id;
		this.reveive_address_id = reveive_address_id;
		this.bak = bak;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Timestamp order_time) {
		this.order_time = order_time;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public int getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}
	public int getReveive_address_id() {
		return reveive_address_id;
	}
	public void setReveive_address_id(int reveive_address_id) {
		this.reveive_address_id = reveive_address_id;
	}
	public String getBak() {
		return bak;
	}
	public void setBak(String bak) {
		this.bak = bak;
	}
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", user_id=" + user_id + ", status=" + status + ", order_time="
				+ order_time + ", total_price=" + total_price + ", payment_id=" + payment_id + ", invoice_id="
				+ invoice_id + ", reveive_address_id=" + reveive_address_id + ", bak=" + bak + "]";
	}






}

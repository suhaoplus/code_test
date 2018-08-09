package cn.xdl.esms.bean;

public class Invoice {

	private int invoice_id;//主键
	private String types;//发票类型
	private String title;//发票抬头个人/公司
	private String content;//发票内容
	private String company;//公司名
	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Invoice(int invoice_id, String types, String title, String content, String company) {
		super();
		this.invoice_id = invoice_id;
		this.types = types;
		this.title = title;
		this.content = content;
		this.company = company;
	}
	public Invoice(String types, String title, String content, String company) {
		super();
		this.types = types;
		this.title = title;
		this.content = content;
		this.company = company;
	}
	public int getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}
	public String getTypes() {
		return types;
	}
	public void setTypes(String types) {
		this.types = types;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Invoice [invoice_id=" + invoice_id + ", types=" + types + ", title=" + title + ", content=" + content
				+ ", company=" + company + "]";
	}


}

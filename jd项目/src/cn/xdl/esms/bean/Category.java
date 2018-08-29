package cn.xdl.esms.bean;

public class Category {

	/**
	 * 编号
	 */
	private int category_id;
	/**
	 * 类别名
	 */
	private String name;
	/**
	 * 用来控制显示的顺序
	 */
	private int turn;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 为了找到这个分类下的子分类 实现无限级分类
	 */
	private int parent_id;

	public Category() {
		super();
	}

	public Category(int category_id, String name, int turn, String description, int parent_id) {
		super();
		this.category_id = category_id;
		this.name = name;
		this.turn = turn;
		this.description = description;
		this.parent_id = parent_id;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTurn() {
		return turn;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	@Override
	public String toString() {
		return "Category [category_id=" + category_id + ", name=" + name + ", turn=" + turn + ", description="
				+ description + ", parent_id=" + parent_id + "]";
	}


}

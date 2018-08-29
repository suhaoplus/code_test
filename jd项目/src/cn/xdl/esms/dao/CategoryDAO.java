package cn.xdl.esms.dao;

import java.util.List;

import cn.xdl.esms.bean.Category;

public interface CategoryDAO {

	List<Category> getCategoryListByParentId(int parent_id);
}

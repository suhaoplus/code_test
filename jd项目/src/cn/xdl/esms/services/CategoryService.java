package cn.xdl.esms.services;

import java.util.List;

import cn.xdl.esms.bean.Category;
import cn.xdl.esms.dao.CategoryDAO;
import cn.xdl.factroy.CategoryDAOFactory;

public class CategoryService {

	private CategoryDAO categoryDao;
	public CategoryService() {
		categoryDao=new CategoryDAOFactory().getCategoryDAO();
	}
	
	public List<Category> subCategories(int parent_id){
		return categoryDao.getCategoryListByParentId(parent_id);
	}
}

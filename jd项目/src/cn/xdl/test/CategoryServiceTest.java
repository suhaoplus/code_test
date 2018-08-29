package cn.xdl.test;

import java.util.List;

import cn.xdl.esms.bean.Category;
import cn.xdl.esms.services.CategoryService;

public class CategoryServiceTest {

	public static void main(String[] args) {
		CategoryService cs = new CategoryService();
		List<Category> list = cs.subCategories(0);
		System.out.println(list);
	}

}

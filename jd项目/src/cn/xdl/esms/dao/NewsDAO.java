package cn.xdl.esms.dao;

import java.util.List;

import cn.xdl.esms.bean.News;

public interface NewsDAO {

	/**
	 * 查询资讯，按照发布时间降序取前n条数据
	 * @return  资讯对象集合
	 */
	List<News> getNews(int number);
}

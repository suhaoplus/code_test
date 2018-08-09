package cn.xdl.esms.services;

import java.util.List;

import cn.xdl.esms.bean.News;
import cn.xdl.esms.dao.NewsDAO;
import cn.xdl.factroy.NewsDAOFactory;

public class NewsService {

	private NewsDAO newsDao ;

	public NewsService() {
		newsDao = new NewsDAOFactory().getNewsDAO();
	}
	
	public List<News> subNews(int number){
		return newsDao.getNews(number);
	}
	
	
}

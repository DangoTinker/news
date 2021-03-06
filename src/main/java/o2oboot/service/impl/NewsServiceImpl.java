package o2oboot.service.impl;

import o2oboot.dao.NewsDao;
import o2oboot.dto.NewsExecution;
import o2oboot.entity.News;
import o2oboot.entity.NewsCategory;
import o2oboot.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsDao newsDao;

    @Override
    public int deleteNews(Long newsId) {
        return newsDao.deleteNews(newsId);
    }

    @Override
    public int addNews(News news) {
        news.setCreateTime(new Date());
        return newsDao.insertNews(news);

    }

    @Override
    public News getNewsById(Long newsId) {
        System.out.println(newsDao.queryNewsById((long) 1));
        return newsDao.queryNewsById(newsId);
    }

    @Override
    public NewsExecution getNewsList(News newsCondition, int rowIndex, int pageSize) {
         NewsExecution newsExecution=new NewsExecution();
         List<News> list=newsDao.queryNewsList(newsCondition,rowIndex,pageSize);
//         int count=newsDao.queryNewsCount(newsCondition);
         if(list!=null) {
             newsExecution.setNewsList(list);
             newsExecution.setCount(list.size());
             newsExecution.setState(1);
             newsExecution.setStateInfo("success");
         }else{
             newsExecution.setState(0);
             newsExecution.setStateInfo("fail");
         }
         return newsExecution;
    }

    @Override
    public NewsExecution modifyNews(News newsCondition) {
        int n=newsDao.updateNews(newsCondition);
        NewsExecution newsExecution=new NewsExecution();
        if(n<1){
            newsExecution.setState(0);
            newsExecution.setStateInfo("fail");
        }else{
            newsExecution.setState(1);
            newsExecution.setStateInfo("success");
        }
        return newsExecution;
    }

    @Override
    public NewsExecution getNewsListByNewsCategory(Long newsCategoryId, int rowIndex, int pageSize) {
        NewsExecution newsExecution=new NewsExecution();
        List<News> list = newsDao.queryNewsListByNewsCategoryId(newsCategoryId,rowIndex,pageSize);
        if(list!=null) {
            newsExecution.setNewsList(list);
            newsExecution.setCount(list.size());
            newsExecution.setState(1);
            newsExecution.setStateInfo("success");
        }else{
            newsExecution.setState(0);
            newsExecution.setStateInfo("fail");
        }
        return newsExecution;
    }

    @Override
    public NewsExecution getAllNewsList(int rowIndex, int pageSize) {
        NewsExecution newsExecution=new NewsExecution();
        List<News> list = newsDao.queryAllNews(rowIndex,pageSize);
        if(list!=null) {
            newsExecution.setNewsList(list);
            newsExecution.setCount(list.size());
            newsExecution.setState(1);
            newsExecution.setStateInfo("success");
        }else{
            newsExecution.setState(0);
            newsExecution.setStateInfo("fail");
        }
        return newsExecution;
    }

    @Override
    public NewsExecution getNewsListByName(String newsName, int rowIndex, int pageSize) {
        NewsExecution newsExecution=new NewsExecution();
        List<News> list = newsDao.queryNewsListByNewsName(newsName,rowIndex,pageSize);
        if(list!=null) {
            newsExecution.setNewsList(list);
            newsExecution.setCount(list.size());
            newsExecution.setState(1);
            newsExecution.setStateInfo("success");
        }else{
            newsExecution.setState(0);
            newsExecution.setStateInfo("fail");
        }
        return newsExecution;
    }

}

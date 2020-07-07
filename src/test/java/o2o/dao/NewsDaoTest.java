package o2o.dao;

import o2o.BaseTest;
import o2oboot.dao.NewsDao;
import o2oboot.entity.News;
import o2oboot.entity.NewsCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class NewsDaoTest extends BaseTest {

    @Autowired
    private NewsDao newsDao;

    @Test
    public void insertNewsTest(){
        NewsCategory newsCategory=new NewsCategory();
        newsCategory.setNewsCategoryId((long)1);
        newsDao.insertNews(new News((long)1,"1",newsCategory,1,1,new Date()));

    }
    @Test
    public void deleteNewsTest(){
        newsDao.deleteNews((long)1);
    }
    @Test
    public void queryNewsTest(){
        News newsCondition=new News();
        NewsCategory newsCategory=new NewsCategory();
        newsCategory.setNewsCategoryId((long)1);
        newsCondition.setNewsCategory(newsCategory);
        List<News> list=newsDao.queryNewsList(newsCondition,0,2);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getNewsId());
        }
    }

}

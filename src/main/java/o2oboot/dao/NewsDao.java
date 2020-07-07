package o2oboot.dao;

import o2oboot.entity.News;
import o2oboot.entity.NewsCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper

public interface NewsDao {
    int insertNews(News news);
    News queryNewsById(Long newsId);
    List<News> queryNewsList(News newsCondition,int rowIndex,int pageSize);
    int queryNewsCount(News newsCondition);
    int updateNews(News newsCondition);
    List<News> queryAllNews(int rowIndex, int pageSize);
    int deleteNews(Long newsId);
    List<News> queryNewsListByNewsCategoryId(Long newsCategoryId, int rowIndex, int pageSize);
    List<News> queryNewsListByNewsName(String newsName, int rowIndex, int pageSize);
}

package o2oboot.dao;

import o2oboot.entity.NewsCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper

public interface NewsCategoryDao {
    int insertNewsCategory(NewsCategory newsCategory);
    int deleteNewsCategory(Long newsCategoryId);
    List<NewsCategory> queryNewsCategoryByParent(NewsCategory newsCategory);
}

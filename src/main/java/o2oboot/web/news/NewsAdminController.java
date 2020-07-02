package o2oboot.web.news;

import com.fasterxml.jackson.databind.ObjectMapper;
import o2oboot.dto.NewsExecution;
import o2oboot.entity.News;
import o2oboot.entity.NewsCategory;
import o2oboot.service.NewsService;
import o2oboot.service.NewsCategoryService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/news")
public class NewsAdminController {

    @Autowired
    private NewsCategoryService newsCategoryService;
    @Autowired
    private NewsService newsService;

    //根据“名称类型”搜索
    @RequestMapping(value="/newsList",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getNewsList(@Param("pageIndex")int pageIndex, @Param("pageSize") int pageSize, HttpServletRequest request){
        String newsCategoryId=request.getParameter("newsCategoryId");
        String newsName=request.getParameter("newsName");
        News news=new News();
        news.setNewsName(newsName);
        Long id=null;
        if(newsCategoryId!=null){
            id=Long.valueOf(newsCategoryId);
        }
        NewsCategory newsCategory=new NewsCategory();
        newsCategory.setNewsCategoryId(id);
        news.setNewsCategory(newsCategory);

        NewsExecution newsExecution =newsService.getNewsList(news,(pageIndex > 0) ? (pageIndex-1)*pageSize : 0,pageSize);
        Map<String,Object> map=new HashMap<>();

        if(newsExecution.getState()==1){
            map.put("success",true);
            map.put("newsList",newsExecution.getNewsList());
            map.put("count",newsExecution.getCount());
        }else{
            map.put("success",false);
            map.put("errMsg",newsExecution.getStateInfo());
        }
        return map;
    }

    @RequestMapping(value="/addNews",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addNews(@RequestParam("newsStr")String newsStr,HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        newsStr=newsStr.trim();
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            News news=objectMapper.readValue(newsStr,News.class);
            newsService.addNews(news);
        } catch (IOException e) {
            e.printStackTrace();
//            System.out.println("错");
            map.put("success",false);
            map.put("errMsg",e.getMessage());
            return map;
        }

        map.put("success",true);
        return map;
    }

    @RequestMapping(value="/deleteNews",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> deleteNews(HttpServletRequest request){
        Long newsId= Long.valueOf(request.getParameter("newsId"));
        Map<String,Object> map=new HashMap<>();
        int s=newsService.deleteNews(newsId);
        if(s<1){
            map.put("success",false);
        }else {
            map.put("success",true);
        }
        return map;
    }

    @RequestMapping(value="/modifyNews",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> modifyNews(@RequestParam("newsStr")String newsStr,HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        newsStr=newsStr.trim();
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            News news=objectMapper.readValue(newsStr,News.class);
            NewsExecution newsExecution=newsService.modifyNews(news);
            if(newsExecution.getState()==1){
                map.put("success",true);
            }else{
                map.put("success",false);
                map.put("errMsg",newsExecution.getStateInfo());
            }
            return map;
        } catch (IOException e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("errMsg",e.getMessage());
            return map;
        }
    }

    @RequestMapping(value="/getNewsById",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getNewsById(HttpServletRequest request){
        Long newsId= Long.valueOf(request.getParameter("newsId"));
        Map<String,Object> map=new HashMap<>();
        News news=newsService.getNewsById(newsId);
        if(news!=null) {
            List<News> list = new ArrayList<>();
            list.add(news);
            map.put("success",true);
            map.put("news",list);
        }else{
            map.put("success",false);
        }
        return map;
    }
}

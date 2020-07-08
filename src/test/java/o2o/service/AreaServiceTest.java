package o2o.service;

import o2o.BaseTest;
import o2oboot.service.NewsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AreaServiceTest extends BaseTest {

//    @Autowired
//    private AreaService areaService;
//
//    @Test
//    public void getAreaListTest(){
//        assertEquals(3,areaService.getAreaList().size());
//
//    }
    @Autowired
    private NewsService newsService;
    @Test
    public void a(){
        System.out.println(newsService.getNewsById((long) 1));
    }
}

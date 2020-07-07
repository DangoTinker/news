package o2oboot.web.access;

import com.fasterxml.jackson.databind.ObjectMapper;
import o2oboot.entity.Access;
import o2oboot.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ac")
public class AccessController {

    @Autowired
    private AccessService accessService;


    @RequestMapping("/addAccess")
    @ResponseBody
    public Map<String, Object> addAccess(@RequestParam("accessStr") String accessStr, HttpServletRequest request) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<>();

        try {
            Access access = objectMapper.readValue(accessStr, Access.class);
            int res = accessService.addAccess(access);
            if (res < 1) {
                map.put("success", false);
            } else {
                map.put("success", true);
            }

        } catch (Exception e) {
            map.put("success", false);
        }
        return map;
    }

    @RequestMapping("/accessList")
    @ResponseBody
    public Map<String,Object> accessList(){
        Map<String,Object> map=new HashMap<>();
        List<Access> list=new LinkedList<>();

        list=accessService.queryAllAccess();
        if(list.size()!=0){
            map.put("success",true);
            map.put("accessList",list);
        }else{
            map.put("success",false);
        }
        return map;


    }

    @RequestMapping("/deleteAccess")
    @ResponseBody
    public Map<String,Object> deleteAccess(HttpServletRequest request){
        Long newsId= Long.valueOf(request.getParameter("accessId"));
        Map<String,Object> map=new HashMap<>();
        int s=accessService.deleteAccess(newsId);
        if(s<1){
            map.put("success",false);
        }else {
            map.put("success",true);
        }
        return map;
    }




}
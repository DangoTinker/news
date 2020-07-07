package o2oboot.web.access;
import com.fasterxml.jackson.databind.ObjectMapper;
import o2oboot.entity.Access;
import o2oboot.entity.Role;
import o2oboot.service.AccessRoleMapService;
import o2oboot.service.RoleService;
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
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private AccessRoleMapService accessRoleMapService;


    @RequestMapping("/addRole")
    @ResponseBody
    public Map<String, Object> addRole(@RequestParam("roleStr") String roleStr, HttpServletRequest request) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<>();

        try {
            Role role = objectMapper.readValue(roleStr, Role.class);
            int res = roleService.addRole(role);
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

    @RequestMapping("/roleList")
    @ResponseBody
    public Map<String,Object> roleList(){
        Map<String,Object> map=new HashMap<>();
        List<Role> list=new LinkedList<>();

        list=roleService.queryAllRole();
        if(list.size()!=0){
            map.put("success",true);
            map.put("roleList",list);
        }else{
            map.put("success",false);
        }
        return map;


    }

    @RequestMapping("/deleteRole")
    @ResponseBody
    public Map<String,Object> deleteRole(HttpServletRequest request){
        Long newsId= Long.valueOf(request.getParameter("roleId"));
        Map<String,Object> map=new HashMap<>();
        int s=roleService.deleteRole(newsId);
        if(s<1){
            map.put("success",false);
        }else {
            map.put("success",true);
        }
        return map;
    }


    @RequestMapping("/addAccessToRole")
    @ResponseBody
    public Map<String,Object> addAccessToRole(HttpServletRequest request){
        Long roleId= Long.valueOf(request.getParameter("roleId"));
        Long accessId= Long.valueOf(request.getParameter("accessId"));
        Access access=new Access();
        access.setAccessId(accessId);
        Role role=new Role();
        role.setRoleId(roleId);
        Map<String,Object> map=new HashMap<>();
        int n=accessRoleMapService.addAccessRoleMap(access,role);

        if(n<1){
            map.put("success",false);
        }else{
            map.put("success",true);
        }

        return map;
    }


}
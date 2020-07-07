package o2oboot.web.user;

import o2oboot.entity.User;
import o2oboot.entity.Role;
import o2oboot.service.RoleUserMapService;
import o2oboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleUserMapService roleUserMapService;

    @RequestMapping(value = "/checkusername",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> checkusername (HttpServletRequest request){
        String userId=request.getParameter("userId");

        int s = userService.checkUserId(userId);
        Map<String,Object> map = new HashMap<>();
        if(s<1){
            map.put("success",false);
        }else{
            map.put("success",true);
        }
        return map;
    }
    //注册
    @RequestMapping(value = "/userSignUp",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> userSignUp (HttpServletRequest request){
        String username=request.getParameter("username");
        String userName=request.getParameter("username");
        String password=request.getParameter("password");
        String gender=request.getParameter("gender");

        User user=new User(Long.valueOf(username),userName,password,gender);
        int s=userService.addUser(user);
        Map<String,Object> map = new HashMap<>();
        if(s<1){
            map.put("success",false);
        }else{
            map.put("success",true);
        }
        return map;
    }
    //登陆
    @RequestMapping(value = "/userSignIn",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> userSignIn (HttpServletRequest request){
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        request.getSession().setAttribute("currentUser",username);
        int s=userService.checkUserSingIn(username,password);
        Map<String,Object> map = new HashMap<>();
        if(s<1){
            map.put("success",false);
        }else{
            map.put("success",true);
        }
        return map;
    }

    @RequestMapping(value = "/userDetail",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> userDetail (HttpServletRequest request){
        String username=request.getParameter("username");

        User user=userService.getUserDetail(username);
        List<User> list = new ArrayList<>();
        list.add(user);
        Map<String,Object> map = new HashMap<>();
        map.put("userDetail",list);
        return map;
    }

    @RequestMapping(value = "/modifyUser",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> modifyUser (HttpServletRequest request){
        String username=request.getParameter("username");
        String userName=request.getParameter("username");
        String password=request.getParameter("password");
        String gender=request.getParameter("gender");
        User user=new User(Long.valueOf(username),userName,password,gender);


        int s=userService.modifyUser(user);
        Map<String,Object> map = new HashMap<>();
        if(s<1){
            map.put("success",false);
        }else{
            map.put("success",true);
        }
        return map;
    }
    //添加角色
    @RequestMapping("/addRoleToUser")
    @ResponseBody
    public Map<String,Object> addRoleToUser(HttpServletRequest request){
        Long roleId= Long.valueOf(request.getParameter("roleId"));
        Long userId= Long.valueOf(request.getParameter("userId"));
        Role role=new Role();
        role.setRoleId(roleId);
        User user=new User();
        user.setUserId(userId);
        Map<String,Object> map=new HashMap<>();
        int n=roleUserMapService.addRoleUserMap(role,user);

        if(n<1){
            map.put("success",false);
        }else{
            map.put("success",true);
        }

        return map;
    }


}

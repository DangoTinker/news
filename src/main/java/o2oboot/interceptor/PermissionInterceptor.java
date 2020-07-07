package o2oboot.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import o2oboot.dao.AccessDao;
import o2oboot.dao.RoleDao;
import o2oboot.dao.RoleUserMapDao;
import o2oboot.dao.UserDao;
import o2oboot.entity.Access;
import o2oboot.entity.Role;
import o2oboot.service.*;
import o2oboot.service.impl.AccessRoleMapServiceImpl;
import o2oboot.service.impl.RoleUserMapServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class PermissionInterceptor extends HandlerInterceptorAdapter {
	/**
	 * 主要做事前拦截，即用户操作发生前，改写preHandle里的逻辑，进行用户操作权限的拦截
	 * 
	 *
	 *
	 */
	@Autowired
	private AccessService accessService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;
	@Autowired
	private AccessRoleMapService accessRoleMapService;
	@Autowired
	private RoleUserMapService roleUserMapService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String url=request.getRequestURI();
		Object userObj = request.getSession().getAttribute("currentUser");
		Long userId=userService.getUserIdByUsername(String.valueOf(userObj));
		Role role=roleUserMapService.queryRoleByUserId(userId);
		List<Access> accesses=accessRoleMapService.queryAllAccessByRoleId(role.getRoleId());

		for (Access access :
				accesses) {
			if (access.getUrl().equals(url)){
				return true;
			}
		}
		return false;


	}
}

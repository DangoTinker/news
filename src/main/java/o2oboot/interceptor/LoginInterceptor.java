package o2oboot.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * 店家管理系统登录验证拦截器
 * 
 *
 *
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
	/**
	 * 主要做事前拦截，即用户操作发生前，改写preHandle里的逻辑，进行拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 从session中取出用户信息来
		Object userObj = request.getSession().getAttribute("currentUser");
		if (userObj != null) {

			return true;
		}
		// 若不满足登录验证，则直接跳转到帐号登录页面
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<script>");
		out.println("window.open ('" + request.getContextPath() + "/front/index)");
		out.println("</script>");
		out.println("</html>");
		return false;
	}
}

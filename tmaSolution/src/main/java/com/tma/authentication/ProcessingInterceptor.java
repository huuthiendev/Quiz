package com.tma.authentication;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.tma.authentication.Auth.Role;

public class ProcessingInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		
		Auth roleAnnotation = AnnotationUtils.findAnnotation(method, Auth.class);
		Auth.Role[] roles = roleAnnotation != null ? roleAnnotation.role() : null;
		
		HttpSession session = request.getSession();
		boolean isLogined = session.getAttribute("isLogin") != null ? (Boolean) session.getAttribute("isLogin") : false;
		Auth.Role loginRole = session.getAttribute("role") != null ? (Auth.Role) session.getAttribute("role") : null;
		
		if (roles != null) {
			if (!isLogined) {
				response.getWriter().print("Please login!");
				return false;
			} else {
				if(roles!=null)
				{
					Boolean filterRole = false;
					for(Role role : roles){
						if(role == loginRole){
							filterRole = true;
						}
					} if(filterRole == false){
						response.getWriter().print("You don't have permission to access this page");
						return false;
					}
				}
			}
		}
		return true;
	}

}

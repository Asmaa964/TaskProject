package com.bookstores.bookstores.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;

public class CustomAccessDeniedHandler  implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		
		  Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		  if(auth!=null) {
			  System.out.println(auth.getName()+" ------- "+request.getRequestURL());
		  }
		response.sendRedirect(request.getContextPath()+"/access-Denied");//request.getContextPath()+
	}

}

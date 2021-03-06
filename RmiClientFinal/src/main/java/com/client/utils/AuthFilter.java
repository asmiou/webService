package com.client.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.server.entities.impl.UserImpl;


public class AuthFilter implements Filter {

    private ServletContext context;

    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
    }

	@SuppressWarnings("null")
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);
        UserImpl user= new UserImpl();
        user = (UserImpl) session.getAttribute("user");
        
        if (user == null){
        	if(user.getRole()!="admin") {
        		this.context.log("Access denied: you are not loged or not an admin");
                res.sendRedirect(req.getContextPath() + "/index.jsp");
        		//res.sendRedirect("/");
        	}
        } else {
            // pass the request along the filter chain
            chain.doFilter(request, response);
        }
    }

    public void destroy() {
        //close any resources here
    }
}

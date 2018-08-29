package com.infosystem.demo.interceptor;

import com.infosystem.demo.domain.UserInfo;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class MyInterceptor
 *
 *
 * @version        1.0, 17/09/30
 * @author         datapps
 */
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e)
            throws Exception {}

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView)
            throws Exception {}

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
            throws Exception {
        boolean  flag = true;
        UserInfo userInfo = (UserInfo) httpServletRequest.getSession().getAttribute("user");

        if (userInfo == null) {
            System.out.println("转发到login.html");
            httpServletResponse.sendRedirect("/login");
            //httpServletRequest.getRequestDispatcher("/login").forward(httpServletRequest,httpServletResponse);
            flag = false;
        } else {
            flag = true;
        }

        return flag;
    }
}


package cn.liboyan.trumpetpress.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * AdminInterceptor
 *
 * @author Li Boyan
 * @version 1.0
 * @date 2020/6/25
 */
public class AdminInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/tp-admin");
            return false;
        } else {
            return true;
        }
    }
}

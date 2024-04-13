package org.lsh.handler;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.lsh.common.Result;
import org.lsh.entity.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

// 认证成功处理器
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // 用户身份信息
        LoginUser principal = (LoginUser) authentication.getPrincipal();
        // 凭证信息
        Object credentials = authentication.getCredentials();

        Object details = authentication.getDetails();

        String json = JSON.toJSONString(Result.ok("认证成功", principal));
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println(json);
    }
}

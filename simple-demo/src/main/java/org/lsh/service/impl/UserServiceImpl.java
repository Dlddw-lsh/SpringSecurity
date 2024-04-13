package org.lsh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.lsh.common.Result;
import org.lsh.entity.LoginUser;
import org.lsh.entity.User;
import org.lsh.mapper.UserMapper;
import org.lsh.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author lsh
 * @description 针对表【sys_user】的数据库操作Service实现
 * @createDate 2024-04-12 21:56:12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {


    @Resource
    HttpServletRequest request;

    @Resource
    UserMapper userMapper;

    @Resource
    PasswordEncoder passwordEncoder;

    @Resource
    AuthenticationManager authenticationManager;

    @Override
    public void saveUserDetails(User user) {
        String password = user.getPassword();
        String encode = passwordEncoder.encode(password);
        user.setPassword(encode);
        userMapper.insert(user);
    }

    @Override
    public Result<String> login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        // 登录失败会捕获异常信息
        try {
            Authentication authenticate = authenticationManager.authenticate(authenticationToken);
            LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
            Integer userId = loginUser.getUser().getUserId();
        } catch (Exception e) {
            return Result.error(402, e.getMessage(), "登录失败");
        }
        return Result.ok("登录成功");
    }
}





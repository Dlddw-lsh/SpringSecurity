package org.lsh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.annotation.Resource;
import org.lsh.entity.LoginUser;
import org.lsh.entity.User;
import org.lsh.mapper.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

// 使用Component将其加载到Spring的上下文中
@Component
public class DBUserDetailsImpl implements UserDetailsService {

    @Resource
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, username);
        User dbUser = userMapper.selectOne(wrapper);
        if (dbUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new LoginUser(dbUser);
    }
}

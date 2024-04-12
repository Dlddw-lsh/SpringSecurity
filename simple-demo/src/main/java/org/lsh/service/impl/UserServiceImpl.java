package org.lsh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.lsh.entity.User;
import org.lsh.mapper.UserMapper;
import org.lsh.service.UserService;
import org.springframework.stereotype.Service;

/**
* @author lsh
* @description 针对表【sys_user】的数据库操作Service实现
* @createDate 2024-04-12 21:56:12
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

}





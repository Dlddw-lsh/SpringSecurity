package org.lsh.service;

import org.lsh.common.Result;
import org.lsh.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.lsh.model.MenuTree;

import java.util.List;

/**
 * @author lsh
 * @description 针对表【sys_user】的数据库操作Service
 * @createDate 2024-04-12 21:56:12
 */
public interface UserService extends IService<User> {

    void saveUserDetails(User user);

    Result<List<MenuTree>> login(User user);
}

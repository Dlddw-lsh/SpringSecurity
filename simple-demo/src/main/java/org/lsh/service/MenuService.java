package org.lsh.service;

import org.lsh.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import org.lsh.entity.User;
import org.lsh.model.MenuTree;

import java.util.List;

/**
* @author lsh
* @description 针对表【sys_menu】的数据库操作Service
* @createDate 2024-04-13 16:56:49
*/
public interface MenuService extends IService<Menu> {

    List<MenuTree> getTreeMenu(Integer userId);
}

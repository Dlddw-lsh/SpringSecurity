package org.lsh.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.lsh.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author lsh
* @description 针对表【sys_menu】的数据库操作Mapper
* @createDate 2024-04-13 16:56:49
* @Entity org.lsh.entity.Menu
*/
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> getMenuByUserId(Integer userId);
}





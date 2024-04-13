package org.lsh.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;

/**
 * @TableName sys_menu
 */
@TableName(value = "sys_menu")
@Data
public class Menu implements Serializable {

    private Integer menuId;

    private Integer parentId;

    /**
     * 菜单名称
     */
    private String title;

    /**
     * 权限字段
     */
    private String code;

    /**
     * 路由name
     */
    private String name;

    /**
     * 跳转路径
     */
    private String menuUrl;

    /**
     * 路由path
     */
    private String routePath;

    /**
     * 组件路径
     */
    private String componentPath;

    /**
     * 类型(0 目录 1 菜单 2 按钮)
     */
    private Integer type;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 上级菜单名称
     */
    private String parentName;

    /**
     * 序号
     */
    private Integer orderNum;
}
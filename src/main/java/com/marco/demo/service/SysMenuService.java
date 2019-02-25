package com.marco.demo.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.marco.demo.entity.SysMenu;
import com.marco.demo.entity.SysUser;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author marco
 * @since 2018-07-26
 */
public interface SysMenuService extends IService<SysMenu> {

	List<SysMenu> selectMenuByUser(SysUser sysUser);

}

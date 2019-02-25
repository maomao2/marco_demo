package com.marco.demo.mapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.marco.demo.entity.SysMenu;
import com.marco.demo.entity.SysUser;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author marco
 * @since 2018-07-25
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

	List<SysMenu> selectMenuByUser(SysUser sysUser);

}

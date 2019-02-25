package com.marco.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.marco.demo.entity.SysMenu;
import com.marco.demo.entity.SysUser;
import com.marco.demo.mapper.SysMenuMapper;
import com.marco.demo.service.SysMenuService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author marco
 * @since 2018-07-23
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

	@Resource
	private SysMenuMapper sysMenuMapper;

	@Override
	public List<SysMenu> selectMenuByUser(SysUser sysUser) {
		List<SysMenu> list = sysMenuMapper.selectMenuByUser(sysUser);
		return list;
	}

}

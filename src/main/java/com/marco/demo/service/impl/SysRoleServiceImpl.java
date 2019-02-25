package com.marco.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.marco.demo.entity.SysRole;
import com.marco.demo.entity.SysUser;
import com.marco.demo.entity.SysUserRole;
import com.marco.demo.mapper.SysRoleMapper;
import com.marco.demo.mapper.SysUserRoleMapper;
import com.marco.demo.service.SysRoleService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author marco
 * @since 2018-07-23
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

	@Resource
	private SysUserRoleMapper userRoleMapper;
	
	@Override
	public List<SysRole> selectRoleByUser(SysUser sysUser) {
		EntityWrapper<SysUserRole> wrapper = new EntityWrapper<>();
		wrapper.eq("uid", sysUser.getId());
		List<SysUserRole> list = userRoleMapper.selectList(wrapper);
		EntityWrapper<SysRole> roleWrapper = new EntityWrapper<>();
		List<Integer> roleIds = list.stream().map(item -> item.getRoleId()).collect(Collectors.toList());
		roleWrapper.in("id", roleIds);
		List<SysRole> roleList = super.selectList(roleWrapper);
		return roleList;
	}

}

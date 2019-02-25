package com.marco.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.marco.demo.entity.SysRole;
import com.marco.demo.entity.SysUser;
import com.marco.demo.mapper.SysUserMapper;
import com.marco.demo.service.SysUserService;

/**
 * <p>
 * 后台用户 服务实现类
 * </p>
 *
 * @author marco
 * @since 2018-07-23
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

	@Resource
	private SysUserMapper sysUserMapper;

	@Override
	public SysUser findByUserName(String userName) {
		SysUser param = new SysUser();
		param.setUserName(userName);
		SysUser result = sysUserMapper.selectOne(param);
		return result;
		
	}

	@Override
	public List<SysRole> selectRoleByUser(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}

package com.marco.demo.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.marco.demo.entity.SysUserRole;
import com.marco.demo.mapper.SysUserRoleMapper;
import com.marco.demo.service.SysUserRoleService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author marco
 * @since 2018-07-23
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

}

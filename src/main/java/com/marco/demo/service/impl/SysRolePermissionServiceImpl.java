package com.marco.demo.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.marco.demo.entity.SysRolePermission;
import com.marco.demo.mapper.SysRolePermissionMapper;
import com.marco.demo.service.SysRolePermissionService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author marco
 * @since 2018-07-23
 */
@Service("sysRolePermissionService")
public class SysRolePermissionServiceImpl extends ServiceImpl<SysRolePermissionMapper, SysRolePermission> implements SysRolePermissionService {

}

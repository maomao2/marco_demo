package com.marco.demo.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.marco.demo.entity.SysRole;
import com.marco.demo.entity.SysUser;

/**
 * <p>
 * 后台用户 服务类
 * </p>
 *
 * @author marco
 * @since 2018-07-26
 */
public interface SysUserService extends IService<SysUser> {

	SysUser findByUserName(String userName);

	List<SysRole> selectRoleByUser(Integer id);

}

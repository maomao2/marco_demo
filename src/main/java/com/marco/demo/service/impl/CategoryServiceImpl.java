package com.marco.demo.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.marco.demo.entity.Category;
import com.marco.demo.mapper.CategoryMapper;
import com.marco.demo.service.CategoryService;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author marco
 * @since 2018-08-28
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}

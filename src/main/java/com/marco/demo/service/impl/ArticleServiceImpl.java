package com.marco.demo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.marco.demo.entity.Article;
import com.marco.demo.mapper.ArticleMapper;
import com.marco.demo.service.ArticleService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author marco
 * @since 2018-08-24
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
	@Resource
	private ArticleMapper mapper;

	@Override
	public Page<Article> selectArticleMoreByPage(Page<Article> page, Article param){
		Wrapper<Article> wrapper = new EntityWrapper<Article>(param);
		return this.selectPage(page, wrapper);
	}

	@Override
	public Article selectArticleByIdentName(String identName){
		Article param = new Article();
		param.setIdentName(identName);
		return mapper.selectOne(param);
	}
}

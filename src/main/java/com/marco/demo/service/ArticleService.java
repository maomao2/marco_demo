package com.marco.demo.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.marco.demo.entity.Article;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author marco
 * @since 2018-08-28
 */
public interface ArticleService extends IService<Article> {

	/**
	 * 分页查询文章列表
	 * @param page
	 * @param param
	 * @return
	 */
	Page<Article> selectArticleMoreByPage(Page<Article> page, Article param);

	/**
	 * 按唯一标识查询文章
	 * @param identName
	 * @return
	 */
	Article selectArticleByIdentName(String identName);

}

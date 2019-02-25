package com.marco.demo.controller.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.marco.demo.entity.Article;
import com.marco.demo.service.ArticleService;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author marco
 * @since 2018-08-24
 */
@Controller
@RequestMapping("/admin/article")
public class AdminArticleController {

	@Resource
	private ArticleService articleService;

	@RequestMapping(value = { "/", "/list" })
	public String list(Model model, Page<Article> page, Article param) {
		EntityWrapper<Article> wrapper = new EntityWrapper<Article>();
		wrapper.setEntity(param);
		param.setStatus(1);
		page = articleService.selectArticleMoreByPage(page, param);
		model.addAttribute("data", page);
		return "/article/list";
	}

	@RequestMapping(value = { "/edit" })
	public String edit(Model model, Integer id) {
		if (id == null) {
			model.addAttribute("update", false);
			model.addAttribute("data", new Article());
			return "/article/edit";
		} else {
			Article article = articleService.selectById(id);
			model.addAttribute("data", article);
			model.addAttribute("update", true);
		}
		return "/article/edit";
	}

	@RequestMapping(value = { "/save" })
	public String save(Model model, Article param, Boolean update, HttpServletRequest request) {
		boolean flag = false;
		if (Boolean.TRUE.equals(update)) {
			flag = articleService.updateById(param);
		} else {
			flag = articleService.insert(param);
		}

		if (flag) {
			return "redirect:/admin/article/list";
		} else {
			Article article = articleService.selectById(param.getId());
			model.addAttribute("data", article);
			model.addAttribute("error", flag ? "更新失败！" : "新增失败！");
			return "/article/edit";
		}
	}

	@RequestMapping(value = { "/delete" })
	public String delete(Model model, Integer id) {
		boolean flag = false;
		flag = articleService.deleteById(id);
		return "redirect:/admin/article/list";
	}

}

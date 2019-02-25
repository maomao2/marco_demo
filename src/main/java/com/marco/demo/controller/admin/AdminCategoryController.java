package com.marco.demo.controller.admin;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.marco.demo.controller.CURDController;
import com.marco.demo.entity.Category;
import com.marco.demo.entity.enums.ApiResultType;
import com.marco.demo.entity.result.ObjectResult;
import com.marco.demo.service.CategoryService;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author marco
 * @since 2018-08-28
 */
@RestController
@RequestMapping("/admin/category")
@CrossOrigin
public class AdminCategoryController extends CURDController<Category> {

	@Resource
	private CategoryService classService;

	@RequestMapping("/list")
	public ObjectResult list(Model model, Page<Category> page, Category param) {
		EntityWrapper<Category> wrapper = new EntityWrapper<Category>();
		wrapper.setEntity(param);
		page = classService.selectPage(page, wrapper);
		return new ObjectResult(ApiResultType.SUCCESS, page);
	}

	@RequestMapping("/alllist")
	public ObjectResult alllist(Model model, Page<Category> page, Category param) {
		EntityWrapper<Category> wrapper = new EntityWrapper<Category>();
		wrapper.setEntity(param);
		List<Category> list = classService.selectList(wrapper);
		return new ObjectResult(ApiResultType.SUCCESS, list);
	}

	@RequestMapping("/detail/{id}")
	public ObjectResult detail(Model model, Page<Category> page, @PathVariable(name = "id", required = true) Integer id) {
		Category category = classService.selectById(id);
		return new ObjectResult(ApiResultType.SUCCESS, category);
	}

	@Override
	protected void afterAdd(Category bean, Map<String, String> paramMap) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void afterUpdate(Category bean, Map<String, String> paramMap) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void afterDelete(Integer id, Map<String, String> paramMap) {
		// TODO Auto-generated method stub

	}

	@Override
	protected Category preAdd(Category bean) {
		return bean;
	}

	@Override
	protected Category preUpdate(Category bean) {
		return bean;
	}

	@Override
	protected int preDelete(Integer id) {
		return id;
	}

	public AdminCategoryController(CategoryService service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

}

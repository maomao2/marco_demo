package com.marco.demo.controller.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.plugins.Page;
import com.marco.demo.entity.Article;
import com.marco.demo.entity.SysUser;
import com.marco.demo.service.SysUserService;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author marco
 * @since 2018-08-24
 */
@Controller
@RequestMapping("/auth")
public class AdminLoginController {

	@Resource
	private SysUserService userService;

	@RequestMapping("/login_page")
	public String loginPage(Model model, Page<Article> page, Article param) {
		return "/login";
	}

	@RequestMapping("/doLogin")
	public String login(HttpSession session, Model model, String username, String password) {
		if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
			model.addAttribute("error", "请输入用户名和密码！");
			return "/login";
		}
		SysUser user = userService.findByUserName(username);
		if(user == null){
			model.addAttribute("error", "用户名或密码错误");
			return "/login";
		}
		password = DigestUtils.md5Hex(password);
		if (user.getPassword().equals(password)) {
			session.setAttribute("isLogin", true);
		}
		return "redirect:/admin/article/list";
	}

}

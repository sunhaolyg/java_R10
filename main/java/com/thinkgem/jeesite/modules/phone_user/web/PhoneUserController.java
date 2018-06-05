/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.phone_user.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.phone_user.entity.PhoneUser;
import com.thinkgem.jeesite.modules.phone_user.service.PhoneUserService;

/**
 * 用户信息Controller
 * @author xuxiaolian
 * @version 2018-06-04
 */
@Controller
@RequestMapping(value = "${adminPath}/phone_user/phoneUser")
public class PhoneUserController extends BaseController {

	@Autowired
	private PhoneUserService phoneUserService;
	
	@ModelAttribute
	public PhoneUser get(@RequestParam(required=false) String id) {
		PhoneUser entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = phoneUserService.get(id);
		}
		if (entity == null){
			entity = new PhoneUser();
		}
		return entity;
	}
	
	@RequiresPermissions("phone_user:phoneUser:view")
	@RequestMapping(value = {"list", ""})
	public String list(PhoneUser phoneUser, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<PhoneUser> page = phoneUserService.findPage(new Page<PhoneUser>(request, response), phoneUser); 
		model.addAttribute("page", page);
		return "modules/phone_user/phoneUserList";
	}

	@RequiresPermissions("phone_user:phoneUser:view")
	@RequestMapping(value = "form")
	public String form(PhoneUser phoneUser, Model model) {
		model.addAttribute("phoneUser", phoneUser);
		return "modules/phone_user/phoneUserForm";
	}

	@RequiresPermissions("phone_user:phoneUser:edit")
	@RequestMapping(value = "save")
	public String save(PhoneUser phoneUser, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, phoneUser)){
			return form(phoneUser, model);
		}
		phoneUserService.save(phoneUser);
		addMessage(redirectAttributes, "保存用户信息成功");
		return "redirect:"+Global.getAdminPath()+"/phone_user/phoneUser/?repage";
	}
	
	@RequiresPermissions("phone_user:phoneUser:edit")
	@RequestMapping(value = "delete")
	public String delete(PhoneUser phoneUser, RedirectAttributes redirectAttributes) {
		phoneUserService.delete(phoneUser);
		addMessage(redirectAttributes, "删除用户信息成功");
		return "redirect:"+Global.getAdminPath()+"/phone_user/phoneUser/?repage";
	}

}
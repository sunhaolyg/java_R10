/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.phone_user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.phone_user.entity.PhoneUser;
import com.thinkgem.jeesite.modules.phone_user.dao.PhoneUserDao;

/**
 * 用户信息Service
 * @author xuxiaolian
 * @version 2018-06-04
 */
@Service
@Transactional(readOnly = true)
public class PhoneUserService extends CrudService<PhoneUserDao, PhoneUser> {

	public PhoneUser get(String id) {
		return super.get(id);
	}
	
	public List<PhoneUser> findList(PhoneUser phoneUser) {
		return super.findList(phoneUser);
	}
	
	public Page<PhoneUser> findPage(Page<PhoneUser> page, PhoneUser phoneUser) {
		return super.findPage(page, phoneUser);
	}
	
	@Transactional(readOnly = false)
	public void save(PhoneUser phoneUser) {
		super.save(phoneUser);
	}
	
	@Transactional(readOnly = false)
	public void delete(PhoneUser phoneUser) {
		super.delete(phoneUser);
	}
	
}
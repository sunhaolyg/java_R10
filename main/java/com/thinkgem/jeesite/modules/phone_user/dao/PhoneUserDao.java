/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.phone_user.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.phone_user.entity.PhoneUser;

/**
 * 用户信息DAO接口
 * @author xuxiaolian
 * @version 2018-06-04
 */
@MyBatisDao
public interface PhoneUserDao extends CrudDao<PhoneUser> {
	
}
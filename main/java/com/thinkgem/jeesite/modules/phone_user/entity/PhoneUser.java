/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.phone_user.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 用户信息Entity
 * @author xuxiaolian
 * @version 2018-06-04
 */
public class PhoneUser extends DataEntity<PhoneUser> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 姓名
	private String age;		// 年龄
	private String sex;		// 性别
	private String address;		// 地址
	private Date birth;		// 生日
	private String number;		// 电话
	
	public PhoneUser() {
		super();
	}

	public PhoneUser(String id){
		super(id);
	}

	@Length(min=1, max=255, message="姓名长度必须介于 1 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=1, max=255, message="年龄长度必须介于 1 和 255 之间")
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	@Length(min=1, max=11, message="性别长度必须介于 1 和 11 之间")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Length(min=0, max=255, message="地址长度必须介于 0 和 255 之间")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="生日不能为空")
	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	@Length(min=1, max=20, message="电话长度必须介于 1 和 20 之间")
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
}
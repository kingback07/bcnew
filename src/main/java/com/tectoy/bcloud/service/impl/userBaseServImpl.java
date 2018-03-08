package com.tectoy.bcloud.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tectoy.bcloud.dao.api.UserBasePOMapper;
import com.tectoy.bcloud.model.po.UserBasePO;
import com.tectoy.bcloud.service.api.IUserBaseService;

@Service("userbaseServ")
public class userBaseServImpl implements IUserBaseService {

	@Resource
	UserBasePOMapper userbasedao;
	
	@Override
	public UserBasePO getUserBaseInfobyId(Integer id){
		return userbasedao.selectByPrimaryKey(id);
	}
	
}

package com.tectoy.bcloud.dao.api;

import com.tectoy.bcloud.model.po.UserBasePO;

public interface UserBasePOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserBasePO record);

    int insertSelective(UserBasePO record);

    UserBasePO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserBasePO record);

    int updateByPrimaryKey(UserBasePO record);
}
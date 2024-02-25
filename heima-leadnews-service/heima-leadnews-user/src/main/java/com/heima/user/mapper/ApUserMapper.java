package com.heima.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heima.model.user.pojo.ApUser;

@Mapper
public interface ApUserMapper extends BaseMapper<ApUser> {
}

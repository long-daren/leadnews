package com.heima.wemedia.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heima.model.wemedia.pojos.WmNews;

@Mapper
public interface WmNewsMapper  extends BaseMapper<WmNews> {
    
}
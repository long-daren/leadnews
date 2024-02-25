package com.heima.article.service;

import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.article.pojo.ApArticleConfig;

public interface ApArticleConfigService extends IService<ApArticleConfig> {

    /**
     * 修改文章配置
     * @param map
     */
    public void updateByMap(Map map);
}
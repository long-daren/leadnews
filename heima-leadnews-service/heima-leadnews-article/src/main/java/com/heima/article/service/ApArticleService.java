package com.heima.article.service;

import org.springframework.web.bind.annotation.RequestBody;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.article.dto.ArticleDto;
import com.heima.model.article.dto.ArticleHomeDto;
import com.heima.model.article.pojo.ApArticle;
import com.heima.model.common.dtos.ResponseResult;

public interface ApArticleService extends IService<ApArticle> {
    /**
     * 根据参数加载文章列表
     * @param loadtype 1为加载更多  2为加载最新
     * @param dto
     * @return
     */
    ResponseResult load(Short loadtype, ArticleHomeDto dto);

    /**
     * 加载文章列表
     * @param dto
     * @param type  1 加载更多   2 加载最新
     * @param firstPage  true  是首页  flase 非首页
     * @return
     */
    public ResponseResult load2(ArticleHomeDto dto,Short type,boolean firstPage);

    /**
     * 保存app相关文章
     * @param dto
     * @return
     */
    ResponseResult saveArticle(ArticleDto dto);
}

package com.itheima.apis.article;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.heima.model.article.dto.ArticleDto;
import com.heima.model.common.dtos.ResponseResult;
import com.itheima.apis.article.fallback.IArticleClientFallback;

@FeignClient(value = "leadnews-article",fallback = IArticleClientFallback.class)
public interface IArticleClient {
    @PostMapping("/api/v1/article/save")
    public ResponseResult saveArticle(@RequestBody ArticleDto dto);
}

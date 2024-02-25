package com.itheima.apis.wemedia;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.heima.model.common.dtos.ResponseResult;

@FeignClient("leadnews-wemedia")
public interface IWemediaClient {

    @GetMapping("/api/v1/channel/list")
    public ResponseResult getChannels();
}

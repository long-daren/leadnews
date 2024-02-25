package com.heima.common.aliyun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.aliyun.imageaudit20191230.models.ScanImageRequest;
import com.aliyun.imageaudit20191230.models.ScanImageResponse;
import com.aliyun.tea.TeaModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "aliyun")
public class ImageScan {

    private String accessKeyId;
    private String accessKeySecret;
    private String scenes;

    public Map scanImage(String imgUrl) throws Exception {
        // 创建AccessKey ID和AccessKey Secret，请参考https://help.aliyun.com/document_detail/175144.html
        // 如果您使用的是RAM用户的AccessKey，还需要为子账号授予权限AliyunVIAPIFullAccess，请参考https://help.aliyun.com/document_detail/145025.html
        // 从环境变量读取配置的AccessKey ID和AccessKey Secret。运行代码示例前必须先配置环境变量。
        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
            .setAccessKeyId("")
            .setAccessKeySecret("");
        // 访问的域名
        config.endpoint = "imageaudit.cn-shanghai.aliyuncs.com";
        com.aliyun.imageaudit20191230.Client client = new com.aliyun.imageaudit20191230.Client(config);

        ScanImageRequest.ScanImageRequestTask task0 = new ScanImageRequest.ScanImageRequestTask();
        task0.setImageURL(imgUrl);
        task0.setDataId("uuid-xxxx-xxxx-123456");
        task0.setImageTimeMillisecond(1L);
        task0.setInterval(1);
        task0.setMaxFrames(1);
        List<ScanImageRequest.ScanImageRequestTask> taskList = new ArrayList<>();
        taskList.add(task0);
        List<String> sceneList = new ArrayList<>();
        sceneList.add(scenes);
        com.aliyun.imageaudit20191230.models.ScanImageRequest scanImageRequest = new com.aliyun.imageaudit20191230.models.ScanImageRequest()
            .setTask(taskList)
            .setScene(sceneList);
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        Map<String, Object> map = new HashMap<>();
        try {
            ScanImageResponse scanImageResponse = client.scanImageWithOptions(scanImageRequest, runtime);
            map = TeaModel.buildMap(scanImageResponse);
            // 获取整体结果
//            System.out.println(com.aliyun.teautil.Common.toJSONString(TeaModel.buildMap(scanImageResponse)));
            // 获取单个字段
//            System.out.println(scanImageResponse.getBody().getData());
        }
        catch (com.aliyun.tea.TeaException teaException) {
            // 获取整体报错信息
            System.out.println(com.aliyun.teautil.Common.toJSONString(teaException));
            // 获取单个字段
            System.out.println(teaException.getCode());
        }
        return map;
    }
}

package com.heima.wemedia.test;


import com.heima.common.aliyun.GreenImageScan;
import com.heima.common.aliyun.GreenTextScan;
import com.heima.common.aliyun.ImageScan;
import com.heima.common.aliyun.TextScan;
import com.heima.file.service.FileStorageService;
import com.heima.wemedia.WemediaApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = WemediaApplication.class)
@RunWith(SpringRunner.class)
public class AliyunTest {

    @Autowired
    private GreenTextScan greenTextScan;

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private GreenImageScan greenImageScan;
    @Autowired
    private ImageScan imageScan;
    @Autowired
    private TextScan textScan;

    /**
     * 测试文本内容审核
     */
    @Test
    public void testScanText() throws Exception {
        Map map = textScan.scanText("我是一个好人,冰毒");
        System.out.println(map);
    }

    /**
     * 测试图片审核
     */
    @Test
    public void testScanImage() throws Exception {

        byte[] bytes = fileStorageService.downLoadFile("http://192.168.200.130:9000/leadnews/2023/10/27/5e11ae23f0b14b0a839306c9428d3bc7.jpg");

        String imgUrl = new String(bytes);

        Map map = imageScan.scanImage(imgUrl);
        System.out.println(map);

    }
}

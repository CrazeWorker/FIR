package com;

import com.taotao.web.util.FastDFSClient;

public class TestImgServer {
    public static void main(String[] args) throws Exception {
        // 加载配置文件
        FastDFSClient fastDFSClient = new FastDFSClient("C:/Users/Administrator/Desktop/taotao/fdfs_client.conf");
        String file = fastDFSClient.uploadFile("C:/Users/Administrator/Desktop/图片素材/huodong.png");
        System.out.println(file);
    }
}

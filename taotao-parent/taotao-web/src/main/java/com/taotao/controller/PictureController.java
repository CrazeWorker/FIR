package com.taotao.controller;

import com.taotao.web.util.FastDFSClient;
import com.taotao.web.util.JsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
public class PictureController {

    // 前缀
    @Value("${TAOTAO_IMAGE_SERVER_URL}")
    private String TAOTAO_IMAGE_SERVER_URL;

    @RequestMapping(path = "/pic/upload",produces = MediaType.TEXT_PLAIN_VALUE+";charset=UTF-8")
    @ResponseBody
    public String fileupload(MultipartFile uploadFile){
        try {
            // 1、创建一个FastDFS对象
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
            // 2、获取源文件字节数组
            byte[] bytes = uploadFile.getBytes();
            // 3、获取源文件拓展名
            String originalFilename = uploadFile.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            // 4、执行上传
            String path = fastDFSClient.uploadFile(bytes, extName);
            // 5、拼接返回的url和ip地址
            String url = TAOTAO_IMAGE_SERVER_URL+path;
            // 6、设置提示信息
            Map result = new HashMap();
            result.put("error", 0);
            result.put("url", url);
            // 使用JsonUtil工具类返回json对象
            return JsonUtils.objectToJson(result);
        } catch (Exception e) {
            e.printStackTrace();
            Map result = new HashMap();
            result.put("error", 1);
            result.put("message", "图片上传失败!");
            return JsonUtils.objectToJson(result);
        }


        // KindEditor的图片上传插件不支持返回json数据
        /*try {
            // 1、取文件的拓展名
            String originalFilename = upload.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            // 2、创建一个FastDFS对象
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
            // 3、执行上传
            String path = fastDFSClient.uploadFile(upload.getBytes(), extName);
            // 4、拼接返回的url和ip地址
            String url = TAOTAO_IMAGE_SERVER_URL+path;
            // 5、返回map
            Map result = new HashMap();
            result.put("error", 0);
            result.put("message", url);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            // 5、返回map
            Map result = new HashMap();
            result.put("error", 1);
            result.put("message", "图片上传失败!");
            return result;
        }*/
    }
}

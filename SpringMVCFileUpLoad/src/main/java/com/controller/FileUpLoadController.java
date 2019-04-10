package com.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(path = "/file")
public class FileUpLoadController {
    /**
     * web中的文件上传
     */
    @RequestMapping(path = "/WebFileUpLoad")
    public String WebFileUpLoad(HttpServletRequest request) throws Exception {
        System.out.println("文件开始上传。。。。。。。");
        // 获取上传后的路径
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        System.out.println(path);
        // 创建文件，判断路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }
        // 创建上传工厂对象
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
        // 解析request
        List<FileItem> fileItems = upload.parseRequest(request);
        // 遍历集合
        for (FileItem fileItem : fileItems) {
            // 判断当前的类型是否为上传文件
            if (!fileItem.isFormField()) {
                String fileName = fileItem.getName();
                // 生成随机id为名字重新赋值
                String uuid = UUID.randomUUID().toString().replace("-", "");
                fileName = uuid + "_" + fileName;
                System.out.println(fileName);
                // 完成文件上传
                fileItem.write(new File(path, fileName));
                // 删除文件
                fileItem.delete();
            }
        }
        return "success";
    }

    /**
     * springMVC中的文件上传
     */
    @RequestMapping(path = "/SpringMVCFileUpLoad")
    public String springMVCFileUpLoad(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("文件开始上传。。。。。。。");
        // 获取上传后的路径
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        System.out.println(path);
        // 创建文件，判断路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }
        // 判断当前的类型是否为上传文件
        String fileName = upload.getOriginalFilename();
        // 生成随机id为名字重新赋值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileName = uuid + "_" + fileName;
        System.out.println(fileName);
        // 完成文件上传
        upload.transferTo(new File(path,fileName));
        return "success";
    }
    /**
     * springMVC中的跨服务器文件上传
     */
    @RequestMapping(path = "/springMVCCrossServerFileUpLoad")
    public String springMVCCrossServerFileUpLoad(MultipartFile upload) throws Exception {
        System.out.println("文件开始上传。。。。。。。");
        String path = "http://www.ningdali.com/smart/";
        // 判断当前的类型是否为上传文件
        String fileName = upload.getOriginalFilename();
        // 生成随机id为名字重新赋值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileName = uuid + "_" + fileName;
        System.out.println(fileName);
        // 完成文件上传
        // 1、创建客户端对象
        Client client = Client.create();
        // 2、连接服务器
        WebResource resource = client.resource(path + fileName);
        // 3、完成文件上传
        resource.put(upload.getBytes());
        return "success";
    }
}

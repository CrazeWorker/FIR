package com.weixin.controller;

import com.weixin.util.JsonUtils;
import com.weixin.util.MdzwUtils;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class TestController {
    @RequestMapping("test/showData")
    @ResponseBody
    public Integer test(int phoneNumber){
        System.out.println(phoneNumber);
        Integer checkInfo = 115262;
        return checkInfo;
    }

    @RequestMapping("test/login")
    @ResponseBody
    //获取openid
    public Map<String, Object> getWxUserOpenid(String code, String appId, String appSecret) {
        //拼接url
        StringBuilder url = new StringBuilder("https://api.weixin.qq.com/sns/jscode2session?");
        url.append("appid=");//appid设置
        url.append(appId);
        url.append("&secret=");//secret设置
        url.append(appSecret);
        url.append("&js_code=");//code设置
        url.append(code);
        url.append("&grant_type=authorization_code");
        Map<String, Object> map = null;
        System.out.println(code +" "+appId+" "+appSecret);
        try {
            HttpClient client = HttpClientBuilder.create().build();//构建一个Client
            HttpGet get = new HttpGet(url.toString());    //构建一个GET请求
            HttpResponse response = client.execute(get);//提交GET请求
            HttpEntity result = response.getEntity();//拿到返回的HttpResponse的"实体"
            String content = EntityUtils.toString(result);
            System.out.println(content);//打印返回的信息
            JSONObject res = JSONObject.fromObject(content);//把信息封装为json
            //把信息封装到map
            map = MdzwUtils.parseJSON2Map(res);//这个小工具的代码在下面
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}

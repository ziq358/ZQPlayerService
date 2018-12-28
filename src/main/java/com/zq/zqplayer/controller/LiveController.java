package com.zq.zqplayer.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.zq.zqplayer.ResultModel;
import com.zq.zqplayer.ResultModelTool;
import com.zq.zqplayer.model.live.PandaTvDataBean;
import com.zq.zqplayer.model.live.PandaTvLiveDataBean;
import com.zq.zqplayer.model.live.VideoHttpResult;
import com.zq.zqplayer.model.request.LiveListItemRequestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import com.zq.zqplayer.model.request.LiveListRequestBean;
import org.springframework.lang.Nullable;
import org.springframework.lang.NonNull;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.NameValuePair;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.springframework.web.client.RestTemplate;


@lombok.extern.slf4j.Slf4j
@RestController
public class LiveController {

    @PostMapping("/live/list")
    public VideoHttpResult<PandaTvDataBean> list(@NonNull @RequestBody LiveListRequestBean liveListRequestBean)throws java.io.IOException{
        log.info(liveListRequestBean.toString());
        String result = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String url = String.format("http://api.m.panda.tv/ajax_get_live_list_by_cate?" +
                "cate=%s&" +
                "pageno=%s&" +
                "pagenum=%s&" +
                "room=%s&" +
                "version=%s",
                liveListRequestBean.getCate(),
                liveListRequestBean.getPageno(),
                liveListRequestBean.getPagenum(),
                liveListRequestBean.getRoom(),
                liveListRequestBean.getVersion());

        HttpGet httpGet = new HttpGet(url);
        // 设置header信息
        httpGet.setHeader("Accept", "application/json");
        httpGet.setHeader("Content-type", "application/json");
        httpGet.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        // 执行请求操作，并拿到结果（同步阻塞）
        CloseableHttpResponse response = httpClient.execute(httpGet);
        // 获取结果实体
        // 判断网络连接状态码是否正常(0--200都数正常)
        if (response.getStatusLine().getStatusCode() == org.apache.http.HttpStatus.SC_OK) {
            result = EntityUtils.toString(response.getEntity(), "utf-8");
        }
        // 释放链接
        response.close();
        log.info("result = " + result);

        VideoHttpResult<PandaTvDataBean> resultObject = JSON.parseObject(result, new TypeReference<VideoHttpResult<PandaTvDataBean>>(){});
        log.info("resultObject = " + resultObject);
        return resultObject;
    }


    @PostMapping("/live/list/item")
    public VideoHttpResult<PandaTvLiveDataBean> item(@NonNull @RequestBody LiveListItemRequestBean liveListItemRequestBean)throws java.io.IOException{
        log.info(liveListItemRequestBean.toString());
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("http://api.m.panda.tv/ajax_get_liveroom_baseinfo?" +
                        "roomid=%s&" +
                        "__version=%s&" +
                        "slaveflag=%s&" +
                        "type=%s&" +
                        "__plat=%s",
                liveListItemRequestBean.getRoomid(),
                liveListItemRequestBean.get__version(),
                liveListItemRequestBean.getSlaveflag(),
                liveListItemRequestBean.getType(),
                liveListItemRequestBean.get__plat());
        log.info("url = " + url);
        String result = restTemplate.getForObject(url, String.class);
        log.info("result = " + result);
        VideoHttpResult<PandaTvLiveDataBean> resultObject = JSON.parseObject(result, new TypeReference<VideoHttpResult<PandaTvLiveDataBean>>(){});
        log.info("resultObject = " + resultObject);

        VideoHttpResult<PandaTvLiveDataBean> response = restTemplate.exchange(url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<VideoHttpResult<PandaTvLiveDataBean>>() {}).getBody();
        log.info("response = " + response);

        return response;
    }

}

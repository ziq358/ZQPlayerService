package com.zq.zqplayer.controller;

import com.zq.zqplayer.ResultModel;
import com.zq.zqplayer.ResultModelTool;
import org.springframework.beans.factory.annotation.Autowired;
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


@lombok.extern.slf4j.Slf4j
@RestController
public class LiveController {

    @PostMapping("/live/list")
    public ResultModel list(@NonNull @RequestBody LiveListRequestBean liveListRequestBean)throws java.io.IOException{
        log.info(liveListRequestBean.toString());
        String result = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String url = String.format("http://api.m.panda.tv/ajax_get_live_list_by_cate?" +
                "cate=%s&" +
                "pageno=%s&" +
                "pagenum=%s&" +
                "room=%s&" +
                "version=%s&",
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

        ResultModel resultModel = new ResultModel();
        resultModel.setCode(1);
        resultModel.setData(result);
        return ResultModelTool.handleResultModel(resultModel);
    }

}

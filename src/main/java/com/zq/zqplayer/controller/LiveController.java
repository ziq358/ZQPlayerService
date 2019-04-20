package com.zq.zqplayer.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.zq.zqplayer.ResultModel;
import com.zq.zqplayer.model.live.*;
import com.zq.zqplayer.model.request.LiveItemDetailRequest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import com.zq.zqplayer.model.request.LiveListRequest;
import org.springframework.lang.NonNull;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.client.methods.HttpGet;

import java.util.List;

import org.apache.http.util.EntityUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;


@lombok.extern.slf4j.Slf4j
@RestController
public class LiveController {

    @PostMapping("/live/list")
    public ResultModel list(@NonNull @RequestBody @Valid LiveListRequest liveListRequestBean)throws java.io.IOException{
        log.info(liveListRequestBean.toString());
        String result = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();

        String url = String.format("http://api.maxjia.com/api/live/list/?" +
                "offset=%s&" +
                "limit=%s&" +
                "live_type=%s&" +
                "game_type=%s",
                liveListRequestBean.getOffset(),
                liveListRequestBean.getLimit(),
                liveListRequestBean.getLive_type(),
                liveListRequestBean.getGame_type());

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

        LiveResponse<List<LiveListItemBean>> resultObject = JSON.parseObject(result, new TypeReference<LiveResponse<List<LiveListItemBean>>>(){});
        log.info("resultObject = " + resultObject);
        List<LiveListItemBean> items = resultObject.getResult();

        ResultModel resultModel = new ResultModel();
        resultModel.setCode(1);
        resultModel.setMsg("请求成功");
        resultModel.setData(items);
        return resultModel;
    }


    @PostMapping("/live/list/item")
    public ResultModel item(@NonNull @RequestBody @Valid LiveItemDetailRequest liveListItemRequestBean)throws java.io.IOException{
        log.info(liveListItemRequestBean.toString());
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("http://api.maxjia.com/api/live/detail/?" +
                        "live_type=%s&" +
                        "live_id=%s&" +
                        "game_type=%s",
                liveListItemRequestBean.getLive_type(),
                liveListItemRequestBean.getLive_id(),
                liveListItemRequestBean.getGame_type());
        String result = restTemplate.getForObject(url, String.class);
        LiveResponse<LiveItemDetailBean> response = JSON.parseObject(result, new TypeReference<LiveResponse<LiveItemDetailBean>>(){});
        log.info("response = " + response);

//        LiveResponse<LiveItemDetailBean> response = restTemplate.exchange(url,
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<LiveResponse<LiveItemDetailBean>>() {}).getBody();
//        log.info("response = " + response);


        LiveItemDetailBean liveItemDetailBean = response.getResult();

        ResultModel resultModel = new ResultModel();
        resultModel.setMsg("请求成功");
        resultModel.setCode(1);
        resultModel.setData(liveItemDetailBean);

        return resultModel;
    }

}

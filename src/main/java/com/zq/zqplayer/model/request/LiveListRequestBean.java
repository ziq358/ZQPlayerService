package com.zq.zqplayer.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author wenyzhang
 * @date 2018/9/12 14:41
 */
@Data
public class LiveListRequestBean {

    //{
    //	"cate" : "lol",
    //	"pageno" : "1",
    //	"pagenum" : "20",
    //	"room" : "1",
    //	"version" : "3.3.1.5978"
    //}

    private String cate;
    private String pageno;
    private String pagenum;
    private String room;
    private String version;

}

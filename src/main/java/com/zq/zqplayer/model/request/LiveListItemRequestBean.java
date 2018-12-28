package com.zq.zqplayer.model.request;

import lombok.Data;

/**
 * @author wenyzhang
 * @date 2018/9/12 14:41
 */
@Data
public class LiveListItemRequestBean {

    //{
    //	"roomid" : "119663",
    //	"__version" : "3.3.1.5978",
    //	"slaveflag" : "1",
    //	"type" : "json",
    //	"__plat" : "android"
    //}

    private String roomid;
    private String __version;
    private String slaveflag;
    private String type;
    private String __plat;

}

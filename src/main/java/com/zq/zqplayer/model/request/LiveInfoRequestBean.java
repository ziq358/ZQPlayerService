package com.zq.zqplayer.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author wenyzhang
 * @date 2018/9/12 14:41
 */
@Data
public class LiveInfoRequestBean {

    private String roomid;
    private String __version;
    private String slaveflag;
    private String type;
    private String __plat;

}

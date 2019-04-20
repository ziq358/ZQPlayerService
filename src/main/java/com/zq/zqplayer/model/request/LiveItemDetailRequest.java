package com.zq.zqplayer.model.request;

import lombok.Data;

/**
 * @author wenyzhang
 * @date 2018/9/12 14:41
 */
@Data
public class LiveItemDetailRequest {

    private String live_type="";
    private String live_id;
    private String game_type="";

}

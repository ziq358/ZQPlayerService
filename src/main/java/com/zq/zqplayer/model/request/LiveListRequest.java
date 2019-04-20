package com.zq.zqplayer.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author wenyzhang
 * @date 2018/9/12 14:41
 */
@Data
public class LiveListRequest {
    private String offset;
    private String limit;
    private String live_type;
    private String game_type;
}

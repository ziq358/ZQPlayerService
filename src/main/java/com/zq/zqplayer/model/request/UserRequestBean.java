package com.zq.zqplayer.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author wenyzhang
 * @date 2018/9/12 14:41
 */
@Data
public class UserRequestBean {

//    @JsonProperty(value = "applyid")
//    @NotBlank(message = "applyid不能为空")
    private String userId;
}

package com.zq.zqplayer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
*
* @author
* @since
*/
@lombok.Data
public class CurrentUserInfo implements Serializable {
    @JsonProperty("userid")
    private String userId;
}

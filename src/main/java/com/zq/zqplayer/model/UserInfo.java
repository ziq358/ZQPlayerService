package com.zq.zqplayer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
*
* @author
* @since
*/
@lombok.Data
public class UserInfo implements Serializable {

    private long id;
    @JsonProperty("userid")
    private String userId;
    @JsonProperty("username")
    private String userName;
    private String password;
    private String token;

}

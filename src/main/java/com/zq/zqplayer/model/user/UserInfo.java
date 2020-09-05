package com.zq.zqplayer.model.user;

import java.io.Serializable;

/**
*
* @author
* @since
*/
@lombok.Data
public class UserInfo implements Serializable {

    private long id;
    private String userId;
    private String userName;
    private String password;
    private String token;

}

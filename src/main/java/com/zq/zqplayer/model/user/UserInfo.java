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
    private String user_id;
    private String user_name;
    private String password;
}

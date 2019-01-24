package com.zq.zqplayer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
*
* @author
* @since
*/
@lombok.Data
public class User {
    private long id;
    private String userId;
    private String userName;
    private String password;

    public User() {
    }
}

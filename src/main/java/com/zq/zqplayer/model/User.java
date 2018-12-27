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
@Entity
@lombok.Data
@Table(name = "user")
public class User {
    @Id
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private String age;

    public User() {
    }

    public User(long id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

}

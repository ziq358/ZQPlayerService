package com.zq.zqplayer.userjpa;

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
@Table(name = "myuser")
public class MyUser {
    @Id
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private String age;

    public MyUser() {
    }

    public MyUser(long id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

}

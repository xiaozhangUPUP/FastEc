package com.zq.latte_ec.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by zhangqi on 2019/10/31
 */
@Entity(nameInDb = "user_profile")
public class UserProfile {
    @Id
    private long userId = 0;
    private Integer id;
    private String email;
    private String logo_url;
    private String username;
    private String mobi;
    @Generated(hash = 781213987)
    public UserProfile(long userId, Integer id, String email, String logo_url,
            String username, String mobi) {
        this.userId = userId;
        this.id = id;
        this.email = email;
        this.logo_url = logo_url;
        this.username = username;
        this.mobi = mobi;
    }
    @Generated(hash = 968487393)
    public UserProfile() {
    }
    public long getUserId() {
        return this.userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getLogo_url() {
        return this.logo_url;
    }
    public void setLogo_url(String logo_url) {
        this.logo_url = logo_url;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getMobi() {
        return this.mobi;
    }
    public void setMobi(String mobi) {
        this.mobi = mobi;
    }
}

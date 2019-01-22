package com.sprintboot.domain;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

public class SwaggerEntity {

    @ApiModelProperty("用户id")
    private String id;

    @ApiModelProperty("用户名称")
    private String name;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("博客")
    private String blog;

    @ApiModelProperty("微信公众号")
    private String wx_pub;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getWx_pub() {
        return wx_pub;
    }

    public void setWx_pub(String wx_pub) {
        this.wx_pub = wx_pub;
    }
}

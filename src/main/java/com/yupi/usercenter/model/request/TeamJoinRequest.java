package com.yupi.usercenter.model.request;

import lombok.Data;


import java.io.Serializable;

/**
 * 加入队伍 参数 封装类
 * @author xiaozhuang
 * @creat 2023-08-10-23:01
 */
@Data
public class TeamJoinRequest implements Serializable {

    private static final long serialVersionUID = 1618315504782568715L;
    /**
     * 加入队伍的Id
     */
    private Long teamId;


    /**
     * 密码
     */
    private String password;
}

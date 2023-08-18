package com.yupi.usercenter.model.request;

/**
 * @author xiaozhuang
 * @creat 2023-08-11-15:30
 */


import lombok.Data;

import java.io.Serializable;

/**
 * 用户退出队伍的参数包装类
 */
@Data
public class TeamQuitRequest implements Serializable {

    private static final long serialVersionUID = 64483233262612736L;

    /**
     * 队伍id
     */
    private Long teamId;
}


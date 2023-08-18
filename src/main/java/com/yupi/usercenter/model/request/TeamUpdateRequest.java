package com.yupi.usercenter.model.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xiaozhuang
 * @creat 2023-08-10-21:48
 */

/**
 * 更新队伍信息实体类
 */
@Data
public class TeamUpdateRequest implements Serializable {

    private static final long serialVersionUID = -86266948795273824L;

    /**
     * id:更新的是哪一条数据
     */
    private Long id;

    /**
     * 队伍名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 过期时间
     */
    private Date expireTime;

    /**
     * 0 - 公开，1 - 私有，2 - 加密
     */
    private Integer status;

    /**
     * 密码
     */
    private String password;
}

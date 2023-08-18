package com.yupi.usercenter.model.request;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

/**
 * 删除队伍请求封装类
 * @author xiaozhuang
 * @creat 2023-08-09-17:39
 */
@Data
public class TeamDeleteRequest {

    private long id ;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}

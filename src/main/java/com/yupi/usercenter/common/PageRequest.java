package com.yupi.usercenter.common;

import lombok.Data;


import java.io.Serializable;

/**
 * 通用分页请求参数
 * @author xiaozhuang
 * @creat 2023-08-08-22:38
 */
@Data
public class PageRequest implements Serializable {


    private static final long serialVersionUID = 7132556857756071421L;
    /**
     * 页面大小
     */
    protected int pageSize=10;

    /**
     * 每页几条数据
     */
    protected int pageNum=1;
}

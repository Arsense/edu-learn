package edu.cl.learn.domain;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * 学科基础类
 * @Author: Clay
 * @Date: 2021/2/12 2:30 下午
 */
@Data
public class Subject implements Serializable {


    private Integer id;

    /**
     * 学科名 比如语文 数学
     */
    private String name;

    /**
     * 年级 (1-12) 小学 初中 高中  大学
     */
    private Integer level;
    /**
     * 一年级、二年级等
     */
    private String levelName;
    /**
     * 排序
     */
    private Integer itemOrder;
    /**
     *  是否删除吧
     */
    private Boolean deleted;
}

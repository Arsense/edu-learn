package edu.cl.learn.vo.subject;

import lombok.Data;

/**
 * @Author: Clay
 * @Date: 2021/2/12 5:03 下午
 */
@Data
public class SubjectEditRequestVO {



    private Integer id;

    private String name;

    private Integer level;

    private String levelName;
}

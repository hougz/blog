package com.hgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author hgz
 * @since 2021-02-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TbApi implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer apiId;

    /**
     * //api名
     */
    private String name;

    /**
     * //请求地址
     */
    private String url;

    /**
     * 请求方式
     */
    private String method;

    /**
     * 父id
     */
    private Integer pid;

    /**
     * 描述
     */
    private String description;

    /**
     * 排序
     */
    private String sort;


}

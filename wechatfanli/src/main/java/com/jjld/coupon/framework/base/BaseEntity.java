package com.jjld.coupon.framework.base;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * 基础类，封装基本字段
 *
 * @author SongFei
 * @date 2019/11/18 11:42
 */
@Getter
@Setter
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	protected Integer id;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 删除标记：0、未删除，1、已删除
     */
    private Integer deleted;

}

package com.liuyfly.biz.dal.dataobject;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据对象
 * 
 * @since 2016-07-06
 */
public class SequenceDO implements Serializable {

    private static final long serialVersionUID = 146776970277874178L;

    private Long              id;

    private String            name;

    private Long              value;

    private Date              gmtCreate;

    private Date              gmtModified;

    private Long              oldValue;

    public SequenceDO() {
        super();
    }

    public SequenceDO(Long id, String name, Long value, Date gmtCreate, Date gmtModified) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Long getOldValue() {
        return oldValue;
    }

    public void setOldValue(Long oldValue) {
        this.oldValue = oldValue;
    }

}

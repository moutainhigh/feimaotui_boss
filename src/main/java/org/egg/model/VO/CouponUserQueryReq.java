package org.egg.model.VO;

import org.egg.model.DO.CouponUser;

import java.util.Date;

/**
 * @author dataochen
 * @Description
 * @date: 2019/12/19 11:57
 */
public class CouponUserQueryReq extends CouponUser {
    private Date createdDateStart;

    private Date createdDateEnd;

    private Date expireDateStart;
    private Date expireDateEnd;

    /**
     * 每页数
     */
    private Integer pageNum;
    /**
     * 页码
     */
    private Integer pageNo;
    /**
     * 排序字段 @See  PubOrdersOCEnum index
     * 默认 发布时间
     */
    private String orderColumn;

    /**
     * 是否正序
     */
    private Boolean ascFlag;
    private Integer first;
    private Integer end;

    public void setCreatedDateStart(Date createdDateStart) {
        this.createdDateStart = createdDateStart;
    }

    public Date getCreatedDateStart() {
        return this.createdDateEnd;
    }

    public Date getCreatedDateEnd() {
        return createdDateEnd;
    }

    public void setCreatedDateEnd(Date createdDateEnd) {
        this.createdDateEnd = createdDateEnd;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public String getOrderColumn() {
        return orderColumn;
    }

    public void setOrderColumn(String orderColumn) {
        this.orderColumn = orderColumn;
    }

    public Boolean getAscFlag() {
        return ascFlag;
    }

    public void setAscFlag(Boolean ascFlag) {
        this.ascFlag = ascFlag;
    }

    public Integer getFirst() {
        return (pageNo==null||pageNum==null)?null:(pageNo-1)*pageNum;
    }

    public Integer getEnd() {
        return pageNum;
    }

    public Date getExpireDateStart() {
        return expireDateStart;
    }

    public void setExpireDateStart(Date expireDateStart) {
        this.expireDateStart = expireDateStart;
    }

    public Date getExpireDateEnd() {
        return expireDateEnd;
    }

    public void setExpireDateEnd(Date expireDateEnd) {
        this.expireDateEnd = expireDateEnd;
    }
}

package com.qbao.recommend.respositoy.mysql.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @author wangping
 * @createTime 下午3:45
 * $$LastChangedDate: 2016-11-15 18:40:03 +0800 (Tue, 15 Nov 2016) $$
 * $$LastChangedRevision: 1399 $$
 * $$LastChangedBy: wangping $$
 */
public class HotSpuSearch implements Serializable {

    private static final long serialVersionUID = "$Id: HotSpuSearch.java 1399 2016-11-15 10:40:03Z wangping $".hashCode();
    private long id;
    private long goodsId; //spuId or baogou id;
    private int isBaoGou;
    private int sid;
    private int cid;
    private String dt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }

    public int getIsBaoGou() {
        return isBaoGou;
    }

    public void setIsBaoGou(int isBaoGou) {
        this.isBaoGou = isBaoGou;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof HotSpuSearch))
            return false;

        HotSpuSearch that = (HotSpuSearch) o;

        return new EqualsBuilder()
                .append(getId(), that.getId())
                .append(getGoodsId(), that.getGoodsId())
                .append(getIsBaoGou(), that.getIsBaoGou())
                .append(getSid(), that.getSid())
                .append(getCid(), that.getCid())
                .append(getDt(), that.getDt())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getId())
                .append(getGoodsId())
                .append(getIsBaoGou())
                .append(getSid())
                .append(getCid())
                .append(getDt())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("goodsId", goodsId)
                .append("isBaoGou", isBaoGou)
                .append("sid", sid)
                .append("cid", cid)
                .append("dt", dt)
                .toString();
    }
}

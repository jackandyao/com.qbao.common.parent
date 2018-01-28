
package com.qbao.recommend.business.task.cmp.model.user;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Goods {

    @SerializedName("buy_items")
    @Expose
    private List<BuyItem> buyItems = new ArrayList<BuyItem>();
    @SerializedName("favorite_items")
    @Expose
    private List<FavoriteItem> favoriteItems = new ArrayList<FavoriteItem>();
    @SerializedName("view_items")
    @Expose
    private List<ViewItem> viewItems = new ArrayList<ViewItem>();

    /**
     * 
     * @return
     *     The buyItems
     */
    public List<BuyItem> getBuyItems() {
        return buyItems;
    }

    /**
     * 
     * @param buyItems
     *     The buy_items
     */
    public void setBuyItems(List<BuyItem> buyItems) {
        this.buyItems = buyItems;
    }

    /**
     * 
     * @return
     *     The favoriteItems
     */
    public List<FavoriteItem> getFavoriteItems() {
        return favoriteItems;
    }

    /**
     * 
     * @param favoriteItems
     *     The favorite_items
     */
    public void setFavoriteItems(List<FavoriteItem> favoriteItems) {
        this.favoriteItems = favoriteItems;
    }

    /**
     * 
     * @return
     *     The viewItems
     */
    public List<ViewItem> getViewItems() {
        return viewItems;
    }

    /**
     * 
     * @param viewItems
     *     The view_items
     */
    public void setViewItems(List<ViewItem> viewItems) {
        this.viewItems = viewItems;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(buyItems).append(favoriteItems).append(viewItems).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Goods) == false) {
            return false;
        }
        Goods rhs = ((Goods) other);
        return new EqualsBuilder().append(buyItems, rhs.buyItems).append(favoriteItems, rhs.favoriteItems).append(viewItems, rhs.viewItems).isEquals();
    }

}

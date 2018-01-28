package com.qbao.recommend.business.shop.cmp.model;

import java.io.Serializable;
import java.util.List;

import com.qbao.recommend.business.shop.cmp.model.goodshop.RecProduct;


/**
 * @author	yuandongrui
 * @date 	2016年6月29日
 */
public class GoodShopDTO implements Serializable{
    private static final long serialVersionUID = "$Id: GoodShopDTO.java 1139 2016-09-21 09:56:13Z wangping $".hashCode();
	private long id;
	private String name;
	private int type;
	private String logoUrl;
	private int onSale;
	private int sold;
	private String shopUrl;
	private int likes;
	private List<RecProduct> products;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	public int getOnSale() {
		return onSale;
	}
	public void setOnSale(int onSale) {
		this.onSale = onSale;
	}
	public int getSold() {
		return sold;
	}
	public void setSold(int sold) {
		this.sold = sold;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public List<RecProduct> getProducts() {
		return products;
	}
	public void setProducts(List<RecProduct> products) {
		this.products = products;
	}
	public String getShopUrl() {
		return shopUrl;
	}
	public void setShopUrl(String shopUrl) {
		this.shopUrl = shopUrl;
	}
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
//        result = prime * result + likes;
//        result = prime * result + ((logoUrl == null) ? 0 : logoUrl.hashCode());
//        result = prime * result + ((name == null) ? 0 : name.hashCode());
//        result = prime * result + onSale;
//        result = prime * result + ((products == null) ? 0 : products.hashCode());
//        result = prime * result + ((shopUrl == null) ? 0 : shopUrl.hashCode());
//        result = prime * result + sold;
//        result = prime * result + type;
        return result;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GoodShopDTO other = (GoodShopDTO) obj;
        if (id != other.id)
            return false;
        if (likes != other.likes)
            return false;
        if (logoUrl == null) {
            if (other.logoUrl != null)
                return false;
        } else if (!logoUrl.equals(other.logoUrl))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (onSale != other.onSale)
            return false;
        if (products == null) {
            if (other.products != null)
                return false;
        } else if (!products.equals(other.products))
            return false;
        if (shopUrl == null) {
            if (other.shopUrl != null)
                return false;
        } else if (!shopUrl.equals(other.shopUrl))
            return false;
        if (sold != other.sold)
            return false;
        if (type != other.type)
            return false;
        return true;
    }
	
   
	
}

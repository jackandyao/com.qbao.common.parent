package com.qbao.recommend.business.shop.cmp.model.goodshop;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class AssetInfo {

    @SerializedName("balance")
    @Expose
    private Long balance;
    @SerializedName("freeze")
    @Expose
    private Long freeze;
    @SerializedName("receivable")
    @Expose
    private Long receivable;
    @SerializedName("wallet_status")
    @Expose
    private Integer walletStatus;

    /**
     * 
     * @return
     *     The balance
     */
    public Long getBalance() {
        return balance;
    }

    /**
     * 
     * @param balance
     *     The balance
     */
    public void setBalance(Long balance) {
        this.balance = balance;
    }

    /**
     * 
     * @return
     *     The freeze
     */
    public Long getFreeze() {
        return freeze;
    }

    /**
     * 
     * @param freeze
     *     The freeze
     */
    public void setFreeze(Long freeze) {
        this.freeze = freeze;
    }

    /**
     * 
     * @return
     *     The receivable
     */
    public Long getReceivable() {
        return receivable;
    }

    /**
     * 
     * @param receivable
     *     The receivable
     */
    public void setReceivable(Long receivable) {
        this.receivable = receivable;
    }

    /**
     * 
     * @return
     *     The walletStatus
     */
    public Integer getWalletStatus() {
        return walletStatus;
    }

    /**
     * 
     * @param walletStatus
     *     The wallet_status
     */
    public void setWalletStatus(Integer walletStatus) {
        this.walletStatus = walletStatus;
    }

}

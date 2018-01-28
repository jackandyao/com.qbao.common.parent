
package com.qbao.recommend.stream.cmp.domain.maxwell;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.qbao.recommend.stream.cmp.domain.nginx.Record;
import com.qbao.recommend.stream.cmp.enums.EventType;
import com.qbao.recommend.stream.cmp.enums.TopicType;
@Generated("org.jsonschema2pojo")
public abstract class BinLogInfo {

    @SerializedName("database")
    @Expose
    private String database;
    
    @SerializedName("table")
    @Expose
    private String table;
    
    @SerializedName("type")
    @Expose
    private String type;
    
    @SerializedName("ts")
    @Expose
    private Long ts;
    
    @SerializedName("xid")
    @Expose
    private Long xid;
    
    @SerializedName("commit")
    @Expose
    private Boolean commit;
    

    /**
     * 
     * @return
     * The database
     */
    public String getDatabase() {
        return database;
    }

    /**
     * 
     * @param database
     * The database
     */
    public void setDatabase(String database) {
        this.database = database;
    }

    /**
     * 
     * @return
     * The table
     */
    public String getTable() {
        return table;
    }

    /**
     * 
     * @param table
     * The table
     */
    public void setTable(String table) {
        this.table = table;
    }

    /**
     * 
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     * The ts
     */
    public Long getTs() {
        return ts;
    }

    /**
     * 
     * @param ts
     * The ts
     */
    public void setTs(Long ts) {
        this.ts = ts;
    }

    /**
     * 
     * @return
     * The xid
     */
    public Long getXid() {
        return xid;
    }

    /**
     * 
     * @param xid
     * The xid
     */
    public void setXid(Long xid) {
        this.xid = xid;
    }

    /**
     * 
     * @return
     * The commit
     */
    public Boolean getCommit() {
        return commit;
    }

    /**
     * 
     * @param commit
     * The commit
     */
    public void setCommit(Boolean commit) {
        this.commit = commit;
    }

    public  abstract Object getData();
    public  abstract Record toRecord(EventType type, TopicType topicType, boolean isBaoGou);

}

/**
 * 
 */
package com.qbao.recommend.business.tweet.model;

import java.io.Serializable;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2017-01-12 15:34:26 +0800 (Thu, 12 Jan 2017) $
 * $LastChangedRevision: 1543 $
 * $LastChangedBy: wangping $
 */
public class TweetDTO implements Serializable {

    private static final long serialVersionUID = "$Id: TweetDTO.java 1543 2017-01-12 07:34:26Z wangping $".hashCode();
    private long id;
    private String url;
    private String title;
    private String source;

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     * the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     * the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id
     * the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the type
     */
    public String getSource() {
        return source;
    }

    /**
     * @param source
     * the type to set
     */
    public void setSource(String source) {
        this.source = source;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((source == null) ? 0 : source.hashCode());
        result = prime * result + ((url == null) ? 0 : url.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
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
        TweetDTO other = (TweetDTO) obj;
        if (id != other.id)
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (source == null) {
            if (other.source != null)
                return false;
        } else if (!source.equals(other.source))
            return false;
        if (url == null) {
            if (other.url != null)
                return false;
        } else if (!url.equals(other.url))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TweetDTO [id=" + id + ", url=" + url + ", title=" + title + ", source=" + source + "]";
    }

}

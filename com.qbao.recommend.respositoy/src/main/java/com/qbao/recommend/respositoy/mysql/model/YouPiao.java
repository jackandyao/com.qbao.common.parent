
package com.qbao.recommend.respositoy.mysql.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class YouPiao {

    @SerializedName("film_items")
    @Expose
    private List<FilmItem> filmItems = new ArrayList<FilmItem>();
    @SerializedName("show_items")
    @Expose
    private List<ShowItem> showItems = new ArrayList<ShowItem>();

    /**
     * 
     * @return
     *     The filmItems
     */
    public List<FilmItem> getFilmItems() {
        return filmItems;
    }

    /**
     * 
     * @param filmItems
     *     The film_items
     */
    public void setFilmItems(List<FilmItem> filmItems) {
        this.filmItems = filmItems;
    }

    /**
     * 
     * @return
     *     The showItems
     */
    public List<ShowItem> getShowItems() {
        return showItems;
    }

    /**
     * 
     * @param showItems
     *     The show_items
     */
    public void setShowItems(List<ShowItem> showItems) {
        this.showItems = showItems;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(filmItems).append(showItems).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof YouPiao) == false) {
            return false;
        }
        YouPiao rhs = ((YouPiao) other);
        return new EqualsBuilder().append(filmItems, rhs.filmItems).append(showItems, rhs.showItems).isEquals();
    }

}

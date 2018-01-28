package com.qbao.recommend.respositoy.redis.model;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.json.JSONArray;
import org.json.JSONObject;

public class Event implements Serializable {
    private static final long serialVersionUID = "$Id: Event.java 896 2016-09-05 10:26:32Z jiahongping $".hashCode();
    private ArrayList<Click> click;
    private ArrayList<Favorites> favorites;

    public Event() {

    }

    public Event(JSONObject json) {

        this.click = new ArrayList<Click>();
        JSONArray arrayClick = json.optJSONArray("click");
        if (null != arrayClick) {
            int clickLength = arrayClick.length();
            for (int i = 0; i < clickLength; i++) {
                JSONObject item = arrayClick.optJSONObject(i);
                if (null != item) {
                    this.click.add(new Click(item));
                }
            }
        } else {
            JSONObject item = json.optJSONObject("click");
            if (null != item) {
                this.click.add(new Click(item));
            }
        }

        this.favorites = new ArrayList<Favorites>();
        JSONArray arrayFavorites = json.optJSONArray("favorites");
        if (null != arrayFavorites) {
            int favoritesLength = arrayFavorites.length();
            for (int i = 0; i < favoritesLength; i++) {
                JSONObject item = arrayFavorites.optJSONObject(i);
                if (null != item) {
                    this.favorites.add(new Favorites(item));
                }
            }
        } else {
            JSONObject item = json.optJSONObject("favorites");
            if (null != item) {
                this.favorites.add(new Favorites(item));
            }
        }

    }

    public ArrayList<Click> getClick() {
        return this.click;
    }

    public void setClick(ArrayList<Click> click) {
        this.click = click;
    }

    public ArrayList<Favorites> getFavorites() {
        return this.favorites;
    }

    public void setFavorites(ArrayList<Favorites> favorites) {
        this.favorites = favorites;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(ToStringStyle.SIMPLE_STYLE);
    }

}

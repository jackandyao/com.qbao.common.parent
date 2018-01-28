/**
 * 
 */
package com.qbao.recommend.respositoy.restful.entities;

import java.io.Serializable;

/**
 * @author linhanye
 *
 *         $LastChangedDate: 2016-11-15 18:38:46 +0800 (周一, 19 九月 2016) $
 *         $LastChangedRevision: 1071 $ $LastChangedBy: linhanye $
 */
public class User implements Serializable {

	private static final long serialVersionUID = "$Id: User.java 1024 2016-09-14 06:47:40Z wangping $".hashCode();

	private long id;

	private String name;

	private double distance;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", distance=" + distance + "]";
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
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (distance <= 0) {
			if (other.distance > 0)
				return false;
		} else if (!(distance == other.distance))
			return false;
		return true;
	}
}
package com.stuffy.business;

import javax.persistence.*;


@Entity
public class Stuffy {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String type;
	private String color;
	private String size;
	private int limbs;
	
	public Stuffy() {
		super();
		
	}

	public Stuffy(int id, String type, String color, String size, int limbs) {
		super();
		this.id = id;
		this.type = type;
		this.color = color;
		this.size = size;
		this.limbs = limbs;
	}

	public Stuffy(String type, String color, String size, int limbs) {
		this.type = type;
		this.color = color;
		this.size = size;
		this.limbs = limbs;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @return the limbs
	 */
	public int getLimbs() {
		return limbs;
	}

	/**
	 * @param limbs the limbs to set
	 */
	public void setLimbs(int limbs) {
		this.limbs = limbs;
	}

	@Override
	public String toString() {
		return "id=" + id + ", type=" + type + ", color=" + color + ", size=" + size + ", limbs=" + limbs;
	}
	
	
	
	
}

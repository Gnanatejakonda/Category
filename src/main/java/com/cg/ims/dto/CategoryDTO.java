package com.cg.ims.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ims_category")
public class CategoryDTO {
	@Id
	@Column(name="catId")
	private int catId;
	
	@Column(name="catName")
	private String catName;
	public CategoryDTO(int catId, String catName) {
		super();
		this.catId = catId;
		this.catName = catName;
	}
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	
	public CategoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CategoryDTO [catId=" + catId + ", catName=" + catName + "]";
	}
	
}


package com.slb.activeworkoutservice.dto;



public class Category {

	int id;
	String title;
	public Category() {
		
	}
	public Category(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", title=" + title + "]";
	}
	
	

}

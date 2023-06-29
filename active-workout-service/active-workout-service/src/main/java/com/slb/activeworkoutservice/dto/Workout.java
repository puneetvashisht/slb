package com.slb.activeworkoutservice.dto;




public class Workout {

	int id;
	String title;
	int cbpm;
	String description;
	
	Category category;
	public Workout() {
		
	}
	public Workout(int id, String title, int cbpm, String desc, Category category) {
		super();
		this.id = id;
		this.title = title;
		this.cbpm = cbpm;
		this.description = desc;

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
	public int getCbpm() {
		return cbpm;
	}
	public void setCbpm(int cbpm) {
		this.cbpm = cbpm;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Workout [id=" + id + ", title=" + title + ", cbpm=" + cbpm + ", desc=" + description + ", category=" + category
				+ "]";
	}

	
	
}

package com.springBoot.github.searchRepo.models;


public class Repos {
	private String id;
	private String title;
	private String url;
	private String user;
	
	public Repos(String id, String title, String url, String user) {
		super();
		this.id = id;
		this.title = title;
		this.url = url;
		this.user = user;
	}

	public Repos() {
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	
}

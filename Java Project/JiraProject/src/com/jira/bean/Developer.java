package com.jira.bean;

import java.util.Map;

public class Developer {

	private String self;
	private String name;
	private String key;
	private String emailAddress;
	private Map avatarUrls;
	private String displayName;
	private String active;
	private String timeZone;
	
	
	public String getSelf() {
		return self;
	}
	public void setSelf(String self) {
		this.self = self;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public Map getAvatarUrls() {
		return avatarUrls;
	}
	public void setAvatarUrls(Map avatarUrls) {
		this.avatarUrls = avatarUrls;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	
	
}

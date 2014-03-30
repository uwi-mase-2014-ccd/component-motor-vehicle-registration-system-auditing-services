package com.generic.audit;

public class AuditObj {
	private String dbHost;
	private String dbName;
	private String dbUsername;
	private String dbPassword;
	private int dbPort;
	private String username;
	private int eventId;
	private String comments;
	private String event;
	private int auditId;
	
	public AuditObj()
	{
		
	}
	
	public AuditObj(String host,String dbName,String dUsername,String password,int port, String username, int eventId,String comments)
	{
		this.dbHost = host;
		this.dbName = dbName;
		this.dbUsername = dUsername;
		this.dbPassword = password;
		this.dbPort = port;
		this.username = username;
		this.eventId = eventId;
		this.comments = comments;
		//this.event = event;
		
		/*
		System.out.println("dbHost:"+dbHost);
		System.out.println("dbName:"+dbName);
		System.out.println("dbUsername:"+dbUsername);
		System.out.println("dbPassword:"+dbPassword);
		System.out.println("dbPort:"+dbPort);
		System.out.println("username:"+username);
		System.out.println("eventId:"+eventId);
		System.out.println("comments:"+comments);*/
		
	}

	public String getDbHost() {
		return dbHost;
	}

	public void setDbHost(String dbHost) {
		this.dbHost = dbHost;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getDbUsername() {
		return dbUsername;
	}

	public void setDbUsername(String dbUsername) {
		this.dbUsername = dbUsername;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public int getDbPort() {
		return dbPort;
	}

	public void setDbPort(int dbPort) {
		this.dbPort = dbPort;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public int getAuditId() {
		return auditId;
	}

	public void setAuditId(int auditId) {
		this.auditId = auditId;
	}
 
 
}

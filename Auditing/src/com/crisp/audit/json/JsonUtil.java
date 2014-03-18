package com.crisp.audit.json;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.generic.audit.AuditObj;



public class JsonUtil {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String encode(Integer eventAuditId, boolean status,String msg){
		String jsonString = "";
		
		Map debugMap = new HashMap();
		debugMap.put("data", "");
		debugMap.put("message", msg);
		
		JSONObject debug = new JSONObject(debugMap);
		
		
		Map map = new HashMap();
		map.put("code", (status != true) ? 422 : 200 );
		map.put("data",(status != true) ? null : "Audit Entry with event ID: "+eventAuditId+" Successfully Created." );
		map.put("debug", debug);
		
		JSONObject jsonObj = new JSONObject(map);
		jsonString = jsonObj.toString();
		
		return jsonString;
	}
	
	public AuditObj decode (String jsonStr) //kim
	{
		
		JSONObject audJasonOjb= new JSONObject(jsonStr);
		
		String dbHost = audJasonOjb.getString("dbHost");
		String dbName = audJasonOjb.getString("dbName");
		String dbUsername = audJasonOjb.getString("dbUsername");
		String dbPassword = audJasonOjb.getString("dbPassword");
		int dbPort = audJasonOjb.getInt("dbPort");
		String username = audJasonOjb.getString("userName");
		int eventId  = audJasonOjb.getInt("eventId");
		String comments = audJasonOjb.getString("comment");
		//String event = audJasonOjb.getString("event");
		/*
		System.out.println("dbHost"+dbHost);
		System.out.println("dbName"+dbName);
		System.out.println("dbUsername"+dbUsername);
		System.out.println("dbPassword"+dbPassword);
		System.out.println("dbPort"+dbPort);
		System.out.println("username"+username);
		System.out.println("eventId"+eventId);
		System.out.println("comments"+comments);*/
		
		/*
		audit.setDbHost("localhost");
		audit.setDbUsername("root");
		audit.setDbName("genaudit");
		audit.setDbPassword("b18cintegra");
		audit.setDbPort(3306);
		audit.setUsername("Church MIS");
		audit.setComments("Offering By Cassandra");
		audit.setEvent("Process Offering");
		*/
		AuditObj audObj = new AuditObj(dbHost,dbName,dbUsername,dbPassword,dbPort,username,eventId,comments);
		return audObj;
	}

}

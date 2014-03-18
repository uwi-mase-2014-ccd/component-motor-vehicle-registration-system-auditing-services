package com.crisp.audit.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.generic.audit.AuditObj;


public class AuditDAO extends BaseDAO {

	
	public AuditDAO(AuditObj audit) {
		super(audit);
		// TODO Auto-generated constructor stub
	}
	/*
	public boolean insertEvent(AuditObj audit) throws SQLException{
			
			boolean success = true;
				
					PreparedStatement stmt = null;
				
					
					String query = "insert into event (event_id, description) VALUES (?, ?)";
				
					stmt = dbConnection.prepareStatement(query);
				
						stmt.setInt(1, audit.getEventId());
						stmt.setString(2, audit.getEvent());
						
						
						 int count = stmt.executeUpdate();
					     System.out.println(count + "event table row(s) affected");
						
					     stmt.close();
							     
				
				return success;
		}
	*/

	public boolean insertAudit(AuditObj audit) throws SQLException{
		
		boolean success = true;
	
		
				
				PreparedStatement stmt = null;
			
					String query = "insert into event_audit (username,comment,event_id) VALUES (?, ?, ?)";
				
					stmt = dbConnection.prepareStatement(query);
				
						stmt.setString(1, audit.getUsername());
						stmt.setString(2, audit.getComments());
						stmt.setInt(3, audit.getEventId());
						
						 int count = stmt.executeUpdate();
					     System.out.println(count + "event_audit table row(s) affected");
						
					     stmt.close();
				
			return success;
	}
	
	
	public void getAudits(){
		

		try {
			
			Statement stmt = dbConnection.createStatement();
						
			ResultSet RS = stmt.executeQuery("SELECT audit_id, username,comment from event_audit");
			
            while (RS.next()) {
            	
            	 
            	System.out.println("audit_id : "+RS.getString(1));
            	System.out.println("username : "+RS.getString(2));
            	System.out.println("comment : "+RS.getString(3));
            	
            	
            	                
            }
            
            RS.close();
            stmt.close();
            
			
		} catch (SQLException e) {
			
			System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState:     " + e.getSQLState());
            System.out.println("VendorError:  " + e.getErrorCode());

            
		}
		
		
		
	}//getSourceCoordinates

	
}

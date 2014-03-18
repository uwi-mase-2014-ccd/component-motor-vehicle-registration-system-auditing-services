package com.crisp.audit.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.generic.audit.AuditObj;

public class BaseDAO {

	protected Connection dbConnection;
	
	/*String host = "localhost";
	String port = "3306";
	String database = "genaudit";
	
	String username = "root";
	String password = "";*/
	
	public BaseDAO(AuditObj audit) throws SQLException {
		
		try {                        
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (Exception E) {
            System.err.println("Unable to load driver");
            E.printStackTrace();
        }
        
		String url =
            "jdbc:mysql://"+audit.getDbHost()+":"+audit.getDbPort()+"/"+audit.getDbName();
		
	
			
			dbConnection =
			    DriverManager.getConnection(
			                url,audit.getDbUsername(), audit.getDbPassword());	
            
			
		/*} catch (SQLException e) {
			
			System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState:     " + e.getSQLState());
            System.out.println("VendorError:  " + e.getErrorCode());

            
		}*/
		
	}

}

package com.crisp.audit.db;

import java.sql.SQLException;

import com.generic.audit.AuditObj;

public class TestDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		AuditObj audit = new AuditObj();
		
		audit.setDbHost("localhost");
		audit.setDbUsername("root");
		audit.setDbName("genaudit");
		audit.setDbPassword("");
		audit.setDbPort(3306);
		audit.setUsername("ariley");
		audit.setComments("Offering By ariley");
		audit.setEvent("Process Payment");
		audit.setEventId(new Integer(6));
		
		
		
		try {
			AuditDAO auditDAO = new AuditDAO(audit);
			boolean responseFlag = auditDAO.insertAudit(audit);
			//auditDAO.getAudits();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}

package com.generic.audit;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.crisp.audit.db.AuditDAO;
import com.crisp.audit.json.JsonUtil;


/**
 * Servlet implementation class Audit

 * Guthrie...... changed this

 */
@WebServlet("/Audit")
public class Audit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Audit() {
        super(); 
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//System.out.println("param server: " + (String)request.getParameter("jsondata"));
		String errMsg = "";
		JsonUtil util = new JsonUtil();
		AuditObj auditDTO = new AuditObj();
		
		boolean successFlag = true;
		
		
		try {
			
			auditDTO = util.decode((String)request.getParameter("jsondata"));
			
			AuditDAO auditDAO = new AuditDAO(auditDTO);
			
			successFlag = auditDAO.insertAudit(auditDTO);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			successFlag = false;
			errMsg = e.getMessage();
			System.out.println("SQL Exception: " + e.getMessage());
			e.printStackTrace();
		}catch (Exception e)
		{
			successFlag = false;
			errMsg = e.getMessage();
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("Audit Status: " + successFlag);
		
		String jsonResp = util.encode(auditDTO.getEventId(), successFlag, errMsg);
		
		if(successFlag)
			response.setStatus(200);
		else
			response.sendError(422,jsonResp);
		
		System.out.println("jsonResp: "+ jsonResp);
		
		// Set response content type
	      response.setContentType("text/html");
	      
	      // Actual logic goes here.
	      PrintWriter outHtml = response.getWriter();
	      
	      outHtml.println(jsonResp);
	      
	}

}

package com.common.helpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.common.hooks.Hooks;

//import com.kalibrate.step_definitions.Kalibrate_Hooks;

public class DatabaseHelper {
	
	private Hooks hooks;

	public DatabaseHelper(Hooks hooks) {
		this.hooks = hooks;
	}

	private Statement sqlDbStatement = hooks.dbStatement;
	private ReporterHelper reporterHelper = hooks.reporterHelper;
	private Connection sqlDbConn = hooks.dbConn;
		
	public ResultSet executeSQLStringWithResultSet(String sqlStatement) throws SQLException {
		
		PreparedStatement statement;
		ResultSet resultSet = null;
		
		try {
		
	        statement = sqlDbConn.prepareStatement(sqlStatement, 
					  ResultSet.TYPE_SCROLL_INSENSITIVE, 
					  ResultSet.CONCUR_READ_ONLY);
	        
	        reporterHelper.log("\tExecuting " + statement.toString());
	        reporterHelper.log("\tSQL statement: " + sqlStatement);

			statement.execute();
			resultSet = statement.getResultSet();
		}
		catch (Exception e) {
			throw e;
//			reporterHelper.customFailScriptNoHttpCheck("Exception caught: " + e.toString());
		}
		
		return resultSet;

	}

	public void executeSQLStringNoResultSet(String sqlStatement) {
		
		reporterHelper.log("\tExecuting SQL statement: " + sqlStatement);
		
		try {
			sqlDbStatement.execute(sqlStatement);
		} catch (Exception e) {
			reporterHelper.customFailScript("Exception caught: " + e.toString());
		}
	}	
        
	public void createDBConnectionAndExecuteSQLStringNoResultSet(String sqlStatement) {
		
		// Create a variable for the connection string.
		String connectionString = System.getenv("SQLSERVER_JDBC_CONNECT_STRING");
		if (StringUtils.trimToNull(connectionString) == null) 
			connectionString = Utils.getProperty("SQLSERVER_JDBC_CONNECT_STRING");
		
		reporterHelper.log("\nCreating JDBC connection using: " + connectionString);
		
		Connection tempDBConnection;
		
		try {
    		// Establish the connection.
    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		tempDBConnection = DriverManager.getConnection(connectionString);		

	        PreparedStatement statement = tempDBConnection.prepareStatement(sqlStatement);
	        
	        reporterHelper.log("\tExecuting SQL Statement: " + sqlStatement);
			statement.execute();
			
			tempDBConnection.close();
		}
		catch (Exception e) {

			if(e.toString().equals("com.microsoft.sqlserver.jdbc.SQLServerException: The event session has already been started.")) {
				System.out.println("DB SESSION already started");
				try {

					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    		tempDBConnection = DriverManager.getConnection(connectionString);		

			        PreparedStatement statement = tempDBConnection.prepareStatement(sqlStatement.replace("START", "STOP"));
			        
			        reporterHelper.log("\tExecuting SQL Statement: " + sqlStatement.replace("START", "STOP"));
					statement.execute();
					
			        statement = tempDBConnection.prepareStatement(sqlStatement);
			        
			        reporterHelper.log("\tExecuting SQL Statement: " + sqlStatement);
					statement.execute();
					
					tempDBConnection.close();
				}
				catch (Exception ee) {
					reporterHelper.customFailScript("JDBC Exception caught: " + ee.toString());
				}
			} else
				reporterHelper.customFailScript("JDBC Exception caught: " + e.toString());
		}
		
	}
	
	public void executeSQLFile(String sqlFileName, ArrayList<String> desiredPersonasUsernameList ) {

        String tempString = new String();
        StringBuffer stringBuffer = new StringBuffer();
        
        reporterHelper.log("\tExecuting SQL file: " + System.getProperty("user.dir") + "/src/test/resources/sql/" + Hooks.applicationVersionSimplified + "/" + sqlFileName);
        
        try {
			FileReader fileReader = new FileReader(new File(System.getProperty("user.dir") + "/src/test/resources/sql/" + Hooks.applicationVersionSimplified + "/" + sqlFileName));
	
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	
	        while((tempString = bufferedReader.readLine()) != null)
	        	stringBuffer.append(tempString.trim() + " ");
	
	        bufferedReader.close();
	        fileReader.close();
		}
		catch (Exception e) {
			reporterHelper.customFailScript("Exception caught: " + e.toString());
		}
        
        
		try {
	        PreparedStatement statement = sqlDbConn.prepareStatement(stringBuffer.toString());
	        
			for (int j = 0; j < desiredPersonasUsernameList.size(); j++) {
				        
		        
		        String dbUserName = desiredPersonasUsernameList.get(j);
		        
//		        dbUserName = dbUserName.replaceAll("\\\\", "\\\\\\\\");
				
				reporterHelper.log("\tSetting parameter " + j + " to: " + dbUserName);
				
		        statement.setString(1, dbUserName);
		        reporterHelper.log("\tExecuting SQL File:" + statement.toString());
		        reporterHelper.log("\tSQL File Contents: " + stringBuffer.toString());
		        
				statement.execute();
				
				reporterHelper.log("\tExecuting SQL File success");
			}
			
		}
		catch (Exception e) {
			reporterHelper.customFailScript("Exception caught: " + e.toString());
		}

	}

	public void printResultSet(ResultSet resultSet) {
		
		ResultSetMetaData rsmd;
		
		try {
			
			rsmd = resultSet.getMetaData();
			int numberOfColumns = rsmd.getColumnCount();
			
			for (int i = 1; i <= numberOfColumns; i++) {
		        if (i > 1) System.out.print(",");
		        String columnName = rsmd.getColumnName(i);
		        System.out.print(columnName);
		    }
			System.out.flush();

			while (resultSet.next()) {

				for (int i = 1; i <= numberOfColumns; i++) {
					if (i > 1) System.out.print(",");
					String columnValue = resultSet.getString(i);
					System.out.print(columnValue);
		        }
		        System.out.flush();  
			}

		} catch (Exception e) {
			reporterHelper.customFailScript("Exception caught in method printResultSet: " + e);
		}
	}

}

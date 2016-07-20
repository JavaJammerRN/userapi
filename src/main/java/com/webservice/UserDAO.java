package com.webservice;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class UserDAO {

	public static User getUserDataByUsername(String userInfo){
		User userTemp=new User(userInfo);
		if(userInfo!=""){
			Connection connectionDB=establishConnection();
			if(connectionDB!=null){
				try{
					Statement stmt = connectionDB.createStatement();
					//The query can be update query or can be select query
					String query = "select * from user where userID=68";
					boolean status = stmt.execute(query);
					if(status){
						ResultSet rs = stmt.getResultSet();
						while(rs.next()){
							userTemp.setUserID((Integer.parseInt(rs.getString("userID"))));
							userTemp.setForename(rs.getString("forename"));
							userTemp.setSurname(rs.getString("surname"));
						}
						rs.close();
						return userTemp;
					}
				}
				catch(Exception e){}
			}
		}
		return userTemp;
	}

	private static Connection establishConnection(){
		Connection conn = null;
		try {
			// The newInstance() call is a work around for some broken Java implementations
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hotdesk_db?" +"user=hotdesk&password=hotdesk");
		} catch (Exception error) {
			System.err.println("Could not establish a connection with the DataBase! "+error);
		}
		return conn;
	}
}

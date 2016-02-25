package org.jitu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CountryLanguageDao {

	String SQL_getAll = "Select CountryCode,Language,Percentage from countrylanguage";
	String SQL_find = "Select Language from countrylanguage where CountryCode=";
	
	public CountryLanguageDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<?> getAllCountryLanguage(){
		Connection con = DBConnection.getInstance(); 
		List<CountryLanguage> countryLanguageList = new ArrayList<CountryLanguage>();
		try {
			Statement stmt   = con.createStatement();
			ResultSet rs     = stmt.executeQuery(SQL_getAll);
			while(rs.next()){
				CountryLanguage ct = new CountryLanguage();
				ct.setCountryCode(rs.getString(1));
				ct.setLanguage(rs.getString(2));
				//ct.setOffical(rs.getString(columnIndex));
				ct.setPercentage(rs.getString(3));
				countryLanguageList.add(ct);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return countryLanguageList;
		
	}
	
	public String findCountryLanguage(String countrycode){
		Connection con = DBConnection.getInstance(); 
		String language = null;
		
		try {
			Statement stmt   = con.createStatement();
			String SQL = SQL_find +"'"+countrycode+"'";
			System.out.println("SQL:"+SQL);
			ResultSet rs     = stmt.executeQuery(SQL_find +"'"+countrycode+"'");
			while(rs.next()){
				language = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return language;
	}

	
}

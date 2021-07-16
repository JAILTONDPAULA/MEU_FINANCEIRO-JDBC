package dataBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DataBase {
	private static Connection conn;
	
	public static Connection connect() {
		try {
			if(conn == null) {
				Properties configuration = configuration();
				conn = DriverManager.getConnection(configuration.getProperty("url"));
			}
			
			return conn;
		}catch(SQLException error) {
			throw new ExceptionDataBase(error.getMessage());
		}		
	}
	
	public static void closeConnect() {
		try {
			if(conn != null) {
				conn.close();
			}
		}catch(SQLException error){
			throw new ExceptionDataBase(error.getMessage());
		}
	}
	
	public static void closeResultSet(ResultSet obj) {
		try {
			obj.close();
		}catch(SQLException error) {
			throw new ExceptionDataBase(error.getMessage());
		}
	}
	
	public static void closePreparedStatement(PreparedStatement obj) {
		try {
			obj.close();
		}catch(SQLException error) {
			throw new ExceptionDataBase(error.getMessage());
		}
	}

	
	private static Properties configuration() {
		try(FileInputStream file = new FileInputStream("DataBase.properties")){
			Properties configuration = new Properties();
			configuration.load(file);
			return configuration;
		}catch(IOException error) {
			throw new ExceptionDataBase(error.getMessage());
		}
	}

}

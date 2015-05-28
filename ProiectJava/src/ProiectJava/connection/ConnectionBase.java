package ProiectJava.connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import util.Util;

public class ConnectionBase {
	private Connection sqlConnection;
	private static ConnectionBase connect = null;
	public static synchronized ConnectionBase getInstance(){
		if(connect == null){
			connect = new ConnectionBase();
		}
		return connect;
			
	}
	public boolean connectionValid(String angPass){
		boolean bRet = true; //return
		if(sqlConnection != null){
			try{
				if(!sqlConnection.isClosed())
					sqlConnection.close(); //inchidem conexiunea ca sa pornim una noua
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		Map prop = Util.loadFile(); //
		
		if(!angPass.isEmpty() && angPass.equals((String)prop.get("pin"))){
			String driver = "com.mysql.jdbc.Driver";
			//String url = "jdbc:mysql://192.168.29.200:3306/i_nicula";//legatura noastra la baza de date
			
			String url = (String) prop.get("url");
			Driver newDriver; 	
			try{
				newDriver = (Driver) Class.forName(driver).newInstance();;
				DriverManager.registerDriver(newDriver);
				sqlConnection = DriverManager.getConnection(url,(String)prop.get("user"), (String) prop.get("pass"));
				sqlConnection.setAutoCommit(false);
			} catch(ClassNotFoundException e){
				e.printStackTrace();
			} catch(SQLException e){
				System.out.println("failed");//nu exista baza de date cu numele respectiv
				bRet = false;
			} catch(InstantiationException e){
				e.printStackTrace();
			} catch(IllegalAccessException e){
				e.printStackTrace();
			}
			
		} else {
			bRet = false;
		}
		return bRet;
	}
	//metoda de acces la conexiune;
	public Connection getConnection(){
		return sqlConnection;
	}
	
}

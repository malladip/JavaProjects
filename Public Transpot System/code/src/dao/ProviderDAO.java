package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import domain.Provider;

public class ProviderDAO {

	private Connection conn;
	private DatabaseManager dbm;
	
	public ProviderDAO(Connection conn, DatabaseManager dbm) {
		super();
		this.conn = conn;
		this.dbm = dbm;
	}

	public ProviderDAO() {
		super();
	}
	
	public Provider findProviderByUserName(String username){

		Provider p = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		DatabaseManager manager = new DatabaseManager();
		
		String query = "select * from provider where userid = ?";
		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1,username);
			
			result = pstmt.executeQuery();
			
			p = new Provider();
			while(result.next()){
				p.setId(result.getInt(1));
				p.setName(result.getString(2));
				p.setUserid(result.getString(3));
				p.setEmail(result.getString(4));
				p.setPhoneNumber(result.getString(5));
				p.setPassword(result.getString(6));
				p.setAddress(manager.findAddressById(result.getInt(7)));
				p.getTypeId(manager.findTransportTypeById(result.getInt(8)));
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	
	
	public Provider findProviderByUserNamePassword(String username,String password){

		Provider p = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		DatabaseManager manager = new DatabaseManager();
		
		String query = "select * from provider where userid = ? and password = ?";
		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1,username);
			pstmt.setString(2,password);
			
			result = pstmt.executeQuery();
			while(result.next()){
				p = new Provider();
				p.setId(result.getInt(1));
				p.setName(result.getString(2));
				p.setUserid(result.getString(3));
				p.setEmail(result.getString(4));
				p.setPhoneNumber(result.getString(5));
				p.setPassword(result.getString(6));
				p.setAddress(manager.findAddressById(result.getInt(7)));
				p.getTypeId(manager.findTransportTypeById(result.getInt(8)));
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisteredUserDAO {
	private Connection conn;
	private DatabaseManager dbm;

	public RegisteredUserDAO(Connection conn, DatabaseManager dbm) {
		super();
		this.conn = conn;
		this.dbm = dbm;
	}

	public ResultSet findByUserNamePassword(String userid,String password){

		PreparedStatement pstmt = null;
		ResultSet result = null;
		
		String query = "select * from registereduser where userid = ? and password = ?";
		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1,userid);
			pstmt.setString(2,password);
			
			result = pstmt.executeQuery();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public ResultSet findByUserName(String username){

		PreparedStatement pstmt = null;
		ResultSet result = null;
		String query = "select * from registereduser where userid = ?";

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1,username);

			result = pstmt.executeQuery();

		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public ResultSet insert(String userID, String password,String name,String email, String phoneNumber,int addressID){

		PreparedStatement pstmt = null;
		ResultSet result = null;
		String query = "insert into registereduser (userid,password,name,email,phoneNumber,addressId)"
				+ "values(?,?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);

			pstmt.setString(1,userID);
			pstmt.setString(2,password);
			pstmt.setString(3,name);
			pstmt.setString(4,email);
			pstmt.setString(5,phoneNumber);
			pstmt.setInt(6,addressID);			

			pstmt.executeUpdate();

			result = pstmt.getGeneratedKeys();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
	
	
	public void update(String userID, String name,String email, String phoneNumber) throws SQLException{

		PreparedStatement pstmt = null;
		String query = "update registereduser set name=?, email=?, phoneNumber= ? where userid = ?";

			pstmt = conn.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);

			pstmt.setString(1,name);
			pstmt.setString(2,email);
			pstmt.setString(3,phoneNumber);
			pstmt.setString(4,userID);			

			pstmt.executeUpdate();

	}
	
}

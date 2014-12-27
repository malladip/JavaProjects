package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Address;

public class AddressDAO {
	private Connection conn;
	private DatabaseManager dbm;

	public AddressDAO(Connection conn, DatabaseManager dbm) {
		super();
		this.conn = conn;
		this.dbm = dbm;
	}

	public void update(int id,int aptno, String street,String city,String state, int pincode) throws SQLException{

		int generatedId = 0;

		String query = "update Address set aptno = ?, street = ?, city= ?, state= ?,pincode= ? where id = ?";

		PreparedStatement pstmt = conn.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);

		pstmt.setInt(1,aptno);
		pstmt.setString(2,street);
		pstmt.setString(3,city);
		pstmt.setString(4,state);
		pstmt.setInt(5,pincode);			
		pstmt.setInt(6,id);			

		pstmt.executeUpdate();

	}

	public Address findById(int id){
		String query = "select * from Address where id = ?";
		ResultSet r = null;
		Address a = null;

		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);

			pstmt.setInt(1,id);

			r = pstmt.executeQuery();

			a= new Address();

			while(r.next()){
				a.setId(r.getInt(1));
				a.setAptno(r.getInt(2));
				a.setStreet(r.getString(3));
				a.setCity(r.getString(4));
				a.setState(r.getString(5));
				a.setPincode(r.getInt(6));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return a;
	}

	public int insert(int aptno, String street,String city,String state, int pincode){
		
		int generatedId = 0;
		
		String query = "insert into Address(aptno,street,city,state,pincode)"
				+ "values(?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
			
			pstmt.setInt(1,aptno);
			pstmt.setString(2,street);
			pstmt.setString(3,city);
			pstmt.setString(4,state);
			pstmt.setInt(5,pincode);			

			pstmt.executeUpdate();

			ResultSet generatedKeys = pstmt.getGeneratedKeys();
			generatedKeys.next();
			if(generatedKeys != null){
				generatedId = generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
		}

		return generatedId;
	}
}

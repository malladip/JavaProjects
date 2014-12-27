package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.TransportType;

public class TransportTypeDAO {

	private Connection conn;
	private DatabaseManager dbm;
	
	public TransportTypeDAO() {
		super();
	}

	public TransportTypeDAO(Connection conn, DatabaseManager dbm) {
		super();
		this.conn = conn;
		this.dbm = dbm;
	}

	public TransportType findTransportType(int id){
		
		TransportType tt = new TransportType();
		PreparedStatement pstmt = null;
		ResultSet result = null;
		
		String query = "select * from transporttype where id = ?";

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1,id);
			result = pstmt.executeQuery();
			while (result.next()){
				
				tt.setId(result.getInt(1));
				System.out.println(result.getInt(1));
				tt.setName(result.getString(2));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tt;
	}
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import domain.Bookmark;

public class BookmarkDAO {
	private Connection conn;
	private DatabaseManager dbm;

	public BookmarkDAO(Connection conn, DatabaseManager dbm) {
		super();
		this.conn = conn;
		this.dbm = dbm;
	}

	public void insert(int transportId,int userId) throws SQLException{
		System.out.println(transportId);
		System.out.println(userId);
		String query = "insert into Bookmark values (?,?)";

		PreparedStatement pstmt = conn.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);

		pstmt.setInt(1,transportId);
		pstmt.setInt(2,userId);

		pstmt.executeUpdate();

	}

	public ResultSet findBookmark(int transportId,int userId){
		ResultSet r = null;

		String query = "select * from Bookmark where transportId = ? and registeredUserId = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);


			pstmt.setInt(1,transportId);

			pstmt.setInt(2,userId);

			r = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}


	public ResultSet findBookmarkByUserID(int userId){
		
		ResultSet r = null;

		String query = "select * from Bookmark where registeredUserId = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);

			pstmt.setInt(1,userId);

			r = pstmt.executeQuery();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}




}

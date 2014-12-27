package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import domain.Transport;
import domain.TransportType;

public class TransportDAO {
	private Connection conn;
	private DatabaseManager dbm;

	public TransportDAO() {
		super();
	}

	public TransportDAO(Connection conn, DatabaseManager dbm) {
		super();
		this.conn = conn;
		this.dbm = dbm;
	}

	public int deleteByNumbers(List<Integer> numbers){
		int count = 0;
		String query = "delete from transport where number = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
			for (int number : numbers){
				pstmt.setInt(1,number);
				int number_of_effected = pstmt.executeUpdate();
				count += number_of_effected;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
		}

		return count;
	}

	public int update(Transport t){
		int count = 0;
		String query = "update transport set number = ?,source=?,destination=?,originTime=? where id = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1,t.getNumber());
			pstmt.setString(2,t.getSource());
			pstmt.setString(3,t.getDestination());
			pstmt.setTime(4,t.getOriginTime());
			pstmt.setInt(5,t.getId());

			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
		}

		return count;
	}

	public int insert(int type_id, int number,String source,String destination,Time originTime){

		int generatedId = 0;

		String query = "insert into Transport(type_id,number,source,destination,originTime)"
				+ "values(?,?,?,?,?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);

			pstmt.setInt(1,type_id);
			pstmt.setInt(2,number);
			pstmt.setString(3,source);
			pstmt.setString(4,destination);
			pstmt.setTime(5,originTime);			

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


	public Transport findTransportById(int id){
		Transport t = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;

		String query = "select * from transport where id = ?";
		try {
			pstmt = conn.prepareStatement(query);

			t = new Transport();
			pstmt.setInt(1,id);
			result = pstmt.executeQuery();
			while(result.next()){
				t.setId(result.getInt(1));

				TransportTypeDAO ttd = new TransportTypeDAO(conn,dbm);

				t.setType(ttd.findTransportType(result.getInt(2)));

				t.setNumber(result.getInt(3));
				t.setSource(result.getString(4));
				t.setDestination(result.getString(5));
				t.setOriginTime(result.getTime(6));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return t;
	}

	public Transport findTransportByNum(int number){
		Transport t = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;

		String query = "select * from transport where number = ?";
		try {
			pstmt = conn.prepareStatement(query);

			t = new Transport();
			pstmt.setInt(1,number);
			result = pstmt.executeQuery();
			while(result.next()){
				t.setId(result.getInt(1));

				TransportTypeDAO ttd = new TransportTypeDAO(conn,dbm);

				t.setType(ttd.findTransportType(result.getInt(2)));

				t.setNumber(result.getInt(3));
				t.setSource(result.getString(4));
				t.setDestination(result.getString(5));
				t.setOriginTime(result.getTime(6));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return t;
	}

	public List<Transport> findTransportsByFrom(String from, int type){
		PreparedStatement pstmt = null;
		ResultSet result = null;
		List<Transport> transports = null;

		String query = "select * from transport where source = ? and type_id = ?";
		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1,from);
			pstmt.setInt(2,type);

			result = pstmt.executeQuery();

			transports = new ArrayList<Transport>();

			while (result.next()) {
				Transport t = new Transport();
				t.setId(result.getInt(1));

				TransportTypeDAO ttd = new TransportTypeDAO(conn,dbm);

				t.setType(ttd.findTransportType(result.getInt(2)));

				t.setNumber(result.getInt(3));
				t.setSource(result.getString(4));
				t.setDestination(result.getString(5));

				t.setOriginTime(result.getTime(6));

				transports.add(t);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transports;
	}

	public List<Transport> findTransportsByTo(String to, int type){
		PreparedStatement pstmt = null;
		ResultSet result = null;
		List<Transport> transports = null;

		String query = "select * from transport where destination = ? and type_id = ?";
		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1,to);
			pstmt.setInt(2,type);

			result = pstmt.executeQuery();

			transports = new ArrayList<Transport>();

			while (result.next()) {
				Transport t = new Transport();
				t.setId(result.getInt(1));

				TransportTypeDAO ttd = new TransportTypeDAO(conn,dbm);

				System.out.println(result.getInt(2));
				t.setType(ttd.findTransportType(result.getInt(2)));

				t.setNumber(result.getInt(3));
				t.setSource(result.getString(4));
				t.setDestination(result.getString(5));

				t.setOriginTime(result.getTime(6));

				transports.add(t);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transports;
	}

	public List<Transport> findTransportsByType(int type){
		PreparedStatement pstmt = null;
		ResultSet result = null;
		List<Transport> transports = null;

		String query = "select * from transport where type_id = ?";
		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1,type);

			result = pstmt.executeQuery();

			transports = new ArrayList<Transport>();

			while (result.next()) {
				Transport t = new Transport();
				t.setId(result.getInt(1));
				TransportTypeDAO ttd = new TransportTypeDAO(conn,dbm);

				System.out.println(result.getInt(2));
				t.setType(ttd.findTransportType(result.getInt(2)));

				t.setNumber(result.getInt(3));
				t.setSource(result.getString(4));
				t.setDestination(result.getString(5));

				t.setOriginTime(result.getTime(6));

				transports.add(t);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transports;
	}

	public List<Transport> findTransports(String from, String to, int type){

		PreparedStatement pstmt = null;
		ResultSet result = null;
		List<Transport> transports = null;

		String query = "select * from transport where source = ? and destination = ? and type_id = ?";
		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1,from);
			pstmt.setString(2,to);
			pstmt.setInt(3,type);

			result = pstmt.executeQuery();

			transports = new ArrayList<Transport>();

			while (result.next()) {
				Transport t = new Transport();
				t.setId(result.getInt(1));

				TransportTypeDAO ttd = new TransportTypeDAO(conn,dbm);

				System.out.println(result.getInt(2));
				t.setType(ttd.findTransportType(result.getInt(2)));

				t.setNumber(result.getInt(3));
				t.setSource(result.getString(4));
				t.setDestination(result.getString(5));

				t.setOriginTime(result.getTime(6));

				transports.add(t);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transports;
	}
}

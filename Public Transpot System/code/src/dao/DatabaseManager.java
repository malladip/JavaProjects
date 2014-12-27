package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.Session;

import domain.Address;
import domain.Bookmark;
import domain.Provider;
import domain.RegisteredUser;
import domain.Transport;
import domain.TransportType;

public class DatabaseManager {

	private Connection con;
	private RegisteredUserDAO registeredUserDAO;
	private AddressDAO addressDAO;
	private TransportDAO transportDAO;
	private TransportTypeDAO transportTypeDAO;
	private BookmarkDAO bookmarkDAO;
	private ProviderDAO providerDAO;

	public DatabaseManager() {
		try {
			String url = "jdbc:mysql://localhost:3306/project";

			Class.forName("com.mysql.jdbc.Driver"); 
			con=DriverManager.getConnection(url,"root", "prashant92");

			registeredUserDAO= new RegisteredUserDAO(con, this);
			addressDAO = new AddressDAO(con, this);
			transportDAO = new TransportDAO(con,this);
			transportTypeDAO = new TransportTypeDAO(con,this);
			bookmarkDAO = new BookmarkDAO(con,this);
			providerDAO = new ProviderDAO(con,this);
		}
		catch(SQLException e) {
			throw new RuntimeException("cannot connect to database", e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("cannot connect to database", e);
		}
	}
	
	public int updateTransport(int id, int type,int number,String source,String destination, Time originTime){
		
		Transport t = new Transport();
		
		t.setId(id);
		
		TransportType tt = new TransportType();
		tt= transportTypeDAO.findTransportType(type);
		t.setType(tt);
		
		t.setNumber(number);
		t.setSource(source);
		t.setDestination(destination);
		t.setOriginTime(originTime);
		
		return transportDAO.update(t);
	}

	public Transport findTransportByNum(int num){
		return transportDAO.findTransportByNum(num);
	}
	public int deleteTransportsByNumbers(List<Integer> numbers){
		int effected_rows = transportDAO.deleteByNumbers(numbers);
		return effected_rows;
	}

	public int insertTransport(int type,int num,String source,String destination,Time time){
		return transportDAO.insert(type,num,source,destination,time);
	}

	public TransportType findTransportTypeOfProviderByUserName(String username){
		Provider p =providerDAO.findProviderByUserName(username);
		System.out.println(p.getId());
		return p.getTypeId();
	}

	public Provider findProviderByUserName(String username){
		return providerDAO.findProviderByUserName(username);
	}

	public List<Transport> findBookmarkTransportsOfUser(String username) throws SQLException{
		RegisteredUser r = new RegisteredUser();

		List<Transport> transports = new ArrayList<Transport>();


		ResultSet regUser = registeredUserDAO.findByUserName(username);
		while(regUser.next()){
			r.setId(regUser.getInt(1));			
			r.setUserid(regUser.getString(2));
		}

		List<Bookmark> bookmarks = findBookmarkByUserID(r.getId(),username);
		for(Bookmark b : bookmarks){
			Transport t = new Transport();

			t = b.getTransport();
			transports.add(t);
		}

		return transports;
	}

	public List<Bookmark> findBookmarkByUserID(int userId, String username) throws SQLException{

		List<Bookmark> bookmarks = new ArrayList<Bookmark>();

		ResultSet rs = bookmarkDAO.findBookmarkByUserID(userId);

		while(rs.next()){
			Bookmark bookmark = new Bookmark();

			bookmark.setTransport(transportDAO.findTransportById(rs.getInt(1)));

			ResultSet users = registeredUserDAO.findByUserName(username);
			RegisteredUser user= new RegisteredUser();   
			while(users.next()){
				user.setId(users.getInt(1));
				user.setUserid(users.getString(2));
			}
			bookmark.setRegisteredUser(user);
			bookmarks.add(bookmark);	
		}

		return bookmarks;
	}

	public void insertBookmark(int tnum, String username) throws SQLException{

		Transport t = transportDAO.findTransportByNum(tnum);
		RegisteredUser r = new RegisteredUser();

		ResultSet regUser = registeredUserDAO.findByUserName(username);
		while(regUser.next()){
			r.setId(regUser.getInt(1));			
			r.setUserid(regUser.getString(2));
		}

		bookmarkDAO.insert(t.getId(),r.getId());
	}

	public Bookmark findBookmark(int tnum, String username) throws SQLException{

		Bookmark b = null;
		ResultSet rs = null; 
		Transport t = new Transport();

		RegisteredUser r = new RegisteredUser();

		t = transportDAO.findTransportByNum(tnum);

		ResultSet regUser = registeredUserDAO.findByUserName(username);
		while(regUser.next()){
			r.setId(regUser.getInt(1));			
			r.setUserid(regUser.getString(2));
		}

		rs = bookmarkDAO.findBookmark(t.getId(),r.getId());

		while(rs.next()){
			b = new Bookmark();
			b.setTransport(t);
			b.setRegisteredUser(r);
		}

		return b;
	}


	public ResultSet registerUser(Address a,RegisteredUser r){

		ResultSet inserted = null;

		ResultSet existingUsers = null;
		existingUsers = registeredUserDAO.findByUserName(r.getUserid());

		try {

			if(!existingUsers.next()){

				int id = addressDAO.insert(a.getAptno(),a.getStreet(),a.getCity(),a.getState(),a.getPincode());

				if(id != 0){
					inserted = registeredUserDAO.insert(r.getUserid(),r.getPassword(),r.getName(),r.getEmail(),r.getPhoneNumber(),id);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inserted;

	}

	public ResultSet loginUser(String username,String password){

		return  registeredUserDAO.findByUserNamePassword(username,password);
	}

	public Provider loginProvider(String username,String password){

		return  providerDAO.findProviderByUserNamePassword(username,password);
	}

	public List<Transport> searchedTransports(String from, String to, int type){
		return transportDAO.findTransports(from,to,type);
	}
	public List<Transport> searchedTransportsByFrom(String from,int type){
		return transportDAO.findTransportsByFrom(from,type);
	}
	public List<Transport> searchedTransportsByTo(String to, int type){
		return transportDAO.findTransportsByTo(to,type);
	}
	public List<Transport> searchedTransportsByType(int type){
		return transportDAO.findTransportsByType(type);
	}

	public void updateUserDetails(Address a,RegisteredUser r) throws SQLException{

		registeredUserDAO.update(r.getUserid(),r.getName(),r.getEmail(),r.getPhoneNumber());

		ResultSet rs = registeredUserDAO.findByUserName(r.getUserid());

		while(rs.next())
			addressDAO.update(rs.getInt(7),a.getAptno(),a.getStreet(),a.getCity(),a.getState(),a.getPincode());
	}


	public RegisteredUser findRegisteredUserByUserName(String username){

		RegisteredUser ru = null;
		Address a = null;
		ResultSet rs = registeredUserDAO.findByUserName(username);

		try {
			while (rs.next()){
				ru = new RegisteredUser();
				ru.setId(rs.getInt(1));
				ru.setUserid(rs.getString(2));
				ru.setPassword(rs.getString(3));
				ru.setName(rs.getString(4));
				ru.setEmail(rs.getString(5));
				ru.setPhoneNumber(rs.getString(6));

				a = addressDAO.findById(rs.getInt(7));

				ru.setAddress(a);			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ru;
	}

	public Address findAddressById(int id){
		return addressDAO.findById(id);
	}

	public TransportType findTransportTypeById(int id){
		return transportTypeDAO.findTransportType(id);
	}

	public void close() {
		try {
			con.close();
		}
		catch(SQLException e) {
			throw new RuntimeException("cannot close database", e);
		}
	}


}

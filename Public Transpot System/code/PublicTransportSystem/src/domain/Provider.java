package domain;

public class Provider {

	private int id;
	private String name;
	private String userid;
	private String email;
	private String phoneNumber;
	private String password;
	private Address address;
	private TransportType typeId;

	public Provider() {
		super();
	}
	
	public Provider(String name, String userid, String email,
			String phoneNumber, String password, Address address,
			TransportType typeId) {
		super();
		this.name = name;
		this.userid = userid;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.address = address;
		this.typeId = typeId;
	}

	public Provider(int id, String name, String userid, String email,
			String phoneNumber, String password, Address address,
			TransportType typeId) {
		super();
		this.id = id;
		this.name = name;
		this.userid = userid;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.address = address;
		this.typeId = typeId;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public TransportType getTypeId(){
		return typeId;
	}
	public void getTypeId(TransportType typeId){
		this.typeId = typeId;
	}

}

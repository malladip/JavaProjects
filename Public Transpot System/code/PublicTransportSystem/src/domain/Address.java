package domain;

public class Address {

	private int id;
	private int aptno;
	private String street;
	private String city;
	private String state;
	private int pincode;
	
	public Address() {
		super();
	}

	public Address(int aptno, String street, String city, String state,
			int pincode) {
		super();
		this.aptno = aptno;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public Address(int id, int aptno, String street, String city, String state,
			int pincode) {
		super();
		this.id = id;
		this.aptno = aptno;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAptno() {
		return aptno;
	}
	public void setAptno(int aptno) {
		this.aptno = aptno;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
}

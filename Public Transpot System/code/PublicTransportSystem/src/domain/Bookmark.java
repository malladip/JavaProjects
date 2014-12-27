package domain;

public class Bookmark {

	private Transport transport;
	private RegisteredUser registeredUser;
	
	public Bookmark() {
		super();
	}

	public Bookmark(Transport transport, RegisteredUser registeredUser) {
		super();
		this.transport = transport;
		this.registeredUser = registeredUser;
	}
	
	public Transport getTransport() {
		return transport;
	}
	public void setTransport(Transport transport) {
		this.transport = transport;
	}
	public RegisteredUser getRegisteredUser() {
		return registeredUser;
	}
	public void setRegisteredUser(RegisteredUser registeredUser) {
		this.registeredUser = registeredUser;
	}
	
	
}

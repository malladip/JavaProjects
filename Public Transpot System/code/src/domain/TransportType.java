package domain;

public class TransportType {

	private int id;
	private String name;
	
	public TransportType() {
		super();
	}
	public TransportType(String name) {
		super();
		this.name = name;
	}
	public TransportType(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
}

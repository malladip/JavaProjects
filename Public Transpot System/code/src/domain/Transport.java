package domain;

import java.sql.Time;

public class Transport {

	private int id;
	private TransportType type;
	private int number;
	private String source;
	private String destination;
	private Time originTime;
	
	public Transport() {
		super();
	}
	public Transport(TransportType type, int number, String source,
			String destination, Time originTime) {
		super();
		this.type = type;
		this.number = number;
		this.source = source;
		this.destination = destination;
		this.originTime = originTime;
	}
	public Transport(int id, TransportType type, int number, String source,
			String destination, Time originTime) {
		super();
		this.id = id;
		this.type = type;
		this.number = number;
		this.source = source;
		this.destination = destination;
		this.originTime = originTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TransportType getType() {
		return type;
	}
	public void setType(TransportType type) {
		this.type = type;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Time getOriginTime() {
		return originTime;
	}
	public void setOriginTime(Time originTime) {
		this.originTime = originTime;
	}
	
	
	
}

package kr.message.model.vo;

public class Message {
	private int seq;
	private String name;
	private String message;
	private String writedate;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	public Message(int seq, String name, String message, String writedate) {
		super();
		this.seq = seq;
		this.name = name;
		this.message = message;
		this.writedate = writedate;
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

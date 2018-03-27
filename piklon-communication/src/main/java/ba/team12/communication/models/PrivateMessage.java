package ba.team12.communication.models;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="private_messages")
public class PrivateMessage {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pm_id")
	private Long pmId;

	@Column(name="sender_id")
	private Long senderId;

	@Column(name="recepient_id")
	private Long recepientId;
		
	private String text;
	
	// new GregorianCalendar(2018, 3, 15).getTime()
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	public Long getPmId() {
		return pmId;
	}

	public void setPmId(Long pmId) {
		this.pmId = pmId;
	}

	public Long getSenderId() {
		return senderId;
	}

	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}

	public Long getRecepientId() {
		return recepientId;
	}

	public void setRecepientId(Long recepientId) {
		this.recepientId = recepientId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

    public PrivateMessage() {}

    public PrivateMessage(Long sid, Long rid, String txt, Date tstp) {
    	senderId = sid;
    	recepientId = rid;
    	text = txt;
    	timestamp = tstp;
    }
}

package ba.team12;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;

@Entity
@Table(name="private_messages")
public class PrivateMessage {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long pmId;
	
	private Long senderId;

	private Long recepientId;
		
	private String text;
	
	// new GregorianCalendar(2018, 3, 15).getTime()
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

    protected PrivateMessage () {}

    public PrivateMessage(Long sid, Long rid, String txt, Date tstp) {
    	senderId = sid;
    	recepientId = rid;
    	text = txt;
    	timestamp = tstp;
    }

    @Override
    public String toString() {
        return String.format(
                "PM[commentId=%d, text='%d']",
                pmId, text);
    }

}

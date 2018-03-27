package ba.team12.communication.models;

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
@Table(name="comments")
public class Comment {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long commentId;
	
	@ManyToOne
	@JoinColumn
	private Comment parentComment;
	
	private String text;
	
	// new GregorianCalendar().getTime()
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;
	
	private Long userId;
	
	private Long listingId;

    protected Comment () {}

    public Comment(Comment parent, String text, Date tstp, Long uid, Long lid) {
    	parentComment = parent;
    	this.text = text;
    	timestamp = tstp;
    	userId = uid;
    	listingId = lid;
    }

    @Override
    public String toString() {
        return String.format(
                "Comment[commentId=%d, text='%d']",
                commentId, text);
    }
}

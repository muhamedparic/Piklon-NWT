package ba.team12;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ratings")
public class Rating {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long ratingId;
	
	private Long userId;
	
	private Long sellerId;
	
	private int rating;
	
	private String ratingDesc; 

    protected Rating () {}

    public Rating(Long uid, Long sid, int r, String desc) {
        userId = uid;
        sellerId = sid;
        rating = r;
        ratingDesc = desc;
    }

    @Override
    public String toString() {
        return String.format(
                "Rating[ratingId=%d, rating='%d', ratingDesc='%s']",
                ratingId, rating, ratingDesc);
    }
}

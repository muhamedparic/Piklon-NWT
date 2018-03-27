package ba.team12.communication.models;

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

    public Long getRatingId() {
        return ratingId;
    }

    public void setRatingId(Long ratingId) {
        this.ratingId = ratingId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getRatingDesc() {
        return ratingDesc;
    }

    public void setRatingDesc(String ratingDesc) {
        this.ratingDesc = ratingDesc;
    }

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

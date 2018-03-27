package ba.team12.articles.models;

import ba.team12.articles.Condition;

import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "articles")
public class Article {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(length = 64)
	private String name;
	
	@Column
	private int price;
	
	@Column(name = "article_condition")
	@Enumerated(EnumType.STRING)
	private Condition condition;
	
	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@Column(name = "creation_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationTime;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "article_id")
	private List<Image> images;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "article_id")
	private List<ExtraInfo> extraInfo;

	public Article() {
	}

	public Article(Long userId, String name, int price, Condition condition, Location location, Category category, Date creationTime, List<Image> images, List<ExtraInfo> extraInfo) {

		this.userId = userId;
		this.name = name;
		this.price = price;
		this.condition = condition;
		this.location = location;
		this.category = category;
		this.creationTime = creationTime;
		this.images = images;
		this.extraInfo = extraInfo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images  = images;
	}

	public Condition getCondition() {
		return this.condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public List<ExtraInfo> getExtraInfo() {
		return extraInfo;
	}

	public void setExtraInfo(List<ExtraInfo> extraInfo) {
		this.extraInfo = extraInfo;
	}
}

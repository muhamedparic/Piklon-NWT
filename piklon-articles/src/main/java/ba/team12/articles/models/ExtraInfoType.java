package ba.team12.articles.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "extra_info_types")
public class ExtraInfoType {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 30)
	@Size(min = 2, message = "Name too short")
	private String name;

	@ManyToOne
	@JoinColumn(name = "category_id")
	@JsonIgnore // Temporary fix!
	private Category category;

	public ExtraInfoType() {
	}

	public ExtraInfoType(String name, Category category) {
		this.name = name;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}

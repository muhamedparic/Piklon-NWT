package ba.team12.articles.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 30)
	private String name;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private List<ExtraInfoType> extraInfoTypes;
	
	public Category() {
	}

	public Category(String name, List<ExtraInfoType> extraInfoTypes) {
		this.name = name;
		this.extraInfoTypes = extraInfoTypes;
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

	public List<ExtraInfoType> getExtraInfoTypes() {
		return extraInfoTypes;
	}

	public void setExtraInfoTypes(List<ExtraInfoType> extraInfoTypes) {
		this.extraInfoTypes = extraInfoTypes;
	}
}

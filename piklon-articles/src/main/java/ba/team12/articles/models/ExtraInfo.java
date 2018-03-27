package ba.team12.articles.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "extra_info")
public class ExtraInfo {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "extra_info_type_id")
	private ExtraInfoType extraInfoType;
	
	@Column(length = 30)
	private String value;

	public ExtraInfo() {
	}

	public ExtraInfo(ExtraInfoType extraInfoType, String value) {
		this.extraInfoType = extraInfoType;
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ExtraInfoType getExtraInfoType() {
		return extraInfoType;
	}

	public void setExtraInfoType(ExtraInfoType extraInfoType) {
		this.extraInfoType = extraInfoType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}

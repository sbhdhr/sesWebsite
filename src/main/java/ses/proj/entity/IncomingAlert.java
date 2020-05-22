package ses.proj.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class IncomingAlert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Desc cannot be null")
	private String description;

	// @JsonFormat(pattern = "dd-mm-yyyy HH:mm:ss", timezone =
	// JsonFormat.DEFAULT_TIMEZONE)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "IST")
	@CreationTimestamp
	private Date createdAt;

	public IncomingAlert() {
	}

	public IncomingAlert(Long id, @NotNull(message = "Desc cannot be null") String desc, Date createdAt) {
		this.id = id;
		this.description = desc;
		this.createdAt = createdAt;
	}

//	@PrePersist
//	protected void onCreate() {
//		this.createdAt = new Date();
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesc() {
		return description;
	}

	public void setDesc(String desc) {
		this.description = desc;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "IncomingAlert [id=" + id + ", desc=" + description + ", createdAt=" + createdAt + "]";
	}

}

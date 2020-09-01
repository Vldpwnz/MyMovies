package vlad.project.Entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	private String description;
	private String author;
	
	@Column(name = "RELEASE_YEAR")
	private Date releaseYear;
	
	@Column(name = "POSTER_URL")
	private String posterURL;
	
	private List<User> users;
	
	
	
	

}

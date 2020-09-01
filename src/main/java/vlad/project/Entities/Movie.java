package vlad.project.Entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "release_year")
	private Date releaseYear;
	
	@Column(name = "poster_URL")
	private String posterURL;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "movie_user",
			joinColumns =@JoinColumn(name = "movie_id"),
			inverseJoinColumns = @JoinColumn( name = "user_id"))
	private List<User> users;
	
	
	
	

}

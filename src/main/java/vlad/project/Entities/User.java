package vlad.project.entities;

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
public class User {
	
	@Id
	//must be IDENTITY, as database created and have pre-edited entities in it 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name = "user_name")
	private String userName;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "movie_user",
			joinColumns =@JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn( name = "movie_id"))
	private List<Movie> movies;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
	
	
	

	
}

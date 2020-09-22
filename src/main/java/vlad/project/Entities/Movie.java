package vlad.project.entities;

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

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
//@Data annotation not giving getters/setters for thymeleaf, added it manually 
@Data
public class Movie {
	
	@Id
	//must be IDENTITY, as database created and have pre-edited entities in it 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "release_year")
	/**DateTimeFormat using this annotation I excluded problems with conversation between date in Spring Boot and date in Thymeleaf 
	 * Failed to convert from type [java.lang.String] to type [@javax.persistence.Column java.util.Date] for value '2020-02-13'
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date releaseYear;
	
	@Column(name = "poster_URL")
	private String posterURL;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "movie_user",
			joinColumns =@JoinColumn(name = "movie_id"),
			inverseJoinColumns = @JoinColumn( name = "user_id"))
	private List<User> users;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Date releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getPosterURL() {
		return posterURL;
	}

	public void setPosterURL(String posterURL) {
		this.posterURL = posterURL;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	
	
	

}

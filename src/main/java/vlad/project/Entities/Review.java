package vlad.project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(ReviewId.class)
public class Review {
	
	@Id
	@Column(name="movie_id")
	private Long movie;
	
	@Id
	@Column(name="user_id")
	private Long user;
	
	@Column(name="review_text")
	private String reviewText;

	public Long getMovie() {
		return movie;
	}

	public void setMovie(Long movie) {
		this.movie = movie;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	

}

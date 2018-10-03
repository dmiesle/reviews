package org.wecancodeit.Reviews;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Test;

public class ReviewRepositoryTest {
	ReviewRepository underTest;
	private long id = 1L;
	private long id2 = 2L;

	private Review review = new Review(id, "GameTitle", "/resources/templates/image.jpg", "category of game",
			"this is a game that is fun", 3);
	private Review review2 = new Review(id2, "GameTitle2", "/resources/templates/image2.jpg", "category of game",
			"this is a game that is meh", 3);

	@Test
	public void shouldFindAReview() {
		underTest = new ReviewRepository (review);
		Review result = underTest.getReviewId(id);
		assertThat(result, is(review));

	}
	@Test
	public void shouldFindASecondReview() {
		underTest = new ReviewRepository (review2);
		Review result = underTest.getReviewId(id2);
		assertThat(result, is(review2));
	}
	
	@Test
	public void shouldFindAllReviews () {
		underTest = new ReviewRepository(review, review2);
		Collection<Review> result = underTest.findAll();
		assertThat(result, containsInAnyOrder(review, review2));
	}

}

package org.wecancodeit.Reviews;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import static java.util.Arrays.asList;
import java.util.Collection;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(ReviewController.class)
public class ReviewControllerMockMVCTest {
	@Resource
	private MockMvc mvc;

	@MockBean
	private ReviewRepository repository;

	@Mock
	private Review review;

	@Mock
	private Review review2;

	@Test
	public void shouldBeOkForAllReviews() throws Exception {
		mvc.perform(get("/show-reviews")).andExpect(status().isOk());
	}
	@Test
	public void shouldRouteToAllReviewsVeiw() throws Exception {
		mvc.perform(get("/show-reviews")).andExpect(view().name("reviews"));
	}
	@Test
	public void shouldPutAllReviewsIntoModel() throws Exception{
		Collection<Review>allReviews = asList(review, review2);
		when(repository.findAll()).thenReturn(allReviews);
		mvc.perform(get("/show-reviews")).andExpect(model().attribute("reviews", is(allReviews)));
	}
	@Test
	public void shouldBeOkForSingleeview() throws Exception{
		mvc.perform(get("/review?id=1")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldRouteToReviewVeiwDetail() throws Exception {
		mvc.perform(get("/review?id=1")).andExpect(view().name("review"));
	}
	
	@Test
	public void shouldPutASingleReviewIntoModel() throws Exception{
		when(repository.findReview(1L)).thenReturn(review);
		mvc.perform(get("/review?id=1")).andExpect(model().attribute("reviews", is(review)));
	}

}

package org.wecancodeit.Reviews;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class ReviewRepository {

	private Map<Long, Review> reviewList = new HashMap<>();
	
		public ReviewRepository() {
			Review wowVanilla = new Review(1L, "World Of Warcraft: Vanilla", "/img/wowvanilla.png", "Original Release",
					"Everyone says this is the best verision, but it's full of absurdities. The only redeeming quality is that Enhancement Shamans can tank.", 3);
			Review wowBurningCrusade = new Review(2L, "World Of Warcraft: The Burning Crusade", "/img/wowbc.jpg", "First Release",
					"This introduced some new features. Clearly the best part was PvP.", 4);
			Review wowWotlk = new Review(3L, "World Of Warcraft: Wrath of the Litch King", "/img/wowwotlk.png", "Third Release",
					"Heroic Dungeons, pleanty of Raid instance releases. Death Knights introduced, Blizzard loves them.", 4);
			
			reviewList.put(wowVanilla.getId(), wowVanilla);
			reviewList.put(wowBurningCrusade.getId(), wowBurningCrusade);
			reviewList.put(wowWotlk.getId(), wowWotlk);
	}

		public Review getReviewId(long id) {
			return reviewList.get(id);
		}

		public Collection<Review> findAll() {
			return reviewList.values();
		}
		public Review findReview(long id) {
			return reviewList.get(id);
		}

}

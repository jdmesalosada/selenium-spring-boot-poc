package com.mesaj;

import com.mesaj.conf.TestConfig;
import com.mesaj.models.SearchInfo;
import com.mesaj.pageobjects.home.HomePage;
import com.mesaj.pageobjects.search.SearchResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {TestConfig.class})
class FlightSearchTests {


	@Autowired
	HomePage homePage;

	@Autowired
	SearchResult searchResult;

	@Value("${flight.search.type}")
	private String searchType;

	@Test
	void searchFlight() {

		System.out.println("Current search type: " + searchType);
		homePage.navigate(searchType);

		SearchInfo searchInfo = new SearchInfo("Cali", "Cartagena", 2);

		homePage.performSearch(searchInfo);
		searchResult.checkSuccessResult();

	}

}

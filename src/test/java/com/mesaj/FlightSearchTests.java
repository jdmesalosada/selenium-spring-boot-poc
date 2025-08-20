package com.mesaj;

import com.mesaj.entities.Flight;
import com.mesaj.models.SearchInfo;
import com.mesaj.pageobjects.home.HomePage;
import com.mesaj.pageobjects.search.SearchResult;
import com.mesaj.repositories.FlightRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class FlightSearchTests {

	@Autowired
	HomePage homePage;

	@Autowired
	SearchResult searchResult;

	@Value("${flight.search.type}")
	private String searchType;

	@Autowired
	FlightRepository flightRepository;

	@Test
	void searchFlight()  {

		System.out.println("Current search type: " + searchType);
		homePage.navigate(searchType);

		SearchInfo searchInfo = new SearchInfo("Cali", "Cartagena", 2);

		homePage.performSearch(searchInfo);
		searchResult.checkSuccessResult();
	}

	@Test
	public void loadAllTheFlightsFromDatabase(){

		List<Flight> flights = flightRepository.findAll();

		for(Flight flight: flights){

			System.out.println(flight.getDestination());

			homePage.navigate(searchType);
			SearchInfo searchInfo = new SearchInfo(flight.getOrigin(), flight.getDestination(), flight.getNumberOfPassengers());
			homePage.performSearch(searchInfo);
			searchResult.checkSuccessResult();
		}
	}

}

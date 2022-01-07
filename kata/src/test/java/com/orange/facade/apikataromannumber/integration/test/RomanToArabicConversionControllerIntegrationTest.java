package com.orange.facade.apikataromannumber.integration.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RomanToArabicConversionControllerIntegrationTest extends AbstractIntegrationTest {

	@BeforeAll
	public void setup() throws Exception {
		super.setUp();
	}

	@Test
	void RomanToArabic_convert_without_value() throws Exception {
		//Setup

		mvc.perform(
				//Test
				get("/RomanToArabic"))
				.andDo(print())

				//Assert
				.andExpect(status().is2xxSuccessful())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.valueToConvert").isEmpty())
				.andExpect(jsonPath("$.response").isEmpty());
	}

}

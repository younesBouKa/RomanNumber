package com.orange.facade.apikataromannumber.integration.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ArabicToRomanConversionControllerIntegrationTest extends AbstractIntegrationTest {

	@BeforeAll
	public void setup() throws Exception {
		super.setUp();
	}

	@Test
	void ArabicToRoman_convert_1_to_I() throws Exception {
		//Setup

		mvc.perform(
						//Test
						get("/ArabicToRoman?valueToConvert=1"))
				.andDo(print())

				//Assert
				.andExpect(status().is2xxSuccessful())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.valueToConvert").value("1"))
				.andExpect(jsonPath("$.response").value("I"));
	}

	//@Test
	void ArabicToRoman_convert_without_value() throws Exception {
		//Setup

		mvc.perform(
						//Test
						get("/ArabicToRoman?valueToConvert="))
				.andDo(print())

				//Assert
				.andExpect(status().is2xxSuccessful())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.valueToConvert").isEmpty())
				.andExpect(jsonPath("$.response").isEmpty());
	}

}

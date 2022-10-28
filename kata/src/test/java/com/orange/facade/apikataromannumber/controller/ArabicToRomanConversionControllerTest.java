package com.orange.facade.apikataromannumber.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.*;
import org.springframework.http.ResponseEntity;

import com.orange.facade.apikataromannumber.bean.response.RomanConversionResponse;

@ExtendWith(MockitoExtension.class)
class ArabicToRomanConversionControllerTest {

	@InjectMocks
	ArabicToRomanConversionController controller;

	@Test
	void testGetRomanConversion_convert_1_to_I() throws Exception {
		//setup
		Integer valueToConvert = 1;

		//Test
		ResponseEntity<RomanConversionResponse> romanConversion = controller.getRomanConversion(valueToConvert);

		//Assert
		assertThat(romanConversion.getBody().getValueToConvert()).isEqualTo("1");
		assertThat(romanConversion.getBody().getResponse()).isEqualTo("I");
	}

	//@Test
	void testGetRomanConversion_test_null_value() throws Exception {
		//setup
		Integer valueToConvert = null;

		//Test
		ResponseEntity<RomanConversionResponse> romanConversion = controller.getRomanConversion(valueToConvert);

		//Assert
		assertThat(romanConversion.getStatusCodeValue()).isEqualTo(404);
		assertThat(romanConversion.getBody()).isNotNull();
		assertThat(romanConversion.getBody().getValueToConvert()).isNullOrEmpty();
		assertThat(romanConversion.getBody().getResponse()).isNullOrEmpty();
	}

}

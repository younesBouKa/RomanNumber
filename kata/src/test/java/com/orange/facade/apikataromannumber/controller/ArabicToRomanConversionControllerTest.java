package com.orange.facade.apikataromannumber.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.*;
import org.springframework.http.ResponseEntity;

import com.orange.facade.apikataromannumber.bean.response.RomanConversionResponse;

@ExtendWith(MockitoExtension.class)
class ArabicToRomanConversionControllerTest {

	@InjectMocks
	ArabicToRomanConversionController controller;
	
	@Test
	void testGetRomanConversion() throws Exception {
		//setup
		String valueToConvert = null;
		
		//Test
		ResponseEntity<RomanConversionResponse> romanConversion = controller.getRomanConversion(valueToConvert);
		
		//Assert
		assertThat(romanConversion.getStatusCodeValue()).isEqualTo(200);
		assertThat(romanConversion.getBody()).isNotNull();
		assertThat(romanConversion.getBody().getValueToConvert()).isNullOrEmpty();
		assertThat(romanConversion.getBody().getResponse()).isNullOrEmpty();
	}

}

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
class RomanToArabicConversionControllerTest {
	
	@InjectMocks
	RomanToArabicConversionController controller;

	@Test
	void testGetArabicConversion() throws Exception {
		//setup
		String valueToConvert = null;
		
		//Test
		ResponseEntity<RomanConversionResponse> romanConversion = controller.getArabicConversion(valueToConvert);
		
		//Assert
		//Assert
		assertThat(romanConversion.getStatusCodeValue()).isEqualTo(200);
		assertThat(romanConversion.getBody()).isNotNull();
		assertThat(romanConversion.getBody().getValueToConvert()).isNullOrEmpty();
		assertThat(romanConversion.getBody().getResponse()).isNullOrEmpty();
	}

}

package com.orange.facade.apikataromannumber.controller;

import com.orange.facade.apikataromannumber.bean.response.RomanConversionResponse;
import com.orange.facade.apikataromannumber.service.ConverterServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ArabicToRomanConversionControllerTest {
	//setup
	private static Map<String, Integer> randomValues = new HashMap<>();
	private static String[] sortedRomanValues;
	//@InjectMocks
	private ArabicToRomanConversionController controller = new ArabicToRomanConversionController(new ConverterServiceImpl());

	@BeforeAll
	static void setUp() {
		// random Values
		randomValues = new HashMap<>();
		randomValues.put("ML", 1050);
		randomValues.put("LX", 60);
		randomValues.put("DCIV", 604);
		randomValues.put("CXIV", 114);
		randomValues.put("CLXXV", 175);
		// sorted values
		sortedRomanValues = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
				"XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX"};
	}

	@Test
	void testGetRomanConversion_convert_1_to_I() throws Exception {
		//setup
		String valueToConvert = "1";

		//Test
		ResponseEntity<RomanConversionResponse> romanConversion = controller.getRomanConversion(valueToConvert);

		//Assert
		assertThat(romanConversion.getBody()).isNotNull();
		assertThat(romanConversion.getBody().getValueToConvert()).isEqualTo("1");
		assertThat(romanConversion.getBody().getResponse()).isEqualTo("I");
	}

	@Test
	void testGetRomanConversion_test_null_value() throws Exception {
		//setup
		String valueToConvert = null;

		//Test
		ResponseEntity<RomanConversionResponse> romanConversion = controller.getRomanConversion(valueToConvert);

		//Assert
		assertThat(romanConversion.getStatusCodeValue()).isEqualTo(404);
		assertThat(romanConversion.getBody()).isNotNull();
		assertThat(romanConversion.getBody().getValueToConvert()).isNullOrEmpty();
		assertThat(romanConversion.getBody().getResponse()).isNullOrEmpty();
	}

	@Test
	void testConversionToRomanWithRandomValues() throws Exception {
		for(String romanValue: randomValues.keySet()){
			String arabicValue = randomValues.get(romanValue)+"";
			//Test
			ResponseEntity<RomanConversionResponse> romanConversion = controller.getRomanConversion(arabicValue);
			//Assert
			assertThat(romanConversion.getBody()).isNotNull();
			assertThat(romanConversion.getBody().getResponse()).isNotNull();
			assertThat(romanConversion.getBody().getResponse()).isEqualTo(romanValue);
		}
	}

	@Test
	void testConversionToArabicWithRandomValues() throws Exception {
		for(String romanValue: randomValues.keySet()){
			String arabicValue = randomValues.get(romanValue)+"";
			//Test
			ResponseEntity<RomanConversionResponse> arabicConversion = controller.getArabicConversion(romanValue);
			//Assert
			assertThat(arabicConversion.getBody()).isNotNull();
			assertThat(arabicConversion.getBody().getResponse()).isNotNull();
			assertThat(arabicConversion.getBody().getResponse()).isEqualTo(arabicValue);
		}
	}

	@Test
	void testConversionToRomanWithSortedValues() throws Exception {
		for(int i=0; i<sortedRomanValues.length; i++){
			String romanValue = sortedRomanValues[i];
			String arabicValue = (i+1)+"";
			//Test
			ResponseEntity<RomanConversionResponse> romanConversion = controller.getRomanConversion(arabicValue);
			//Assert
			assertThat(romanConversion.getBody()).isNotNull();
			assertThat(romanConversion.getBody().getResponse()).isNotNull();
			assertThat(romanConversion.getBody().getResponse()).isEqualTo(romanValue);
		}
	}

	@Test
	void testConversionToArabicWithSortedValues() throws Exception {
		for(int i=0; i<sortedRomanValues.length; i++){
			String romanValue = sortedRomanValues[i];
			String arabicValue = (i+1)+"";
			//Test
			ResponseEntity<RomanConversionResponse> arabicConversion = controller.getArabicConversion(romanValue);
			//Assert
			assertThat(arabicConversion.getBody()).isNotNull();
			assertThat(arabicConversion.getBody().getResponse()).isNotNull();
			assertThat(arabicConversion.getBody().getResponse()).isEqualTo(arabicValue);
		}
	}

}

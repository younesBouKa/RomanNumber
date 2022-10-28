package com.orange.facade.apikataromannumber.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orange.facade.apikataromannumber.bean.response.RomanConversionResponse;

@RestController
public class ArabicToRomanConversionController {

	@GetMapping(value = "/ArabicToRoman")
	public ResponseEntity<RomanConversionResponse> getRomanConversion(@RequestParam(required = true) String valueToConvert){
		RomanConversionResponse conversionResponse = new RomanConversionResponse();
		conversionResponse.setValueToConvert(String.valueOf(valueToConvert));
		if (valueToConvert == 1) {
			conversionResponse.setResponse("I");
		}
		return new ResponseEntity<>(conversionResponse, HttpStatus.OK);
	
}

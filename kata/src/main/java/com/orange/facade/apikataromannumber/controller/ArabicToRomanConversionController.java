package com.orange.facade.apikataromannumber.controller;

import com.orange.facade.apikataromannumber.service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orange.facade.apikataromannumber.bean.response.RomanConversionResponse;

@RestController
public class ArabicToRomanConversionController {
	private final ConverterService converterService;

	public ArabicToRomanConversionController(@Autowired ConverterService converterService){
		this.converterService = converterService;
	}

	@GetMapping(value = "/ArabicToRoman")
	public ResponseEntity<RomanConversionResponse> getRomanConversion(@RequestParam(required = true) String valueToConvert){
		RomanConversionResponse conversionResponse = new RomanConversionResponse();
		conversionResponse.setValueToConvert(valueToConvert);
		if(valueToConvert==null){
			conversionResponse.setResponse(null);
			return new ResponseEntity<>(conversionResponse, HttpStatus.NOT_FOUND);
		}
		if(valueToConvert.isEmpty()){
			conversionResponse.setResponse("");
			return new ResponseEntity<>(conversionResponse, HttpStatus.OK);
		}
		try {
			int valueToConvertInt = Integer.parseInt(valueToConvert);
			conversionResponse.setResponse(converterService.arabicToRoman(valueToConvertInt));
			return new ResponseEntity<>(conversionResponse, HttpStatus.OK);
		}catch (NumberFormatException e){
			conversionResponse.setResponse(null);
			return new ResponseEntity<>(conversionResponse, HttpStatus.NOT_FOUND);
		}
	}


	@GetMapping(value = "/RomanToArabic")
	public ResponseEntity<RomanConversionResponse> getArabicConversion(@RequestParam(required = true) String valueToConvert){
		RomanConversionResponse conversionResponse = new RomanConversionResponse();
		conversionResponse.setValueToConvert(valueToConvert);
		if(!converterService.isRomanNumberValid(valueToConvert)){
			conversionResponse.setResponse(null);
			return new ResponseEntity<>(conversionResponse, HttpStatus.NOT_FOUND);
		}
		String convertedValue = ""+converterService.romanToArabic(valueToConvert);
		conversionResponse.setResponse(convertedValue);
		return new ResponseEntity<>(conversionResponse, HttpStatus.OK);
	}
}

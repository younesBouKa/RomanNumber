package com.orange.facade.apikataromannumber.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orange.facade.apikataromannumber.bean.response.RomanConversionResponse;

@RestController
public class RomanToArabicConversionController {

	@GetMapping(value = "/RomanToArabic")
	public ResponseEntity<RomanConversionResponse> getArabicConversion(@RequestParam(required = false) String valueToConvert){
		
		
		
		return new ResponseEntity<>(new RomanConversionResponse(), HttpStatus.OK);
	}
	
}

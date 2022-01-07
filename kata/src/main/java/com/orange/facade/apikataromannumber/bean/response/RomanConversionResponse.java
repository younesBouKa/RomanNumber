package com.orange.facade.apikataromannumber.bean.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Conversion value")
public class RomanConversionResponse {
	
	@ApiModelProperty(name = "valueToConvert")	
	String valueToConvert;
	
	@ApiModelProperty(name = "responseValue")
	String response;
	

}

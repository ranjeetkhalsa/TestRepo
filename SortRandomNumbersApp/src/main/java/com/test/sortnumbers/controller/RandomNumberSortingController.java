package com.test.sortnumbers.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.sortnumbers.model.RandomNumberSortingRequest;
import com.test.sortnumbers.model.RandomNumberSortingResponse;
import com.test.sortnumbers.service.RandomNumberSortingService;


@RestController
@ComponentScan
@RequestMapping("/service/test-data-service/1.0/")
public class RandomNumberSortingController {
	
	@Autowired
	RandomNumberSortingService randomNumberSortingService;
	
	@RequestMapping(value = "sortRandomNumbers", method = RequestMethod.POST)
	public @ResponseBody RandomNumberSortingResponse  sortRandomNumbers(@Valid @RequestBody RandomNumberSortingRequest randomNumberSortingRequest) {
		
		RandomNumberSortingResponse randomNumberSortingResponse = randomNumberSortingService.getSortedDetails(randomNumberSortingRequest);
		
		return randomNumberSortingResponse;
	}
		
}

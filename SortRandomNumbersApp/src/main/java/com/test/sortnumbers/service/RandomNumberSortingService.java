package com.test.sortnumbers.service;

import com.test.sortnumbers.model.RandomNumberSortingRequest;
import com.test.sortnumbers.model.RandomNumberSortingResponse;;

public interface RandomNumberSortingService {

	public RandomNumberSortingResponse getSortedDetails(RandomNumberSortingRequest randomNumberSortingRequest);
	
}

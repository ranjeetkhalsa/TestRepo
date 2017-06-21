package com.test.sortnumbers.repository;

import com.test.sortnumbers.model.RandomNumberSortingRequest;
import com.test.sortnumbers.model.RandomNumberSortingResponse;

public interface RandomNumberSortingRepository {

	public RandomNumberSortingResponse  getSortedData(RandomNumberSortingRequest randomNumberSortingRequest);
}

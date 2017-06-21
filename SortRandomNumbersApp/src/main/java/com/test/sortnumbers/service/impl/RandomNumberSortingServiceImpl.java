package com.test.sortnumbers.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.sortnumbers.model.RandomNumberSortingRequest;
import com.test.sortnumbers.model.RandomNumberSortingResponse;
import com.test.sortnumbers.repository.RandomNumberSortingRepository;
import com.test.sortnumbers.service.RandomNumberSortingService;;

@Service
@Transactional
public class RandomNumberSortingServiceImpl implements RandomNumberSortingService{

	@Autowired
	RandomNumberSortingRepository randomNumberSortingRepository;
	
	@Override
	public RandomNumberSortingResponse getSortedDetails(RandomNumberSortingRequest randomNumberSortingRequest) {

		return randomNumberSortingRepository.getSortedData(randomNumberSortingRequest);
	}
	
}

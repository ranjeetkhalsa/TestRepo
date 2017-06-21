package com.test.sortnumbers.repository.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.test.sortnumbers.model.ErrorDetails;
import com.test.sortnumbers.model.RandomNumberSortingRequest;
import com.test.sortnumbers.model.RandomNumberSortingResponse;
import com.test.sortnumbers.repository.RandomNumberSortingRepository;

/**
 * 
 * This class is written in order to achieve sorting of random numbers in ascending order.
 * 
 * @author Ranjeet Khalsa
 *
 */
@Repository
public class RandomNumberSortingRepositoryImpl implements RandomNumberSortingRepository {


	final static Logger logger = Logger.getLogger(RandomNumberSortingRepositoryImpl.class);
	
	public RandomNumberSortingResponse  getSortedData(RandomNumberSortingRequest randomNumberSortingRequest)
	{
	
		RandomNumberSortingResponse randomNumberSortingResponse = new RandomNumberSortingResponse();
		ErrorDetails errorDetails = null;
		int[] sortedResultArray = null;
		try{
			
			ArrayList<Integer> randomNumbersList = generateNRandomNumbers(randomNumberSortingRequest.getNoOfRandomNumbers(),
					randomNumberSortingRequest.getSeed());
			
			logger.info("Random Numbers List: "+randomNumbersList);
			
			// Calculating Start time and end time to calculate the time taken by the program to sort the numbers.
			long startTime = System.currentTimeMillis();
			
			//if sort type is descending
			if(randomNumberSortingRequest.getSortType().equalsIgnoreCase("DESC")){
				sortedResultArray = sortDescending(randomNumbersList);
			}
			//Default sort by ascending
			else
				sortedResultArray = sortAsscending(randomNumbersList);
			
			
			long endTime = System.currentTimeMillis();
			
			// total time elapsed is time taken from start to end to sort the numbers.
			long elapsedTime = endTime - startTime;
			logger.info("elapsedTime: " + elapsedTime);
			
			randomNumberSortingResponse.setSortedNumbersArray(sortedResultArray);
			randomNumberSortingResponse.setTimeTakenToSort(elapsedTime);
			randomNumberSortingResponse.setErrorDetails(errorDetails);
		}
	    catch(Exception e){
	    	logger.error("An exception occurred while sorting random numbers. Please contact system administrator");
	    	errorDetails = new ErrorDetails();
	    	errorDetails.setErrorCode("FAILED");
	    	errorDetails.setErrorMessage("An error occurred due to : " + e);
	    	randomNumberSortingResponse.setErrorDetails(errorDetails);
	    }
		return randomNumberSortingResponse;
	}
	
	/**
	 * Method takes list of randomly generated numbers and returns the sorted array of numbers.
	 *  
	 * @param randomNumbersList list of random numbers.
	 * 
	 * @return array of integers.
	 */
	private int[] sortAsscending(ArrayList<Integer> randomNumbersList){
		
		
		ArrayList<Integer> listToProcess = randomNumbersList;
		int[] randomNumbersArray  = convertListToArray(randomNumbersList);
		
		int[] finalSortedArray = randomNumbersArray;
		
		for(int i=0; i<randomNumbersArray.length; i++){
			Integer min = Collections.min(listToProcess);
			listToProcess.remove(listToProcess.indexOf(min));
			finalSortedArray[i] = min;
		}
		
		logger.info("FinalSorted Numbers : ");
		for (int i=0; i < finalSortedArray.length; i++)
		{
			logger.info(finalSortedArray[i]);
		}
		
		return finalSortedArray;
	}
	
	/**
	 * Method takes list of randomly generated numbers and returns the sorted array of numbers.
	 *  
	 * @param randomNumbersList list of random numbers.
	 * 
	 * @return array of integers.
	 */
	private int[] sortDescending(ArrayList<Integer> randomNumbersList){
		
		
		ArrayList<Integer> listToProcess = randomNumbersList;
		int[] randomNumbersArray  = convertListToArray(randomNumbersList);
		
		int[] finalSortedArray = randomNumbersArray;
		
		for(int i=0; i<randomNumbersArray.length; i++){
			Integer max = Collections.max(listToProcess);
			listToProcess.remove(listToProcess.indexOf(max));
			finalSortedArray[i] = max;
		}
		
		logger.info("FinalSorted Numbers : ");
		for (int i=0; i < finalSortedArray.length; i++)
		{
			logger.info(finalSortedArray[i]);
		}
		
		return finalSortedArray;
	}
	
	/**
	 * This function servers the purpose of generating N random numbers.
	 * 
	 * @param noOfRandomNumbers number of random numbers to be generated. 
	 *  
	 * @param seed the range within which the random numbers to be generated.
	 * 
	 * @return list of random numbers generated to be returned.
	 */
	private ArrayList<Integer> generateNRandomNumbers(Integer noOfRandomNumbers, Integer seed){
		
		Random rand = new Random();

		ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
		
		for(int index=0; index<noOfRandomNumbers; index++){
			
			int random = rand.nextInt(seed)+1;
			randomNumbers.add((Integer)random);
		}
		return randomNumbers;
	}
	
	/**
	 * The function takes random numbers list and gives integer array for the same.
	 * 
	 * @param randomNumbersList Arraylist of generated random numbers.
	 * 
	 * @return integer array of random numbers.
	 */
	private int[] convertListToArray(ArrayList<Integer> randomNumbersList){
		
		int[] randomNumbersArray = new int[randomNumbersList.size()];	    
		for (int i=0; i < randomNumbersArray.length; i++)
		{
			randomNumbersArray[i] = randomNumbersList.get(i).intValue();
		}
		return randomNumbersArray;
		
	}
	
}

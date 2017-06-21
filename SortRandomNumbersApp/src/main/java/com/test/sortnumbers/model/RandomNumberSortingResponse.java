package com.test.sortnumbers.model;

import java.util.Arrays;

public class RandomNumberSortingResponse {
	
	private int[] sortedNumbersArray;
	
	private long timeTakenToSort;
	
	private ErrorDetails errorDetails;
	
	public int[] getSortedNumbersArray() {
		return sortedNumbersArray;
	}
	
	public void setSortedNumbersArray(int[] sortedNumbersArray) {
		this.sortedNumbersArray = sortedNumbersArray;
	}
	
	public long getTimeTakenToSort() {
		return timeTakenToSort;
	}
	
	public void setTimeTakenToSort(long timeTakenToSort) {
		this.timeTakenToSort = timeTakenToSort;
	}
	
	public ErrorDetails getErrorDetails() {
		return errorDetails;
	}
	
	public void setErrorDetails(ErrorDetails errorDetails) {
		this.errorDetails = errorDetails;
	}

	@Override
	public String toString() {
		return "RandomNumberSortingResponse [sortedNumbersArray=" + Arrays.toString(sortedNumbersArray)
		+ ", timeTakenToSort= " + timeTakenToSort		
		+ ", errorDetails=" + errorDetails + "]";
	}
	
	
}

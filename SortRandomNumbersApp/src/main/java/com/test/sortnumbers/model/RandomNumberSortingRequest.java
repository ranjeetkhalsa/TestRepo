package com.test.sortnumbers.model;

public class RandomNumberSortingRequest {
	
	private int noOfRandomNumbers;
	
	private int seed;
	
	private String sortType;
	
	public int getNoOfRandomNumbers() {
		return noOfRandomNumbers;
	}
	
	public void setNoOfRandomNumbers(int noOfRandomNumbers) {
		this.noOfRandomNumbers = noOfRandomNumbers;
	}
	
	public int getSeed() {
		return seed;
	}
	
	public void setSeed(int seed) {
		this.seed = seed;
	}

	public String getSortType() {
		return sortType;
	}
	
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
	
	@Override
	public String toString() {
		return "RandomNumberSortingRequest [noOfRandomNumbers=" + noOfRandomNumbers + ", sortType=" + sortType + ", seed=" + seed + "]";
	}
	
	
}

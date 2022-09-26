package com.adition.clicklog.exception;

import com.adition.clicklog.util.Constants;

public class InvalidParameterException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidParameterException(String date) {
		super("DateTime could not be parsed: [" + date + "]. Valid date format is [" + Constants.DATE_FORMAT + "]");
	}
	
	public InvalidParameterException(String startDate, String endDate) {
		super("Invalid endDate parameter. End Date [" + endDate + "] should be greater than or equal to Start Date [" + startDate + "]");
	}
}

package com.adition.clicklog.util;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.adition.clicklog.exception.InvalidParameterException;

public class DateFormat {
	public static long dateToEpochSecond(String date) throws InvalidParameterException {
		try {
			LocalDateTime localDateTime = LocalDateTime.parse(date, DateTimeFormatter.ofPattern(Constants.DATE_FORMAT));
			ZonedDateTime zdt = localDateTime.atZone(Constants.DEFAULT_TIMEZONE_ID);
			return zdt.toEpochSecond();
		} catch (DateTimeParseException exception) {
			throw new InvalidParameterException(date);
		}
	}
}

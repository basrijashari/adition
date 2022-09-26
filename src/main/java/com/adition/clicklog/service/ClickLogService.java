package com.adition.clicklog.service;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adition.clicklog.exception.InvalidParameterException;
import com.adition.clicklog.repository.ClickLogRepository;
import com.adition.clicklog.service.dto.ClickLogCountDTO;
import com.adition.clicklog.util.DateFormat;

@Service
public class ClickLogService {

	@Autowired
	ClickLogRepository clickLogRepository;

	public ClickLogCountDTO countByCampaign(long campaign) {
		return Stream.of(clickLogRepository.countByCampaign(campaign)).map(ClickLogCountDTO::new).findFirst().get();
	}

	public ClickLogCountDTO countByCampaignBetweenDates(long campaign, String startDate, String endDate) {
		long from = DateFormat.dateToEpochSecond(startDate);
		long to = DateFormat.dateToEpochSecond(endDate);
		if(from > to) {
			throw new InvalidParameterException(startDate, endDate);
		}
		return Stream.of(clickLogRepository.countByCampaignAndTimestampBetween(campaign, from, to))
				.map(ClickLogCountDTO::new).findFirst().get();
	}
}

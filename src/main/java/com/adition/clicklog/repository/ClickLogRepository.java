package com.adition.clicklog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adition.clicklog.model.ClickLog;

@Repository
public interface ClickLogRepository extends JpaRepository<ClickLog, String> {

	long countByCampaign(Long campaign);

	long countByCampaignAndTimestampBetween(Long campaign, Long startDate, Long endDate);

}
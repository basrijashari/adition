package com.adition.clicklog.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adition.clicklog.service.ClickLogService;
import com.adition.clicklog.service.dto.ClickLogCountDTO;

@RestController
@RequestMapping("/api")
public class ClickLogController {

	private final Logger log = LoggerFactory.getLogger(ClickLogController.class);
	
	@Autowired
	ClickLogService clickLogService;
	
	/**
     * {@code GET  /clicklogs/:campaign/count} : count "campaign" clicks.
     *
     * @param campaign the campaign to count clicks for.
     * @return the {@link EntityModel} with status {@code 200 (OK)} and with body the ClickLogCountDTO.
     */
	@GetMapping("/clicklogs/{campaign}/count")
	EntityModel<ClickLogCountDTO> countByCampaign(@PathVariable Long campaign) {
		log.info(String.format("Counting clicks for campaign [%d]", campaign));
		ClickLogCountDTO clickLogCount = clickLogService.countByCampaign(campaign);
		return EntityModel.of(clickLogCount, linkTo(methodOn(ClickLogController.class).countByCampaign(campaign)).withSelfRel());
	}
	
	/**
     * {@code GET  /clicklogs/:campaign/:startDate/:endDate/count} : count "campaign" clicks that fall between a given start date and a given end date.
     *
     * @param campaign the campaign to count clicks for.
     * @param startDate the timestamp of click should be greater than or equal to startDate.
     * @param endDate the timestamp of click should be less than or equal to endDate.
     * @return the {@link EntityModel} with status {@code 200 (OK)} and with body the ClickLogCountDTO.
     * @throws InvalidParameterException if the start date or end date format is incorrect.
     */
	@GetMapping("/clicklogs/{campaign}/{startDate}/{endDate}/count")
	EntityModel<ClickLogCountDTO> countByCampaignBetweenDates(@PathVariable Long campaign, @PathVariable String startDate, @PathVariable String endDate) throws Exception{
		log.info(String.format("Counting clicks for campaign [%d] within datetime [%s] and [%s]", campaign, startDate, endDate));
		ClickLogCountDTO clickLogCount = clickLogService.countByCampaignBetweenDates(campaign, startDate, endDate);
		return EntityModel.of(clickLogCount, linkTo(methodOn(ClickLogController.class).countByCampaignBetweenDates(campaign, startDate, endDate)).withSelfRel());
	}

}

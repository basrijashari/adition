package com.adition.clicklog.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.adition.clicklog.exception.InvalidParameterException;
import com.adition.clicklog.service.ClickLogService;
import com.adition.clicklog.service.dto.ClickLogCountDTO;


@ExtendWith(SpringExtension.class)
@WebMvcTest(value = ClickLogController.class)
public class ClickLogControllerTest {
	
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClickLogService clickLogService;

    @Test
    public void testCountByCampaign() throws Exception {
    	long count = 13;
    	
        Mockito.when(clickLogService.countByCampaign(Mockito.anyLong()))
        	   .thenReturn(new ClickLogCountDTO(count));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
        		.get("/api/clicklogs/4510461/count")
        		.accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{\"count\": " + count + "}";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
        assertTrue(result.getResponse().getStatus() == 200);
    }
    
    @Test
    public void testCountByCampaignBetweenDates() throws Exception {
    	long count = 4;
    	
        Mockito.when(clickLogService.countByCampaignBetweenDates(Mockito.anyLong(), Mockito.anyString(), Mockito.anyString()))
        	   .thenReturn(new ClickLogCountDTO(count));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
        		.get("/api/clicklogs/4510461/2021-11-0703:10:00/2021-11-0703:30:00/count")
        		.accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{\"count\": " + count + "}";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
        assertTrue(result.getResponse().getStatus() == 200);
    }
    
    @Test
    public void testCountByCampaignBetweenDatesInvalidParameter() throws Exception {
        Mockito.when(clickLogService.countByCampaignBetweenDates(Mockito.anyLong(), Mockito.anyString(), Mockito.anyString()))
        	   .thenThrow(new InvalidParameterException("2021-11-0703:30:00a"));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
        		.get("/api/clicklogs/4510461/2021-11-0703:10:00/2021-11-0703:30:00a/count")
        		.accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "DateTime could not be parsed: [2021-11-0703:30:00a]. Valid date format is [yyyy-MM-ddHH:mm:ss]";
        
        assertEquals(expected, result.getResponse().getContentAsString());
        assertTrue(result.getResponse().getStatus() == 400);
    }
}

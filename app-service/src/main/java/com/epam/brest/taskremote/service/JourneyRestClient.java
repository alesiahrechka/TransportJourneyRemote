package com.epam.brest.taskremote.service;

import com.epam.brest.taskremote.domain.Journey;
import com.epam.brest.taskremote.domain.AutomobileSummary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by alesya on 12.12.14.
 */
public class JourneyRestClient {

    public static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

    private static final Logger LOGGER = LogManager.getLogger();

    private String host;

    private RestTemplate restTemplate = new RestTemplate();

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public JourneyRestClient(String host) {
        this.host = host;
        List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
        converters.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(converters);
    }

    public Long addJourney(Journey journey){
        LOGGER.debug("addJourney({})", journey);
        return restTemplate.postForObject(host+"/journeys", journey, Long.class);
    }

    public void removeJourney(Long id){
        LOGGER.debug("removeJourney{}", id);
        restTemplate.delete(host+"/journeys/"+id);
    }

    public void updateJourney(Journey journey){
        LOGGER.debug("updateJourney({})", journey);
        restTemplate.put(host+"/journeys", journey);
    }

    public Journey getJourneyById(Long id){
        LOGGER.debug("getJourneyById({})", id);
        return restTemplate.getForObject(host + "/journeys/" + id, Journey.class);
    }

    public Journey[] getAllJourneys(){
        LOGGER.debug("getAllJourneys()");
        return restTemplate.getForObject(host + "/journeys", Journey[].class);
    }

    public AutomobileSummary[] getAutomobileSummaries(){
        LOGGER.debug("getAutomobileSummaries()");
        return restTemplate.getForObject(host+"/summary",AutomobileSummary[].class);
    }

    public AutomobileSummary[] getAutomobileSummaries(String date1, String date2){
        LOGGER.debug("getAutomobileSummaries({},{})",date1,date2);
        StringBuilder rest = new StringBuilder();
        rest.append(host);
        rest.append("/summary");
        rest.append("/date1");
        rest.append(date1);
        rest.append("/date2");
        rest.append(date2);
        return restTemplate.getForObject(rest.toString(),AutomobileSummary[].class);
    }
}

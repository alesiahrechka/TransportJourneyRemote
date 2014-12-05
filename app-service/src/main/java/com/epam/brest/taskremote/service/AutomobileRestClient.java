package com.epam.brest.taskremote.service;

import com.epam.brest.taskremote.domain.Automobile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alesya on 29.11.14.
 */

public class AutomobileRestClient {

    private static final Logger LOGGER = LogManager.getLogger();

    private String host;

    private RestTemplate restTemplate = new RestTemplate();

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public AutomobileRestClient(String host) {
        this.host = host;
        List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
        converters.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(converters);
    }

    public Long addAutomobile(Automobile automobile) {
        LOGGER.debug("addAutomobile {}", automobile);
        return restTemplate.postForObject(host + "/automobiles", automobile, Long.class);
    }

    public void removeAutomobile(Long id) {
        LOGGER.debug("removeAutomobile {}", id);
        restTemplate.delete(host + "/automobiles/" + id);
    }

    public void updateAutomobile(Automobile automobile) {
        LOGGER.debug("updateAutomobile {}", automobile);
        restTemplate.put(host + "/automobiles", automobile);
    }

    public Automobile getAutomobileById(Long id) {
        LOGGER.debug("getAutomobileById {}", id);
        return restTemplate.getForObject(host + "/automobiles/" + id, Automobile.class);
    }

    public Automobile getAutomobileByNumber(String number) {
        LOGGER.debug("getAutomobileByNumber {}", number);
        return restTemplate.getForObject(host + "/automobiles/number/" + number, Automobile.class);
    }

    public Automobile[] getAllAutomobiles() {
        LOGGER.debug("getAllAutomobiles {}", host);
        return restTemplate.getForObject(host + "/automobiles", Automobile[].class);
    }
}

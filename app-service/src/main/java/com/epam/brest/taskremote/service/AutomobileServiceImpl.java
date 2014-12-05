package com.epam.brest.taskremote.service;


import com.epam.brest.taskremote.domain.Automobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by alesya on 20.11.14.
 */

@Service
public class AutomobileServiceImpl implements AutomobileService {

    private AutomobileRestClient restClient ;
           // = new  AutomobileRestClient("http://localhost:8080/journey");

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Long addAutomobile(Automobile automobile) {

        restClient = new AutomobileRestClient("http://localhost:8080/journey");

        return restClient.addAutomobile(automobile);
    }

    @Override
    public void removeAutomobile(Long id) {

        restClient = new AutomobileRestClient("http://localhost:8080/journey");

        restClient.removeAutomobile(id);
    }

    @Override
    public void updateAutomobile(Automobile automobile) {

        restClient = new AutomobileRestClient("http://localhost:8080/journey");

        restClient.addAutomobile(automobile);
    }

    @Override
    public Automobile getAutomobileById(Long id) {

        restClient = new AutomobileRestClient("http://localhost:8080/journey");

        return restClient.getAutomobileById(id);
    }

    @Override
    public Automobile getAutomobileByNumber(String number) {

        restClient = new AutomobileRestClient("http://localhost:8080/journey");

        return restClient.getAutomobileByNumber(number);
    }

    @Override
    public Automobile[] getAllAutomobiles() {

        restClient = new AutomobileRestClient("http://localhost:8080/journey");

        return restClient.getAllAutomobiles();
    }
}

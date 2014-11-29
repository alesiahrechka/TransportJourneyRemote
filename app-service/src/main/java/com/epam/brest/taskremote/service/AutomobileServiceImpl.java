package com.epam.brest.taskremote.service;


import com.epam.brest.taskremote.domain.Automobile;

import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by alesya on 20.11.14.
 */

@Service
public class AutomobileServiceImpl implements AutomobileService {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Long addAutomobile(Automobile automobile) {
        AutomobileRestClient automobileRestClient = new AutomobileRestClient("http://localhost:8080");
        return automobileRestClient.addAutomobile(automobile);
    }

    @Override
    public void removeAutomobile(Long id) {
        AutomobileRestClient automobileRestClient = new AutomobileRestClient("http://localhost:8080");
        automobileRestClient.removeAutomobile(id);
    }

    @Override
    public void updateAutomobile(Automobile automobile) {
        AutomobileRestClient automobileRestClient = new AutomobileRestClient("http://localhost:8080");
        automobileRestClient.addAutomobile(automobile);
    }

    @Override
    public Automobile getAutomobileById(Long id) {
        AutomobileRestClient automobileRestClient = new AutomobileRestClient("http://localhost:8080");
        return automobileRestClient.getAutomobileById(id);
    }

    @Override
    public Automobile getAutomobileByNumber(String number) {
        AutomobileRestClient automobileRestClient = new AutomobileRestClient("http://localhost:8080");
        return automobileRestClient.getAutomobileByNumber(number);
    }

    @Override
    public Automobile[] getAllAutomobiles() {
        AutomobileRestClient automobileRestClient = new AutomobileRestClient("http://localhost:8080");
        return automobileRestClient.getAllAutomobiles();
    }
}

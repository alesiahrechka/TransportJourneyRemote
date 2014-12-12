package com.epam.brest.taskremote.service;


import com.epam.brest.taskremote.domain.Automobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * Created by alesya on 20.11.14.
 */

@Service
public class AutomobileServiceImpl implements AutomobileService {

    private static final Logger LOGGER = LogManager.getLogger();

    private String remoteHost;
    private AutomobileRestClient restClient ;
    {
        try {
            remoteHost = readHostFromPropertyFile();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            remoteHost = "";
        }
        restClient = new AutomobileRestClient(remoteHost);
    }

    private static String readHostFromPropertyFile() throws IOException {
        Properties properties = new Properties();
        properties.load(AutomobileServiceImpl.class.getClassLoader()
                .getResourceAsStream("host.properties"));
        return  properties.getProperty("remoteHost");
    }

    @Override
    public Long addAutomobile(Automobile automobile) {
        return restClient.addAutomobile(automobile);
    }

    @Override
    public void removeAutomobile(Long id) {
        restClient.removeAutomobile(id);
    }

    @Override
    public void updateAutomobile(Automobile automobile) {
        restClient.addAutomobile(automobile);
    }

    @Override
    public Automobile getAutomobileById(Long id) {
        return restClient.getAutomobileById(id);
    }

    @Override
    public Automobile getAutomobileByNumber(String number) {
        return restClient.getAutomobileByNumber(number);
    }

    @Override
    public List<Automobile> getAllAutomobiles() {
        return Arrays.asList( restClient.getAllAutomobiles() );
    }
}

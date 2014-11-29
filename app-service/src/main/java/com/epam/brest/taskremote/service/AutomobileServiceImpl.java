package com.epam.brest.taskremote.service;


import com.epam.brest.taskremote.domain.Automobile;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import java.util.List;

/**
 * Created by alesya on 20.11.14.
 */

@Service
public class AutomobileServiceImpl implements AutomobileService {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Long addAutomobile(Automobile automobile) {
        return null;
    }

    @Override
    public void removeAutomobile(Long id) {

    }

    @Override
    public void updateAutomobile(Automobile automobile) {

    }

    @Override
    public Automobile getAutomobileById(Long id) {
        return null;
    }

    @Override
    public Automobile getAutomobileByNumber(String number) {
        return null;
    }

    @Override
    public List<Automobile> getAllAutomobiles() {
        return null;
    }
}

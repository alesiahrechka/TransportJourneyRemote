package com.epam.brest.taskremote.service;

import com.epam.brest.taskremote.domain.AutomobileSummary;
import com.epam.brest.taskremote.domain.Journey;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by alesya on 20.11.14.
 */
@Service
public class JourneyServiceImpl implements JourneyService {

    private static final Logger LOGGER = LogManager.getLogger();

    public static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Long addJourney(Journey journey) {
        return null;
    }

    @Override
    public void removeJourney(Long id) {

    }

    @Override
    public void updateJourney(Journey journey) {

    }

    @Override
    public Journey getJourneyById(Long id) {
        return null;
    }

    @Override
    public List<Journey> getAllJourneys() {
        return null;
    }

    @Override
    public List<Journey> getJourneys(Date date1, Date date2) {
        return null;
    }

    @Override
    public List<Journey> getAllJourneysOfAutomobile(Long automobileId) {
        return null;
    }

    @Override
    public List<Journey> getJourneysOfAutomobile(Long automobileId, Date date1, Date date2) {
        return null;
    }

    @Override
    public List<AutomobileSummary> getAutomobileSummaries() {
        return null;
    }

    @Override
    public List<AutomobileSummary> getAutomobileSummaries(Date date1, Date date2) {
        return null;
    }
}

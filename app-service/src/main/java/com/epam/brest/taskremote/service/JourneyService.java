package com.epam.brest.taskremote.service;

import com.epam.brest.taskremote.domain.AutomobileSummary;
import com.epam.brest.taskremote.domain.Journey;

import java.util.Date;
import java.util.List;

/**
 * Created by alesya on 20.11.14.
 */
public interface JourneyService {

    public Long addJourney(Journey journey);

    public void removeJourney(Long id);

    public void updateJourney(Journey journey);

    public Journey getJourneyById(Long id);

    public List<Journey> getAllJourneys();

    public List<AutomobileSummary> getAutomobileSummaries();

    public List<AutomobileSummary> getAutomobileSummaries(Date date1, Date date2);
}

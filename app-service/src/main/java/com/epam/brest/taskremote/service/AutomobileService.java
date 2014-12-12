package com.epam.brest.taskremote.service;

import com.epam.brest.taskremote.domain.Automobile;

import java.util.List;

/**
 * Created by alesya on 20.11.14.
 */
public interface AutomobileService {

    public Long addAutomobile(Automobile automobile);

    public void removeAutomobile(Long id);

    public void updateAutomobile(Automobile automobile);

    public Automobile getAutomobileById(Long id);

    public Automobile getAutomobileByNumber(String number);

    public List<Automobile> getAllAutomobiles();

}

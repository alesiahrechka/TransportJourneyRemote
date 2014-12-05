package com.epam.brest.taskremote.web;

import com.epam.brest.taskremote.domain.Automobile;
import com.epam.brest.taskremote.domain.Journey;
import com.epam.brest.taskremote.domain.AutomobileSummary;
import com.epam.brest.taskremote.service.AutomobileService;
import com.epam.brest.taskremote.service.JourneyService;
import com.epam.brest.taskremote.service.JourneyService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by alesya on 25.11.14.
 */
@Controller
public class JourneyAutomobileController {

    private static final Logger LOGGER = LogManager.getLogger();

    public static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

    private List<AutomobileSummary> summaries = new ArrayList();
    private String summaryDateRangeMessage = new String();
    private Automobile managedAutomobile = new Automobile();
    private Journey managedJourney = new Journey();

    private void clearSummary(){
        summaries.clear();
        summaryDateRangeMessage ="";
    }

    @Autowired
    private AutomobileService automobileService;

    @Autowired
    private JourneyService journeyService;

    @RequestMapping("/")
    public String init() {
        return "redirect:/dataList";
    }

    @RequestMapping("/dataList")
    public ModelAndView launchDataList() {
        LOGGER.debug("launchDataList");
        Automobile[] automobiles = automobileService.getAllAutomobiles();

        LOGGER.debug("automobiles.size = " + automobiles.length);
        ModelAndView view = new ModelAndView("dataList", "automobiles", automobiles);
        return view;
    }

}

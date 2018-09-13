package edu.iis.mto.bdd.trains.services;

import edu.iis.mto.bdd.trains.model.Line;
import org.joda.time.LocalTime;

import java.util.ArrayList;
import java.util.List;

public class ItineraryService {

    private TimetableService timetableService;

    public ItineraryService(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    public List<LocalTime> findNextDepartures(String departure, String destination, LocalTime startTime) {
        List<LocalTime> arrivalTimes = new ArrayList<>();

        for (Line line : timetableService.findLinesThrough(departure, destination)) {
           for (LocalTime arrivalTime :  timetableService.findArrivalTimes(line, departure)) {
               if (arrivalTime.isAfter(startTime) && arrivalTime.minusMinutes(15).isBefore(startTime)) {
                   arrivalTimes.add(arrivalTime);
               }
           }
        }
        return arrivalTimes;
    }
}

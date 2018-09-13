package edu.iis.mto.bdd.trains.junit;

import edu.iis.mto.bdd.trains.model.Line;
import edu.iis.mto.bdd.trains.services.InMemoryTimetableService;
import edu.iis.mto.bdd.trains.services.ItineraryService;
import edu.iis.mto.bdd.trains.services.TimetableService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import org.joda.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class WhenCalculatingArrivalTimes {

    ItineraryService itineraryService;
    TimetableService timetableService;

    @Before
    public void setUp() {
        timetableService = Mockito.mock(InMemoryTimetableService.class);
        itineraryService = new ItineraryService(timetableService);
    }

    @Test
    public void shouldReturnExpectedArrivalTimes() {

        String departure = "StationA";
        String destination  = "StationB";
        LocalTime startTime = new LocalTime(8,0);

        Line line = Line.named("TestLine").departingFrom("CityA").withStations(departure, destination);
        List<Line> lines = new ArrayList<>();
        lines.add(line);

        List<LocalTime> lineArrivalTimes = new ArrayList<>(
                Arrays.asList(new LocalTime(8,6), new LocalTime(8,10), new LocalTime(8,14), new LocalTime(8,21), new LocalTime(8,35)));

        List<LocalTime> expectedArrivalTimes = new ArrayList<>(Arrays.asList(new LocalTime(8,6), new LocalTime(8,10), new LocalTime(8,14), new LocalTime(8,21)));

        Mockito.when(timetableService.findLinesThrough(departure, destination)).thenReturn(lines);
        Mockito.when(timetableService.findArrivalTimes(line, departure)).thenReturn(lineArrivalTimes);

        assertThat(itineraryService.findNextDepartures(departure, destination, startTime), Matchers.is(expectedArrivalTimes));
    }
}

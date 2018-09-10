package edu.iis.mto.bdd.trains.cucumber.steps;

import cucumber.api.java.pl.*;
import org.joda.time.LocalTime;

import cucumber.api.PendingException;
import cucumber.api.Transform;

public class ArrivalTimeSteps {

    @Zakładając("^chcę się dostać z \"([^\"]*)\" do \"([^\"]*)\"$")
    public void givenIWantToTravel(String departure, String destination) {
        throw new PendingException();

    }

    @I("^następny pociąg odjeżdża o (.*) na linii \"([^\"]*)\"$")
    public void andNextTrainDepartures(@Transform(JodaLocalTimeConverter.class) LocalTime time, String line) {
        throw new PendingException();
    }

    @Gdy("^zapytam o godzinę przyjazdu$")
    public void whenIAskAboutArrivalTime() {
        throw new PendingException();
    }

    @Wtedy("^powinienem uzyskać następujący szacowany czas przyjazdu: (.*)$")
    public void shouldBeInformedAbout(@Transform(JodaLocalTimeConverter.class) LocalTime expectedArrivalTime) {
        throw new PendingException();
    }
}
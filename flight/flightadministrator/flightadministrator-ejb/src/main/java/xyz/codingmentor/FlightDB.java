package xyz.codingmentor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;

import javax.jms.JMSContext;
import javax.jms.Topic;

/**
 *
 * @author mhorvath
 */
@Singleton
public class FlightDB {

    @Inject
    private JMSContext context;
    @Resource(lookup = "jms/flight")
    private Topic topic;
    Map<String, Flight> flightmap = new HashMap<>();

    public void createFlight(Flight flight) {
        flight.setId(UUID.randomUUID().toString());
        flightmap.put(flight.getId(), flight);
        produceMessageToTopic("flight added: " + flight.toString());
    }

    public void updateFlight(Flight flight) {
        flightmap.put(flight.getId(), flight);
        produceMessageToTopic("flight updated to: " + flight.toString());
    }

    public void deleteFlight(String id) {
        
        flightmap.remove(id);
        produceMessageToTopic("flight deleted with id: " + id);
    }

    public List<Flight> listFlighs() {
        return new ArrayList<>(flightmap.values());
    }

    @Schedule(dayOfWeek = "*", month = "*", hour = "*", dayOfMonth = "*", year = "*", minute = "*", second = "*/30", persistent = false)
    private void scheduleCheck() {
        for (Flight flight : flightmap.values()) {
            if (flight.isAdministrated) {
                continue;
            }
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.HOUR, 1);
            Date oneHourLater = cal.getTime();
            if (flight.getDepartureTime().compareTo(oneHourLater) < 0) {
                produceMessageToTopic(flight.toString() + "will take of soon");
                flight.setIsAdministrated(true);
            }
        }
    }

    private void produceMessageToTopic(String message) {

        context.createProducer().send(topic, message);
    }

}

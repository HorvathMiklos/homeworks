
package xyz.codingmentor;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author mhorvath
 */
public class Flight {
    String id;
    String departure;
    String destination;
    
    Date departureTime;
    
    Date arrivalTime;
    boolean isAdministrated;

    public Flight() {
        //Empty on purpose
    }
    
    
    
    public Flight(String departure, String destination, Date departureTime, Date arrivalTime) {
        this.isAdministrated=false;
        this.departure = departure;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public boolean isIsAdministrated() {
        return isAdministrated;
    }

    public void setIsAdministrated(boolean isAdministrated) {
        this.isAdministrated = isAdministrated;
    }
    
    

    @Override
    public String toString() {
        return "Flight{" + "id=" + id + ", departure=" + departure + ", destination=" + destination + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Flight other = (Flight) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}

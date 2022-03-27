package by.it.academy.Mk_JD2_88_22.classwork.storage.hibernate;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
@Entity
@Table( schema = "bookings", name = "flights")
public class FlightsEntity {

    @Id
    @Column(name = "flight_id")
    private int flightId;
        @Column(name = "flight_no")
    private String flightNo;
        @Column(name = "scheduled_departure")
    private LocalDateTime scheduledDeparture;
        @Column(name = "scheduled_arrival")
    private LocalDateTime scheduledArrival;
        @Column(name = "departure_airport")
    private String departureAirport;
        @Column(name = "arrival_airport")
    private String arrivalAirport;
        @Column(name = "status")
    private String status;
        @Column(name = "aircraft_code")
    private String aircraftCode;
        @Column(name = "actual_departure")
    private LocalDateTime actualDeparture;
        @Column(name = "actual_arrival")
    private LocalDateTime actualArrival;


    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public LocalDateTime getScheduledDeparture() {
        return scheduledDeparture;
    }

    public void setScheduledDeparture(LocalDateTime scheduledDeparture) {
        this.scheduledDeparture = scheduledDeparture;
    }

    public LocalDateTime getScheduledArrival() {
        return scheduledArrival;
    }

    public void setScheduledArrival(LocalDateTime scheduledArrival) {
        this.scheduledArrival = scheduledArrival;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAircraftCode() {
        return aircraftCode;
    }

    public void setAircraftCode(String aircraftCode) {
        this.aircraftCode = aircraftCode;
    }

    public LocalDateTime getActualDeparture() {
        return actualDeparture;
    }

    public void setActualDeparture(LocalDateTime actualDeparture) {
        this.actualDeparture = actualDeparture;
    }

    public LocalDateTime getActualArrival() {
        return actualArrival;
    }

    public void setActualArrival(LocalDateTime actualArrival) {
        this.actualArrival = actualArrival;
    }

    @Override
    public String toString() {
        return "Flights{" +
                "flightId=" + flightId +
                ", flightNo='" + flightNo + '\'' +
                ", scheduledDeparture=" + scheduledDeparture +
                ", scheduledArrival=" + scheduledArrival +
                ", departureAirport='" + departureAirport + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", status='" + status + '\'' +
                ", aircraftCode='" + aircraftCode + '\'' +
                ", actualDeparture=" + actualDeparture +
                ", actualArrival=" + actualArrival +
                '}';
    }
}

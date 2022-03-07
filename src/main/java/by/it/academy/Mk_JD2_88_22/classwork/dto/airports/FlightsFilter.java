package by.it.academy.Mk_JD2_88_22.classwork.dto.airports;

import java.time.LocalDateTime;

public class FlightsFilter {
    private String departureAirport;
    private String arrivalAirport;
    private LocalDateTime scheduledDeparture;

    private FlightsFilter(String departureAirport,
                          String arrivalAirport,
                          LocalDateTime scheduledDeparture) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.scheduledDeparture = scheduledDeparture;
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

    public LocalDateTime getScheduledDeparture() {
        return scheduledDeparture;
    }

    public void setScheduledDeparture(LocalDateTime scheduledDeparture) {
        this.scheduledDeparture = scheduledDeparture;
    }

    public static class Builder {
        private String departureAirport;
        private String arrivalAirport;
        private LocalDateTime scheduledDeparture;

        private Builder() {
        }

        public static Builder builder(){
            return new Builder();
        }

        public Builder setDepartureAirport(String departureAirport) {
            this.departureAirport = departureAirport;
            return this;
        }

        public Builder setArrivalAirport(String arrivalAirport) {
            this.arrivalAirport = arrivalAirport;
            return this;
        }

        public Builder setScheduledDeparture(LocalDateTime scheduledDeparture) {
            this.scheduledDeparture = scheduledDeparture;
            return this;
        }

        public FlightsFilter build() {
            return new FlightsFilter(departureAirport, arrivalAirport, scheduledDeparture);
        }
    }
}

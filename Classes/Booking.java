package Classes;

public class Booking
{
    String sourceCity;
    String destinationCity;
    int departure;
    int arrival;
    int nrOfSeats;
    double ticketPrice;
    int id;
    String clientName;

    public Booking(String sourceCity, String destinationCity, int departure, int arrival, int nrOfSeats, double ticketPrice, int id, String clientName) {
        this.sourceCity = sourceCity;
        this.destinationCity = destinationCity;
        this.departure = departure;
        this.arrival = arrival;
        this.nrOfSeats = nrOfSeats;
        this.ticketPrice = ticketPrice;
        this.id = id;
        this.clientName = clientName;
    }

    public String getSourceCity() {
        return sourceCity;
    }

    public void setSourceCity(String sourceCity) {
        this.sourceCity = sourceCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public int getDeparture() {
        return departure;
    }

    public void setDeparture(int departure) {
        this.departure = departure;
    }

    public int getArrival() {
        return arrival;
    }

    public void setArrival(int arrival) {
        this.arrival = arrival;
    }

    public int getNrOfSeats() {
        return nrOfSeats;
    }

    public void setNrOfSeats(int nrOfSeats) {
        this.nrOfSeats = nrOfSeats;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "sourceCity='" + sourceCity + '\'' +
                ", destinationCity='" + destinationCity + '\'' +
                ", departure=" + departure +
                ", arrival=" + arrival +
                ", nrOfSeats=" + nrOfSeats +
                ", ticketPrice=" + ticketPrice +
                ", id=" + id +
                ", clientName='" + clientName + '\'' +
                '}';
    }
}

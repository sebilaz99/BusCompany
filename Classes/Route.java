package Classes;

public class Route
{
    String sourceCity;
    String destCity;
    int departure;
    int arrival;
    int seats;
    int price;
    int id;

    public Route(String sourceCity, String destCity, int departure, int arrival, int seats, int price, int id)
    {
        this.sourceCity = sourceCity;
        this.destCity = destCity;
        this.departure = departure;
        this.arrival = arrival;
        this.seats = seats;
        this.price = price;
        this.id=id;
    }

    public String getSourceCity() {
        return sourceCity;
    }

    public void setSourceCity(String sourceCity) {
        this.sourceCity = sourceCity;
    }

    public String getDestCity() {
        return destCity;
    }

    public void setDestCity(String destCity) {
        this.destCity = destCity;
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

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDuration(int departure,int arrival)
    {
        int duration;
        duration=arrival-departure;
        return duration;
    }
    public int getId() {return id;}

    public void setId(int id) { this.id=id;}


    @Override
    public String toString()
    {
        return "Route{" +
                "sourceCity='" + sourceCity + '\'' +
                ", destCity='" + destCity + '\'' +
                ", departure=" + departure +
                ", arrival=" + arrival +
                ", seats=" + seats +
                ", price=" + price +
                ", id=" + id +
                '}';
    }
}

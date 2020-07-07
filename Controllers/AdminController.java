package Controllers;

import Classes.Booking;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class AdminController
{
    ArrayList<Booking> bookings;

    public AdminController(){
        this.bookings=new ArrayList<>();
    }

    public void add_booking(Booking b){
        this.bookings.add(b);
    }


    public ArrayList<Booking> getBookings(){
        return this.bookings;
    }
    public void sort_bookings(){
        this.bookings=(ArrayList<Booking>) this.bookings.stream().sorted((o1, o2) -> {
            String sort1=""+o1.getDestinationCity()+Integer.toString(o1.getArrival()).length()+o1.getArrival();
            String sort2=""+o2.getDestinationCity()+Integer.toString(o2.getArrival()).length()+o2.getArrival();
            return sort1.compareTo(sort2);
        }).collect(Collectors.toList());
    }

}

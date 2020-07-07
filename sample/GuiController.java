package sample;

import Classes.Booking;
import Classes.Route;
import Controllers.AdminController;
import Controllers.ClientController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class GuiController
{
    ClientController clientController;
    AdminController adminController;

    public GuiController(ClientController clientController, AdminController adminController)
    {
        this.clientController = clientController;
        this.adminController = adminController;
    }

    public  GuiController(){}

//CLIENT
//SOURCE
    @FXML
    private ListView<String> sourceCityList;

    @FXML
    void getSources_handler(ActionEvent event)
    {
        Set<String> sourceSet=new LinkedHashSet<>();
        for(Route r:this.clientController.get_list()){
            sourceSet.add(r.getSourceCity());
        }
        ArrayList<String> source=new ArrayList<>();
        for(String s:sourceSet){
            source.add(s);
        }
        ObservableList<String> obs= FXCollections.observableArrayList(source);
        this.sourceCityList.setItems(obs);
    }

    @FXML
    private Button sourcesB;

//DESTINATION
    @FXML
    private ListView<String> destinationList;

    @FXML
    private Button destinationsB;

    @FXML
    void getDestinations_handler(ActionEvent event)
    {
        String source=this.sourceCityList.getSelectionModel().getSelectedItem();
        ArrayList<Route> aux=this.clientController.get_list_by_source_ctrl(source);
        ArrayList<String> aux2=new ArrayList<>();
        for(Route r:aux){
            aux2.add(r.getDestCity());
        }
        ObservableList<String> obs2=FXCollections.observableArrayList(aux2);
        this.destinationList.setItems(obs2);
    }

//ROUTE
    @FXML
    private Button routesB;

    @FXML
    void getRoutesHandler(ActionEvent event)
    {
        String source=this.sourceCityList.getSelectionModel().getSelectedItem();
        String destination=this.destinationList.getSelectionModel().getSelectedItem();
        ArrayList<Route> routes=this.clientController.get_routes_by_source_destination_ctrl(source,destination);
        ObservableList<Route> obs3=FXCollections.observableArrayList(routes);
        this.routeListCLient.setItems(obs3);
    }

    @FXML
    private ListView<Route> routeListCLient;

    @FXML
    private TextField ticketText;

    @FXML
    private Button buyTicketB;

    @FXML
    void buyTicket_handler(ActionEvent event)
    {
        Route r=this.routeListCLient.getSelectionModel().getSelectedItem();
        int howManyTickets=Integer.parseInt(this.ticketText.getText().toString());
        int finalPrice=r.getPrice()*howManyTickets;
        this.priceText.setText(Double.toString(finalPrice));
        Booking b=new Booking(r.getSourceCity(),r.getDestCity(),r.getDeparture(),r.getArrival(),r.getSeats(),r.getPrice(),r.getId(),this.clientController.getClientName());
        this.adminController.add_booking(b);
        this.adminController.sort_bookings();
    }

    @FXML
    private TextField priceText;

//ADMINR
    @FXML
    private ListView<Booking> bookingList;

    @FXML
    private Button bookingsB;

    @FXML
    void getBookings_handler(ActionEvent event)
    {
        ObservableList<Booking> obs4= FXCollections.observableArrayList(this.adminController.getBookings());
        this.bookingList.setItems(obs4);
    }

   /* @FXML
    private Button chooseSDButton;
*/
   @FXML
   public void initialize()
   {
       ArrayList<String> products = new ArrayList<>();
       for (Route r: this.productRepository.getProducts())
       {
           String prod = p.getId() + " " + p.getBrand() + " " + p.getName() + " " + p.getPrice();
           if(p.getQuantity()==0)
               prod = prod + " Out of stock";
           products.add(prod);
       }
       ObservableList<String> observableList = FXCollections.observableArrayList(products);
       productsListView.setItems(observableList);

//        ObservableList<Product> obs = FXCollections.observableArrayList(this.boughtProducts);
//        shoppingCartListView.setItems(obs);
   }


}

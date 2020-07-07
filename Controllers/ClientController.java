package Controllers;

import Classes.Route;
import Repositories.Repository;

import java.util.ArrayList;

public class ClientController
{
    Repository repository;
    String clientName;

    public ClientController(Repository repo,String clientName){
        this.repository=repo;
        this.clientName=clientName;
    }

    public ArrayList<Route> get_list_by_source_ctrl(String sourceCity){
        return this.repository.get_list_by_source(sourceCity);
    }

    public ArrayList<Route> get_routes_by_source_destination_ctrl(String sourceCity,String destinationCity){
        return this.repository.get_routes_by_source_destination(sourceCity,destinationCity);
    }

    public ArrayList<Route> get_list(){
        return this.repository.getRoutes();
    }

    public String getClientName(){
        return this.clientName;
    }
}
